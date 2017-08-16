/** 
 * <pre>项目名称:entity-ssi-01 
 * 文件名称:RequestRole.java 
 * 包名:com.jk.entity 
 * 创建日期:2017年7月25日下午7:49:10 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

/** 
 * <pre>项目名称：entity-ssi-01    
 * 类名称：RequestRole    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月25日 下午7:49:10    
 * 修改人：李富豪    
 * 修改时间：2017年7月25日 下午7:49:10    
 * 修改备注：       
 * @version </pre>    
 */
public class RequestRole extends Role{
    private Integer userId;

    private Integer pageStart;
    
    private Integer pageEnd;
    
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getPageStart() {
		return pageStart;
	}

	public void setPageStart(Integer pageStart) {
		this.pageStart = pageStart;
	}

	public Integer getPageEnd() {
		return pageEnd;
	}

	public void setPageEnd(Integer pageEnd) {
		this.pageEnd = pageEnd;
	}
}
