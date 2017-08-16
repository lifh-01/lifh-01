/** 
 * <pre>项目名称:ssi-common-01 
 * 文件名称:SessionListener.java 
 * 包名:common.listener 
 * 创建日期:2017年7月22日上午11:57:14 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.comm;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/** 
 * <pre>项目名称：ssi-common-01    
 * 类名称：SessionListener    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月22日 上午11:57:14    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月22日 上午11:57:14    
 * 修改备注：       
 * @version </pre>    
 */
public class SessionListener implements HttpSessionListener {
	
	/* (non-Javadoc)    
	 * @see javax.servlet.http.HttpSessionListener#sessionCreated(javax.servlet.http.HttpSessionEvent)    
	 */
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		String id = se.getSession().getId();
		System.out.println("创建了一个session会话：" + id);
	}
	
	/* (non-Javadoc)    
	 * @see javax.servlet.http.HttpSessionListener#sessionDestroyed(javax.servlet.http.HttpSessionEvent)    
	 */
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		
	}

}
