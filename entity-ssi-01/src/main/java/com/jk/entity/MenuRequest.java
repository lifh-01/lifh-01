/** 
 * <pre>项目名称:ssi-pojo-01 
 * 文件名称:MenuRequest.java 
 * 包名:com.jk.pojo.menu 
 * 创建日期:2017年7月26日下午3:38:23 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

/** 
 * <pre>项目名称：ssi-pojo-01    
 * 类名称：MenuRequest    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月26日 下午3:38:23    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月26日 下午3:38:23    
 * 修改备注：       
 * @version </pre>    
 */
public class MenuRequest extends Menu {
	
	private int roleId;
	
	private int userId;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	

}
