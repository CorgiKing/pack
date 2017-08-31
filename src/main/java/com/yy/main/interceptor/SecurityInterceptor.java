package com.yy.main.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Configuration
@PropertySource("classpath:application.properties")
public class SecurityInterceptor extends HandlerInterceptorAdapter{
	
	@Value("${server.contextPath}")
	private String contentPath;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//不拦截swagger
		String uri = request.getRequestURI();
		if (uri.contains("swagger") || uri.contains("/v2/api-docs")) {
			return super.preHandle(request, response, handler);
		}
		
		HttpSession session = request.getSession();
		//已登录
		if (session.getAttribute("user") != null) {
			return true;
		}
		
		//未登录
		
		String url = contentPath + "/login";
		response.sendRedirect(url);
		return false;
	}

}
