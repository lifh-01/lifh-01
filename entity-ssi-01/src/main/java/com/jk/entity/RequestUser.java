/** 
 * <pre>项目名称:test-02 
 * 文件名称:RequestUser.java 
 * 包名:com.jk.entity 
 * 创建日期:2017年7月19日下午4:50:34 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

/** 
 * <pre>项目名称：test-02    
 * 类名称：RequestUser    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月19日 下午4:50:34    
 * 修改人：李富豪    
 * 修改时间：2017年7月19日 下午4:50:34    
 * 修改备注：       
 * @version </pre>    
 */
public class RequestUser extends User {
     private  String userImgCode;

     private String  sysImgCode;
	
     private Integer pageStart;
 	
     private Integer pageEnd;

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
     
     public String getSysImgCode() {
		 return sysImgCode;
	 }

	 public void setSysImgCode(String sysImgCode) {
		 this.sysImgCode = sysImgCode;
	 }

	 public String getUserImgCode() {
		 return userImgCode;
	 }

	 public void setUserImgCode(String userImgCode) {
		 this.userImgCode = userImgCode;
	 }
} 
