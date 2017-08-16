package com.jk.entity;

import java.io.Serializable;

public class User implements Serializable{
	

	private Integer userId;
	
	private String  userName;
	
	private String  userPassword;
	
	private String  userNameImg;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserNameImg() {
		return userNameImg;
	}

	public void setUserNameImg(String userNameImg) {
		this.userNameImg = userNameImg;
	}
	
}
