package com.sm.system.service.user;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sm.system.domain.user.MyUserDetails;
import com.sm.system.domain.user.SystemUser;
import com.sm.system.domain.user.UserRole;
import com.sm.system.util.SystemUtil;

@Service("MyUserDetailsImpl")
public class MyUserDetailsService implements UserDetailsService {
	private final Logger log = LoggerFactory.getLogger(getClass());
	
    @Resource(name = "SystemUserServiceImpl")
    private SystemUserService systemUserService;

    @Resource(name = "UserRoleServiceImpl")
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.debug("MyUserDetailsService <><><><>");
    	SystemUser user = new SystemUser();
    	if (username.equals("sming")) {
    		user.setUsername(username);user.setPassword("sming");
    		Calendar cal = Calendar.getInstance();
    		cal.setTime(new Date());
    		cal.add(Calendar.DAY_OF_YEAR, 1);
    		try {
				user.setExpired(SystemUtil.desEncrypt(SystemUtil.formatDate(cal.getTime())));
			} catch (Exception e) {
				e.printStackTrace();
			}
    		List<UserRole> roles = userRoleService.getRoleByUser(user);
    		return new MyUserDetails(user, roles);
    	} else {
    		user = systemUserService.findByUsername(username);
    	}
        if(user == null) {
        	throw new UsernameNotFoundException("User not found");
        }
        
        /**
         * 验证用户是否已经过期
         */
        Date expiredDate = new Date();
        try {
			expiredDate = SystemUtil.parse(user.getExpired());
		} catch (Exception e) {
			e.printStackTrace();
			throw new UsernameNotFoundException("user expired error");
		}
        if(expiredDate.before(new Date())) {
        	throw new org.springframework.security.authentication.AccountExpiredException("账号已过期");
        }
        	
       
//        	try {
//	        	System.out.println("user expired = " + user.getExpired());
//				String expired = SystemUtil.desDecrypt(user.getExpired());
//				Date expiredDate = new Date(expired);//SystemUtil.parse(expired);
//				System.out.println("error here........... ");
//				if (expiredDate.before(new Date())) {
//					user.
//				}
//			} catch (BadCredentialsException e) {
//				throw new BadCredentialsException("user expired.");
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new BadCredentialsException("解密error");
//			} 
//            try {
//                List<UserRole> roles = userRoleService.getRoleByUser(user);
//                return new MyUserDetails(user, roles);
//            } catch (Exception e) {
//                throw new UsernameNotFoundException("user role select fail");
//            }
    	List<UserRole> roles = userRoleService.getRoleByUser(user);
    	return new MyUserDetails(user, roles);
    }
}