/** 
 * <pre>项目名称:controller-ssi-01 
 * 文件名称:RoleController.java 
 * 包名:com.jk.controller 
 * 创建日期:2017年7月26日下午7:29:15 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.util.HashMap;
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
import com.jk.entity.ResponseUser;
import com.jk.service.UserService;

/** 
 * <pre>项目名称：controller-ssi-01    
 * 类名称：RoleController    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月26日 下午7:29:15    
 * 修改人：李富豪    
 * 修改时间：2017年7月26日 下午7:29:15    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
public class RoleController {
	
	  @Resource
	  private UserService userService;
	
	  /**
	   * <pre>queryRoleData(查询角色信息)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月26日 下午8:13:11    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月26日 下午8:13:11    
	   * 修改备注： 
	   * @param pageNumber
	   * @param pageSize
	   * @param requestRole
	   * @return</pre>
	   */
	  @RequestMapping("queryRoleData")
	  @ResponseBody
	  public Map<String,Object> queryRoleData(String pageNumber,String pageSize, RequestRole requestRole){
		   Integer pageNumbers = Integer.parseInt(pageNumber);
	       Integer pageSizes = Integer.parseInt(pageSize);
		   //开始位置
	       requestRole.setPageStart(pageSizes*(pageNumbers-1)+1);
		   //结束位置
	       requestRole.setPageEnd(pageSizes*pageNumbers);
	  
	  
		   //分页查询结果
		   List<ResponseUser> responseList = userService.queryRoleData(requestRole);
		   Long count =userService.queryRoleCount();
		   Map<String,Object> map = new HashMap<String,Object>();
		   map.put("total", count);
		   map.put("rows", responseList);
		   return map;
	}


	  /**
	   * <pre>selectRoleMeunListJson(加载角色权限信息)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月26日 下午8:26:45    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月26日 下午8:26:45    
	   * 修改备注： 
	   * @param menuRequest
	   * @return</pre>
	   */
	  @ResponseBody
	  @RequestMapping("selectRoleMeunListJson")
	  public List<MenuResponse> selectRoleMeunListJson(MenuRequest menuRequest){
		  List<MenuResponse> responseList = userService.selectUserRoleListJson(menuRequest);
		  return responseList;
	  }
	
	  
	  /**
	   * <pre>insertMenuRoleList(给角色赋权限)   
	   * 创建人：李富豪     
	   * 创建时间：2017年7月26日 下午8:28:16    
	   * 修改人：李富豪       
	   * 修改时间：2017年7月26日 下午8:28:16    
	   * 修改备注： 
	   * @param requestMenuList
	   * @return</pre>
	   */
	  @RequestMapping("insertMenuRoleList")
	  @ResponseBody
	  public String insertMenuRoleList(@RequestBody List<MenuRequest> requestMenuList) {
		  userService.insertMenuRoleList(requestMenuList);
		  return "{}";
	  }
	  
	
}
