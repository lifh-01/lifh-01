/** 
 * <pre>项目名称:test-02 
 * 文件名称:MySessionContext.java 
 * 包名:com.jk.comm 
 * 创建日期:2017年7月21日下午6:52:02 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.comm;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonParser;

/** 
 * <pre>项目名称：test-02    
 * 类名称：MySessionContext    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月21日 下午6:52:02    
 * 修改人：李富豪    
 * 修改时间：2017年7月21日 下午6:52:02    
 * 修改备注：       
 * @version </pre>    
 */
public class MySessionContext {
     
	private static Map<String, HttpSession> sessionMap = new HashMap<String, HttpSession>();
	
	public static void addSession(HttpSession session,String userId){
		sessionMap.put(userId, session);
	}
	
	public static void  FailureSession(String userId, HttpSession session){
		HttpSession httpSession = sessionMap.get(userId);
		if(null!=httpSession){
			String json = new Gson().toJson(httpSession);
			boolean Valid = new JsonParser().parse(json)
					.getAsJsonObject().get("session")
					.getAsJsonObject().get("isValid")
					.getAsBoolean();
		    if(Valid&&!httpSession.getId().equals(session.getId())){
		    	httpSession.invalidate();
		    }
		}
	}
}
