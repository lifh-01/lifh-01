package com.jk.comm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.alibaba.druid.util.StringUtils;

public class Interceptor extends HandlerInterceptorAdapter{
     
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(handler.toString());
		HttpSession session = request.getSession();
		Object object = session.getAttribute("userInfo");
		if(null!=object){
			return true;
		}else{
			// 重定向
			String type = request.getHeader("X-Requested-With");// XMLHttpRequest
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort()+ path + "/";
			// 转发
			if (StringUtils.equals("XMLHttpRequest", type)) {
				// ajax请求
				response.setHeader("SESSIONSTATUS", "TIMEOUT");
				response.setHeader("CONTEXTPATH", basePath+"index.jsp");
				response.setStatus(HttpServletResponse.SC_FORBIDDEN);
				return false;
			}else {
				response.sendRedirect(request.getContextPath()+"/index.jsp");
			}
			return false;
		}
	}
}
