package com.yy.main.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.yy.main.interceptor.SecurityInterceptor;

@Configuration
public class WebSecurityConfigAdapter extends WebMvcConfigurerAdapter {

	public final static String SESSION_KEY = "user";

	@Autowired
	private SecurityInterceptor securityInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {

		InterceptorRegistration addInterceptor = registry.addInterceptor(securityInterceptor);

		// 排除
		addInterceptor.excludePathPatterns("/error");
		addInterceptor.excludePathPatterns("/login**");

		// 拦截
		addInterceptor.addPathPatterns("/**");
	}

}
