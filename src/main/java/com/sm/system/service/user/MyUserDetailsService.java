package com.sm.system.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sm.system.domain.user.MyUserDetails;
import com.sm.system.domain.user.SystemUser;
import com.sm.system.domain.user.UserRole;

@Service("MyUserDetailsImpl")
public class MyUserDetailsService implements UserDetailsService {
    @Resource(name = "SystemUserServiceImpl")
    private SystemUserService systemUserService;

    @Resource(name = "UserRoleServiceImpl")
    private UserRoleService userRoleService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SystemUser user;
        try {
            user = systemUserService.findByUsername(username);
        } catch (Exception e) {
            throw new UsernameNotFoundException("user select fail");
        }
        if(user == null){
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