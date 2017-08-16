/** 
 * <pre>项目名称:controller-ssi-01 
 * 文件名称:MenuController.java 
 * 包名:com.jk.controller 
 * 创建日期:2017年7月27日下午3:13:07 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jk.entity.MenuRequest;
import com.jk.entity.MenuResponse;
import com.jk.service.UserService;

/** 
 * <pre>项目名称：controller-ssi-01    
 * 类名称：MenuController    
 * 类描述：    
 * 创建人：李富豪  
 * 创建时间：2017年7月27日 下午3:13:07    
 * 修改人：李富豪    
 * 修改时间：2017年7月27日 下午3:13:07    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
public class MenuController {

	@Resource
	private UserService userService;
	
	
	/**
	 * <pre>selectMenuListJson(查询权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午5:08:43    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午5:08:43    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("selectMenuListJson")
	@ResponseBody
	public List<MenuResponse> selectMenuListJson(){
		List<MenuResponse> MenuResponseList=userService.selectMenuListJson();
		return MenuResponseList;
	}
	
	/**
	 * <pre>toAddMenuPage(跳转到加载新增权限信息页面并动态加载下拉列表数据)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午4:52:09    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午4:52:09    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("toAddMenuPage")
	public String toAddMenuPage(Model m){
		List<MenuResponse> MenuResponseList=userService.selectMenuModle(new MenuRequest());
		m.addAttribute("MenuResponseList",MenuResponseList);
		return "add_menu";
	}
	
	/**
	 * <pre>insertMenu(添加权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午5:31:27    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午5:31:27    
	 * 修改备注： 
	 * @return</pre>
	 */
	@RequestMapping("insertMenu")
	@ResponseBody
	public String insertMenu(MenuRequest menuRequest){
		userService.insertMenu(menuRequest);
		return"{}";
	}
	
	
	
	
	
	
	
	
}
