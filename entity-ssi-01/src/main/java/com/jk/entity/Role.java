/** 
 * <pre>项目名称:entity-ssi-01 
 * 文件名称:Role.java 
 * 包名:com.jk.entity 
 * 创建日期:2017年7月25日下午7:47:26 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

import java.io.Serializable;

/** 
 * <pre>项目名称：entity-ssi-01    
 * 类名称：Role    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月25日 下午7:47:26    
 * 修改人：李富豪    
 * 修改时间：2017年7月25日 下午7:47:26    
 * 修改备注：       
 * @version </pre>    
 */
public class Role implements Serializable{
    
	private Integer roleId; 
	
    private String roleName;
	
	private String roleDesc;
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
}
