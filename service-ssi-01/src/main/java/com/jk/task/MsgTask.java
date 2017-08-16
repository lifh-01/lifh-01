/** 
 * <pre>项目名称:service-ssi-01 
 * 文件名称:MsgTask.java 
 * 包名:com.jk.task 
 * 创建日期:2017年8月1日上午9:47:42 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.task;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/** 
 * <pre>项目名称：service-ssi-01    
 * 类名称：MsgTask    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年8月1日 上午9:47:42    
 * 修改人：李富豪    
 * 修改时间：2017年8月1日 上午9:47:42    
 * 修改备注：       
 * @version </pre>    
 */
@Component
public class MsgTask {
    
	@Scheduled(cron = "0 29 10 * * ?")
	public  void  sayHello(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("YSYNHR》》"+sdf.format(new Date()));
	}
	
	@Scheduled(fixedRate=3000,initialDelay=5000)
	public  void sendMsg(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("Y+S+Y+N+H+R》》"+sdf.format(new Date()));
	}
}
