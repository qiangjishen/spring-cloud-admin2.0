package cn.cnnic.springcloudoauthorserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import cn.cnnic.springcloudoauthorserver.filter.JWTAuthenticationFilter;
import cn.cnnic.springcloudoauthorserver.filter.JWTLoginFilter;
import cn.cnnic.springcloudoauthorserver.user.service.CustomAuthenticationProvider;


/**
 * 
 * @author jessen qiang
 *
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/***具体的验证逻辑***/
	private UserDetailsService userDetailsService;

	/****密码加密*****/
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//关闭默认认证方式
		http.cors().and().csrf().disable()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
        .antMatchers("/users/signup").permitAll()
        .anyRequest().authenticated()  // 所有请求需要身份认证
        .and()
        .addFilter(new JWTLoginFilter(authenticationManager()))
        .addFilter(new JWTAuthenticationFilter(authenticationManager()))
        .logout() // 默认注销行为为logout，可以通过下面的方式来修改
        .logoutUrl("/logout")
        .logoutSuccessUrl("/login")
        .permitAll();// 设置注销成功后跳转页面，默认是跳转到登录页面;
	}	

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		 // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(userDetailsService,bCryptPasswordEncoder));

	}

}