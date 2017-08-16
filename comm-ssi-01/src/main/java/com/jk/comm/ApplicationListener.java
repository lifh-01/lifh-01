/** 
 * <pre>项目名称:ssi-common-01 
 * 文件名称:ApplicationListener.java 
 * 包名:common.listener 
 * 创建日期:2017年7月22日下午12:02:33 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.comm;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/** 
 * <pre>项目名称：ssi-common-01    
 * 类名称：ApplicationListener    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月22日 下午12:02:33    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月22日 下午12:02:33    
 * 修改备注：       
 * @version </pre>    
 */
public class ApplicationListener implements ServletContextListener {
	
	/* (non-Javadoc)    
	 * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)    
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("周末把过滤器和监听器都练会，练不会腿打断");
	}

	/* (non-Javadoc)    
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)    
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}
}
