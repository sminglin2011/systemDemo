package com.sm.system.security;

import java.text.ParseException;
import java.util.Collection;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.sm.system.domain.user.MyUserDetails;
import com.sm.system.domain.user.SystemUser;
import com.sm.system.service.user.MyUserDetailsService;
import com.sm.system.util.SystemUtil;

@Component
public class MyAuthenticationProvider implements AuthenticationProvider {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private MyUserDetailsService userService;

    /**
     * 自定义验证方式
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    	log.debug("自定义验证方式");
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        MyUserDetails user = (MyUserDetails) userService.loadUserByUsername(username);
        if (user == null) {
        	throw new UsernameNotFoundException("User not found");
		}

        if (!user.isEnabled()){  
            throw new DisabledException("用户已被禁用");  
        }else if (!user.isAccountNonExpired()) {  
            throw new org.springframework.security.authentication.AccountExpiredException("账号已过期");  
        }else if (!user.isAccountNonLocked()) {  
            throw new LockedException("账号已被锁定");  
        }else if (!user.isCredentialsNonExpired()) {  
            throw new LockedException("凭证已过期");  
        }
        
        //加密过程在这里体现
        if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Wrong password.");
        }
        
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> arg0) {
        return true;
    }

}