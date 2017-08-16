/** 
 * <pre>项目名称:ssi-common-01 
 * 文件名称:RequestListener.java 
 * 包名:common.listener 
 * 创建日期:2017年7月22日上午11:51:44 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.comm;

import javax.servlet.ServletRequestEvent;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextListener;

/** 
 * <pre>项目名称：ssi-common-01    
 * 类名称：RequestListener    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月22日 上午11:51:44    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月22日 上午11:51:44    
 * 修改备注：       
 * @version </pre>    
 */
public class RequestListener extends RequestContextListener {

	/* (non-Javadoc)    
	 * @see org.springframework.web.context.request.RequestContextListener#requestInitialized(javax.servlet.ServletRequestEvent)    
	 */
	@Override
	public void requestInitialized(ServletRequestEvent requestEvent) {
		HttpServletRequest servletRequest = (HttpServletRequest) requestEvent.getServletRequest();
		System.out.println("用户创建了一个请求：" + servletRequest.getRequestURI());
	}
}
