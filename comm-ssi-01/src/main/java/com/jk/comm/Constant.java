package com.jk.comm;

/**
 * 
 * <pre>项目名称：test-02    
 * 类名称：Constant    
 * 类描述：    登陆常量类
 * 创建人：李富豪  
 * 创建时间：2017年7月19日 下午4:39:21    
 * 修改人：李富豪    
 * 修改时间：2017年7月19日 下午4:39:21    
 * 修改备注：       
 * @version </pre>
 */
public class Constant {
    
	 /**
	  * 验证用户登录成功
	  */
	 public static final Integer LOGIN_SUCCESS=1;

	  /**
	  * 用户名不存在
	  */
	 public static final Integer LOGIN_USERNAME_ERROR=2;

	/**
	  * 密码错误
	  */
	 public static final Integer LOGIN_USERPASSWORD_ERROR=3;
	
	 /**
	  * 验证码错误
	  */
	 public static final Integer LOGIN_IMGCODE_ERROR=4;
	
	 /**
	  * 验证码为空
	  */
	 public static final Integer LOGIN_IMGCODE_NULL=5;
	 
	 /**
	  * 用户名已存在
	  */
	 public static final Integer CHECKUSER_NAME_TRUE=1;
	 
	 /**
	  * 用户名可用
	  */
	 public static final Integer CHECKUSER_NAME_FALSE=2;
	 
	 /**
	  * 锁定五分钟后再试
	  */
	 public static final Integer LOGIN_PWD_COUNT=6;
	 
	 /**
	  * 账号以解锁
	  */
	 public static final Integer LOGIN_PWD_DISPACK=7;
}
