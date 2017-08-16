/** 
 * <pre>项目名称:test-02 
 * 文件名称:TreeController.java 
 * 包名:com.jk.controller 
 * 创建日期:2017年7月20日上午11:13:30 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.entity.MenuRequest;
import com.jk.entity.MenuResponse;
import com.jk.entity.RequestRole;
import com.jk.entity.RequestUser;
import com.jk.entity.ResponseRole;
import com.jk.entity.Tree;
import com.jk.service.UserService;

/** 
 * <pre>项目名称：test-02    
 * 类名称：TreeController    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月20日 上午11:13:30    
 * 修改人：李富豪    
 * 修改时间：2017年7月20日 上午11:13:30    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
public class TreeController {
	  @Resource
	  private  UserService userService;

	  
	   /**
	    * <pre>selectRoleMenuListJson(查询左侧管理树)   
	    * 创建人：李富豪     
	    * 创建时间：2017年7月26日 下午9:26:52    
	    * 修改人：李富豪       
	    * 修改时间：2017年7月26日 下午9:26:52    
	    * 修改备注： 
	    * @param menuRequest
	    * @return</pre>
	    */
	    @RequestMapping("selectRoleMenuListJson")
		@ResponseBody
		public List<Map<String, Object>> selectRoleMenuListJson(MenuRequest menuRequest) {
	    	List<Map<String, Object>> menuList = userService.selectRoleMenuListJson(menuRequest);
			return menuList;
		}
	  
	  
	  /**
	   * <pre>selectUserRoleListJson(查询权限管理树)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月25日 下午7:43:00    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月25日 下午7:43:00    
	   * 修改备注： </pre>
	   */
	  @ResponseBody
	  @RequestMapping("selectUserRoleListJson")
	  public List<ResponseRole> selectUserRoleListJson(RequestRole requestRole){
		  List<ResponseRole> responseList = userService.selectUserRoleListJson(requestRole);
		  return responseList;
	  }
	 	
	  @RequestMapping("insertUserRoleList")
	  @ResponseBody
	  String insertUserRoleList(@RequestBody List<RequestRole> requestRoleList) {
		  userService.insertUserRoleList(requestRoleList);
		  return "{}";
	  }
}
