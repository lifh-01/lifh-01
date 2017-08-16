/** 
 * <pre>项目名称:ssi-common-01 
 * 文件名称:ParamFilter.java 
 * 包名:common.filter 
 * 创建日期:2017年7月22日上午11:37:50 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.comm;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/** 
 * <pre>项目名称：ssi-common-01    
 * 类名称：ParamFilter    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月22日 上午11:37:50    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月22日 上午11:37:50    
 * 修改备注：       
 * @version </pre>    
 */
public class ParamFilter implements Filter {
	
	/* (non-Javadoc)    
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)    
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("欢迎来到王者农药");
		
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		System.out.println(httpRequest.getSession().getId());
		
		//调用这个方法，让请求延续
		chain.doFilter(request, response);
	}
	
	/* (non-Javadoc)    
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)    
	 */
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}
	
	/* (non-Javadoc)    
	 * @see javax.servlet.Filter#destroy()    
	 */
	@Override
	public void destroy() {
		
	}

}
