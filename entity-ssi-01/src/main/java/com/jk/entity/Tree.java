/** 
 * <pre>项目名称:test-02 
 * 文件名称:Tree.java 
 * 包名:com.jk.entity 
 * 创建日期:2017年7月20日上午10:56:00 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.entity;

import java.io.Serializable;
import java.util.List;

/** 
 * <pre>项目名称：test-02    
 * 类名称：Tree    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月20日 上午10:56:00    
 * 修改人：李富豪    
 * 修改时间：2017年7月20日 上午10:56:00    
 * 修改备注：       
 * @version </pre>    
 */
public class Tree implements Serializable{
     private Integer id;
	 private String text;
	 private String url;
	 private Integer pid;
	 private List<Tree>   nodes;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public List<Tree> getNodes() {
		return nodes;
	}
	public void setNodes(List<Tree> nodes) {
		this.nodes = nodes;
	}
	
	@Override
	public String toString() {
		return "Tree [id=" + id + ", text=" + text + ", url=" + url + ", pid=" + pid + ", nodes=" + nodes + "]";
	}
	
	
}    
