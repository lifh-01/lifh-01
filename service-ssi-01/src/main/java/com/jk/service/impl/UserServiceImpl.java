package com.jk.service.impl;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jk.comm.Constant;
import com.jk.comm.JedisUtil;
import com.jk.comm.JsonUtil;
import com.jk.dao.UserDao;
import com.jk.entity.MenuRequest;
import com.jk.entity.MenuResponse;
import com.jk.entity.RequestFiles;
import com.jk.entity.RequestRole;
import com.jk.entity.RequestUser;
import com.jk.entity.ResponseFiles;
import com.jk.entity.ResponseRole;
import com.jk.entity.ResponseUser;
import com.jk.entity.Tree;
import com.jk.service.UserService;
/**
 * 
 * <pre>项目名称：test-02    
 * 类名称：UserServiceImpl    
 * 类描述：    接口实现类实线UserService
 * 创建人：李富豪  
 * 创建时间：2017年7月20日 下午5:46:01    
 * 修改人：李富豪    
 * 修改时间：2017年7月20日 下午5:46:01    
 * 修改备注：       
 * @version </pre>
 */
@Service
public class UserServiceImpl implements UserService {
     
	
	@Autowired
	private UserDao userDao;
	
	
	
	
	@Override
	public void insertFiles(RequestFiles requestFiles) {
		userDao.insertFiles(requestFiles);
	}
	
	@Override
	public ResponseFiles  queryUserPhotoMd(RequestFiles requestFiles) {
		return userDao.queryUserPhotoMd(requestFiles);
	}
	
	@Override
	public List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest) {
		return userDao.selectUserMenuListJson(menuRequest);
	}
	
	@Override
	public void insertUser(RequestUser requestUser) {
		userDao.insertUser(requestUser);
	}
	
	
	@Override
	public void UpdateUser(RequestUser requestUser) {
		userDao.UpdateUser(requestUser);
	}
	
	@Override
	public ResponseUser selectUserAccountByUserId(RequestUser requestUser) {
		return userDao.selectUserAccountByUserId(requestUser);
	}

	@Override
	public void insertMenu(MenuRequest menuRequest) {
		if(0==menuRequest.getPid()){
			menuRequest.setParent(1);
		}
		userDao.insertMenu(menuRequest);
	}
	
	@Override
	public List<MenuResponse> selectMenuModle(MenuRequest menuRequest) {
		return userDao.selectMenuModle(menuRequest);
	}
	
	@Override
	public List<MenuResponse> selectMenuListJson() {
		return userDao.selectMenuListJson();
	}
	
	@Override
	public void deleteCheckedUser(RequestUser requestUser) {
		userDao.deleteCheckedUser(requestUser);
	}
	
	@Override
	public List<Map<String, Object>> selectRoleMenuListJson(MenuRequest menuRequest) {
		List<Map<String, Object>> treeList = new ArrayList<Map<String, Object>>();
		//从redis缓存中获取权限列表
		String string = JedisUtil.getString("#treeList"+menuRequest.getUserId());
		if(null!=string){
			treeList = JsonUtil.fromJson(string, new ArrayList<Map<String, Object>>(){}.getClass());
		}else{
			//如果没有获取到，则查询数据库，如果查询到了结果，直接返回
			treeList = userDao.selectRoleMenuListJson(menuRequest);
			if (null != treeList && 0 < treeList.size()) {
				//开始调用递归
				treeList = queryTreeListNodes(treeList, menuRequest);
			} else {
				treeList = new ArrayList<Map<String,Object>>();
			}
			//把查询到的数据存在redis上一份
			JedisUtil.setString("#treeList"+menuRequest.getUserId(), JsonUtil.toJsonString(treeList), 600);
		}
		return treeList;
	}
	
	//递归查询树菜单
	private List<Map<String, Object>> queryTreeListNodes(List<Map<String, Object>> treeList, MenuRequest menuRequest) {
		for (Map<String, Object> map : treeList) {
			if ("0".equals(map.get("pid").toString())) {
				//取出ID作为下次查询的pid
				int pid = Integer.valueOf(map.get("id").toString());
				menuRequest.setPid(pid);
				List<Map<String, Object>> queryTreeListNodes = 
						queryTreeListNodes(userDao.selectRoleMenuListJson(menuRequest), menuRequest);
				map.put("nodes", queryTreeListNodes);
			}
		}
		return treeList;
	}
	
	@Override
	public void insertMenuRoleList(List<MenuRequest> requestMenuList) {
		//先删除角色原有的权限
		userDao.deleteMenuRoleList(requestMenuList.get(0));
		//赋予角色新的权限
		userDao.insertMenuRoleList(requestMenuList);
	}
	
	@Override
	public List<MenuResponse> selectUserRoleListJson(MenuRequest menuRequest) {
		
		return userDao.selectUserRoleListJson(menuRequest);
	}
	
	@Override
	public Long queryRoleCount() {
		
		return userDao.queryRoleCount();
	}
	
	@Override
	public List<ResponseUser> queryRoleData(RequestRole requestRole) {
		return userDao.queryRoleData(requestRole);
	}
	
	
	@Override
	public void insertUserRoleList(List<RequestRole> requestRoleList) {
		//添加之前先删除
		userDao.deleteUserRoleList(requestRoleList.get(0));
		//批量添加数据
		userDao.insertUserRoleList(requestRoleList);
	}
	
	@Override
	public List<ResponseRole> selectUserRoleListJson(RequestRole requestRole) {
		return  userDao.selectUserRoleListJson(requestRole);
	}
	
	@Override
	public List<ResponseUser> queryUserData(RequestUser requestUser) {
		return userDao.queryUserData(requestUser);
	}
	
	@Override
	public ResponseUser loadImgUser(RequestUser requestUser) {
		return userDao.login(requestUser);
	}
	
	@Override
	public void registerUser(RequestUser requestUser) {
		userDao.registerUser(requestUser);
	}

	@Override
	public Long queryTreeSonCount(Integer id) {
		return userDao.queryTreeSonCount(id);
	}
	
	@Override
	public List<Tree> queryTreeNodes(Integer i){
		return userDao.queryTreeNodes(i);
	}
		
	@Override
	public Map<String, Object> login(RequestUser requestUser) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("temp", Constant.LOGIN_USERPASSWORD_ERROR);
		map.put("userInfo", null);
		//判断验证码为不为空
		if(null == requestUser.getUserImgCode() || "".equals(requestUser.getUserImgCode())){
			map.put("temp", Constant.LOGIN_IMGCODE_NULL);
		//判断验证码是否正确，正确再去连接数据库
		}else if(requestUser.getUserImgCode().equals(requestUser.getSysImgCode())){
			ResponseUser responseUser=userDao.login(requestUser);
			//判断查询出来的responseUser对象是否为空
			if(responseUser!=null){
			    //判断当前对象是否已经登陆错误3次或者登陆时间已经过去五分钟
				if(responseUser.getFailNum()<3||responseUser.getFaildate()>300000){
			    	//判断当前用户密码是否正确，如果正确就把登陆错误的次数修改为0，再把当前用户信息放入map中
					if(responseUser.getUserPassword().equals(requestUser.getUserPassword())){
			    		map.put("temp", Constant.LOGIN_SUCCESS);
			    		map.put("userInfo", responseUser);
			    		responseUser.setFailNum(0);
					}else{
						//如果密码错误在判断登录时间是否已经大于5分钟，如果大于5分钟就把当前登录次数给修改为1
			    		if(responseUser.getFaildate()>300000){
			    			//密码错误经过5分钟
			    			responseUser.setFailNum(1);		 
				    	}else{
				    		//如果不大于5分钟，修改次数为当前次数加1
				    		responseUser.setFailNum(responseUser.getFailNum()+1);
				    	}
			    	}
					//调用Dao接口修改数据
			    	userDao.updateUserByUserName(responseUser);
			    	//把登陆次数村入map
			    	map.put("flag", responseUser.getFailNum());
			    }else{
			    	//账号被锁定
			    	map.put("temp", Constant.LOGIN_PWD_COUNT);
			    }
			}else{
				//用户名不存在
				map.put("temp", Constant.LOGIN_USERNAME_ERROR);
			}
		}else{
			//验证码错误
			map.put("temp", Constant.LOGIN_IMGCODE_ERROR);
		}
		return map;
	}
	
	@Override
	public Map<String, Object> queryUserByUserName(RequestUser requestUser) {
		// TODO Auto-generated method stub
		Map<String,Object> map = new HashMap<String,Object>();
		Long userNameCount=userDao.queryUserByUserName(requestUser);
		if(userNameCount==0){
			map.put("flag", Constant.CHECKUSER_NAME_FALSE);
		}else{
			map.put("flag", Constant.CHECKUSER_NAME_TRUE);
		}
		return map;
	}
	
	
	@Override
	public Long queryUserCount() {
		return userDao.queryUserCount();
	}
}
