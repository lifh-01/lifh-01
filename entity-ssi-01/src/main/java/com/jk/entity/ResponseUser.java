/** 
 * <pre>项目名称:test-02 
 * 文件名称:ResponseUser.java 
 * 包名:com.jk.entity 
 * 创建日期:2017年7月19日下午4:58:01 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

/** 
 * <pre>项目名称：test-02    
 * 类名称：ResponseUser    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月19日 下午4:58:01    
 * 修改人：李富豪    
 * 修改时间：2017年7月19日 下午4:58:01    
 * 修改备注：       
 * @version </pre>    
 */
public class ResponseUser extends User{
    private Integer failNum;
    
    private Long    faildate;
	
    public Integer getFailNum() {
		return failNum;
	}
	public void setFailNum(Integer failNum) {
		this.failNum = failNum;
	}
	public Long getFaildate() {
		return faildate;
	}
	public void setFaildate(Long faildate) {
		this.faildate = faildate;
	}
}
