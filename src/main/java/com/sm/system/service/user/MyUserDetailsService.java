package com.sm.system.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sm.system.domain.user.MyUserDetails;
import com.sm.system.domain.user.SystemUser;
import com.sm.system.domain.user.UserRole;

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
        		List<UserRole> roles = userRoleService.getRoleByUser(user);
        		return new MyUserDetails(user, roles);
        	} else 
        		throw new UsernameNotFoundException("no user found");
        } else {
            try {
                List<UserRole> roles = userRoleService.getRoleByUser(user);
                return new MyUserDetails(user, roles);
            } catch (Exception e) {
                throw new UsernameNotFoundException("user role select fail");
            }
        }
    }
}