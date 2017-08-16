/** 
 * <pre>项目名称:ssi-pojo-01 
 * 文件名称:Menu.java 
 * 包名:com.jk.pojo.menu 
 * 创建日期:2017年7月26日下午3:38:05 
 * Copyright (c) 2017, chenjh123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

/** 
 * <pre>项目名称：ssi-pojo-01    
 * 类名称：Menu    
 * 类描述：    
 * 创建人：陈教授 chenjh123@gmail.com    
 * 创建时间：2017年7月26日 下午3:38:05    
 * 修改人：陈教授 chenjh123@gmail.com     
 * 修改时间：2017年7月26日 下午3:38:05    
 * 修改备注：       
 * @version </pre>    
 */
public class Menu {
	
	private int menuId;
	
	private String url;
	
	private int pid;
	
	private int parent;
	
	private String name;

	private int type;
	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	

}
