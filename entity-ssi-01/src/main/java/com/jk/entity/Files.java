/** 
 * <pre>项目名称:entity-ssi-01 
 * 文件名称:Files.java 
 * 包名:com.jk.entity 
 * 创建日期:2017年8月3日下午5:10:21 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

/** 
 * <pre>项目名称：entity-ssi-01    
 * 类名称：Files    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年8月3日 下午5:10:21    
 * 修改人：李富豪    
 * 修改时间：2017年8月3日 下午5:10:21    
 * 修改备注：       
 * @version </pre>    
 */
public class Files {
	
    private String fileId;
    
	private String fileHref;
	
	private String fileName;
	
	private String fileFingerprint;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileHref() {
		return fileHref;
	}

	public void setFileHref(String fileHref) {
		this.fileHref = fileHref;
	}

	public String getFileFingerprint() {
		return fileFingerprint;
	}

	public void setFileFingerprint(String fileFingerprint) {
		this.fileFingerprint = fileFingerprint;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
