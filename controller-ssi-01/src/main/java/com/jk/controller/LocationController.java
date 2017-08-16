/** 
 * <pre>项目名称:test-02 
 * 文件名称:LocationController.java 
 * 包名:com.jk.controller 
 * 创建日期:2017年7月20日下午5:31:07 
 * Copyright (c) 2017, lxm_man@163.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jk.entity.MenuRequest;
import com.jk.entity.RequestRole;
import com.jk.entity.RequestUser;

/** 
 * <pre>项目名称：test-02    
 * 类名称：LocationController    
 * 类描述：   只为跳转页面的
 * 创建人：李富豪  
 * 创建时间：2017年7月20日 下午5:31:07    
 * 修改人：李富豪    
 * 修改时间：2017年7月20日 下午5:31:07    
 * 修改备注：       
 * @version </pre>    
 */
@Controller
public class LocationController {
     
		/**
		 * <pre>registerUser(跳转到注册页面)   
		 * 创建人：李富豪     
		 * 创建时间：2017年7月20日 下午5:32:13    
		 * 修改人：李富豪       
		 * 修改时间：2017年7月20日 下午5:32:13    
		 * 修改备注： 
		 * @return</pre>
		 */
		@RequestMapping({"registerUser"})
		public String registerUser(){
			return "registerUser";
		}
		
		/**
		 * <pre>toStudent_list(跳转数据展示页面)   
		 * 创建人：李富豪     
		 * 创建时间：2017年7月20日 下午5:34:47    
		 * 修改人：李富豪       
		 * 修改时间：2017年7月20日 下午5:34:47    
		 * 修改备注： 
		 * @return</pre>
		 */
		@RequestMapping("toStudent_list")
	    public String toStudent_list(){
			return "user_tree_show";
		}
		
		/**
		 * <pre>toUserShowList(跳转到展示页面)   
		 * 创建人：李富豪     
		 * 创建时间：2017年7月24日 下午12:17:48    
		 * 修改人：李富豪       
		 * 修改时间：2017年7月24日 下午12:17:48    
		 * 修改备注： 
		 * @return</pre>
		 */
		@RequestMapping("toUserShowList")
		public String toUserShowList(){
			return "user_show_List";
		}
		
		/**
		 * <pre>toUserRolePage(加载到roleEdit页面)   
		 * 创建人：李富豪     
		 * 创建时间：2017年7月25日 下午7:20:22    
		 * 修改人：李富豪       
		 * 修改时间：2017年7月25日 下午7:20:22    
		 * 修改备注： 
		 * @return</pre>
		 */
		@RequestMapping("toUserRolePage")
		public String toUserRolePage(Model m,RequestUser requestUser){
			m.addAttribute("userId",requestUser.getUserId());
			return "roleEdit";
		}
		
		/**
		 * <pre>toRoleShowList(跳转到为角色添加权限页面)   
		 * 创建人：李富豪     
		 * 创建时间：2017年7月26日 下午7:25:35    
		 * 修改人：李富豪       
		 * 修改时间：2017年7月26日 下午7:25:35    
		 * 修改备注： 
		 * @param m
		 * @param requestUser
		 * @return</pre>
		 */
		@RequestMapping("toRoleShowList")
		public String toRoleShowList(Model m,RequestUser requestUser){
			m.addAttribute("userId",requestUser.getUserId());
			return "RoleShowList";
		}
		
		/**
		 * <pre>toRoleMenuPage(跳转到为角色赋权限树页面)   
		 * 创建人：李富豪     
		 * 创建时间：2017年7月27日 下午3:15:57    
		 * 修改人：李富豪       
		 * 修改时间：2017年7月27日 下午3:15:57    
		 * 修改备注： 
		 * @param m
		 * @param menuRequest
		 * @return</pre>
		 */
		@RequestMapping("toRoleMenuPage")
		public String toRoleMenuPage(Model m,MenuRequest menuRequest){
			m.addAttribute("roleId",menuRequest.getRoleId());
			return "roleMenuEdit";
		}
		
		/**
		 * <pre>toMenuShowList(跳转到权限管理页面)   
		 * 创建人：李富豪     
		 * 创建时间：2017年7月27日 下午3:14:32    
		 * 修改人：李富豪       
		 * 修改时间：2017年7月27日 下午3:14:32    
		 * 修改备注： 
		 * @return</pre>
		 */
		@RequestMapping("toMenuShowList")
		public String toMenuShowList(){
			return "menuShowList";
		}
		
		
}
