package com.sm.system.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final Logger log = LoggerFactory.getLogger(getClass());
	
    @Autowired
    private MyAuthenticationProvider provider;//自定义验证
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
    	auth.authenticationProvider(provider);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	log.debug("web security config redirect <><>");
    	http.authorizeRequests()
        .antMatchers("/resources/**").permitAll()
        .antMatchers("/static/**").permitAll()
        .antMatchers("/logincss/**").permitAll();
    	http.authorizeRequests()
        .anyRequest().authenticated()
        .and().formLogin().loginPage("/login").failureUrl("/login?error=true").permitAll()
        //将登录失败的url设置为”/login?error=true”(即后缀带?error=true),使前端的thymleaf可以读取Session；
        .and().logout().permitAll();
    	
    	//ALLOW-FROM - Allows you to specify an origin, where the page can be displayed in a frame.
        //SAMEORIGIN - I assume this is what you are looking for, so that the page will be (and can be) displayed in a frame on the same origin as the page itself
        //DENY - is a default value. With this the page cannot be displayed in a frame, regardless of the site attempting to do so.
        http.headers().frameOptions().sameOrigin(); //解决不允许显示在iframe的问题
        http.csrf().disable();
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login").invalidateHttpSession(true);
        http.sessionManagement().maximumSessions(1).maxSessionsPreventsLogin(false).expiredUrl("/login");
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        //将验证过程交给自定义验证工具
        auth.authenticationProvider(provider);
    }
}