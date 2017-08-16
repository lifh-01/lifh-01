/** 
 * <pre>项目名称:entity-ssi-01 
 * 文件名称:ResponseRole.java 
 * 包名:com.jk.entity 
 * 创建日期:2017年7月25日下午7:50:13 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

/** 
 * <pre>项目名称：entity-ssi-01    
 * 类名称：ResponseRole    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月25日 下午7:50:13    
 * 修改人：李富豪    
 * 修改时间：2017年7月25日 下午7:50:13    
 * 修改备注：       
 * @version </pre>    
 */
public class ResponseRole extends Role{
    private Integer id;
	
    private String name;
	
    private Integer pid;
	
    private boolean checked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}
	
	
}
