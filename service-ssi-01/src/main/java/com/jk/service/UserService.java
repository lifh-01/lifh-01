package com.jk.service;

import java.util.List;
import java.util.Map;

import com.jk.entity.MenuRequest;
import com.jk.entity.MenuResponse;
import com.jk.entity.RequestFiles;
import com.jk.entity.RequestRole;
import com.jk.entity.RequestUser;
import com.jk.entity.ResponseFiles;
import com.jk.entity.ResponseRole;
import com.jk.entity.ResponseUser;
import com.jk.entity.Tree;
import com.jk.entity.User;

public interface UserService {

    /**
     * <pre>login(用户登录)   
     * 创建人：李富豪     
     * 创建时间：2017年7月20日 下午5:42:47    
     * 修改人：李富豪       
     * 修改时间：2017年7月20日 下午5:42:47    
     * 修改备注： 
     * @param requestUser
     * @return</pre>
     */
	Map<String, Object> login(RequestUser requestUser);

	/**
	 * <pre>queryTreeNodes(查询所有的父节点)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月20日 下午5:42:52    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月20日 下午5:42:52    
	 * 修改备注： 
	 * @param i
	 * @return</pre>
	 */
	List<Tree> queryTreeNodes(Integer i);

	/**
	 * <pre>queryTreeSonCount(查询所有父节点下的子节点的条数)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月20日 下午5:42:56    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月20日 下午5:42:56    
	 * 修改备注： 
	 * @param id
	 * @return</pre>
	 */
	Long queryTreeSonCount(Integer id);

	/**
	 * <pre>queryUserByUserName(根据用户名查看是否存在该用户)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月20日 下午5:43:00    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月20日 下午5:43:00    
	 * 修改备注： 
	 * @param requestUser
	 * @return</pre>
	 */
	Map<String, Object> queryUserByUserName(RequestUser requestUser);

	/** <pre>registerUser(用户注册信息保存到数据库)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月22日 上午8:55:29    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月22日 上午8:55:29    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void registerUser(RequestUser requestUser);

	/** <pre>loadImgUser(加载用户头像)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月24日 上午8:27:45    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月24日 上午8:27:45    
	 * 修改备注： 
	 * @param requestUser
	 * @return</pre>    
	 */
	ResponseUser loadImgUser(RequestUser requestUser);

	/** <pre>queryUserData(加载用户信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月24日 下午1:58:39    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月24日 下午1:58:39    
	 * 修改备注： 
	 * @param requestUser 
	 * @return</pre>    
	 */
	List<ResponseUser> queryUserData(RequestUser requestUser);
	

	/** <pre>selectUserRoleListJson(这里用一句话描述这个方法的作用)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月25日 下午7:54:06    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月25日 下午7:54:06    
	 * 修改备注： 
	 * @param requestRole
	 * @return</pre>    
	 */
	List<ResponseRole> selectUserRoleListJson(RequestRole requestRole);

	/** <pre>queryUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 上午8:54:10    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 上午8:54:10    
	 * 修改备注： 
	 * @return</pre>    
	 */
	Long queryUserCount();

	/** <pre>insertUserRoleList(保存权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午12:00:21    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午12:00:21    
	 * 修改备注： 
	 * @param requestRoleList</pre>    
	 */
	void insertUserRoleList(List<RequestRole> requestRoleList);

	/** <pre>queryRoleData(查询角色信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午7:40:12    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午7:40:12    
	 * 修改备注： 
	 * @param requestRole
	 * @return</pre>    
	 */
	List<ResponseUser> queryRoleData(RequestRole requestRole);

	/** <pre>queryRoleCount(查询角色信息总条数)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午7:59:39    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午7:59:39    
	 * 修改备注： 
	 * @return</pre>    
	 */
	Long queryRoleCount();

	/** <pre>selectUserRoleListJson(加载角色权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午8:18:05    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午8:18:05    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectUserRoleListJson(MenuRequest menuRequest);

	/** <pre>insertMenuRoleList(给角色赋权限)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午8:28:30    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午8:28:30    
	 * 修改备注： 
	 * @param requestMenuList</pre>    
	 */
	void insertMenuRoleList(List<MenuRequest> requestMenuList);

	/** <pre>selectRoleMenuListJson(查询左侧管理树)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午9:27:28    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午9:27:28    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	 public  List<Map<String, Object>> selectRoleMenuListJson(MenuRequest menuRequest);

	/** <pre>deleteCheckedUser(删除一个用户信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午10:16:07    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午10:16:07    
	 * 修改备注： </pre>    
	 * @param requestUser 
	 */
	void deleteCheckedUser(RequestUser requestUser);

	/** <pre>selectMenuListJson(查询权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午3:24:21    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午3:24:21    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<MenuResponse> selectMenuListJson();

	/** <pre>selectMenuModle(跳转到加载新增权限信息页面并动态加载下拉列表数据)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午5:15:11    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午5:15:11    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectMenuModle(MenuRequest menuRequest);

	/** <pre>insertMenu(添加权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午5:32:33    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午5:32:33    
	 * 修改备注： 
	 * @param menuRequest</pre>    
	 */
	void insertMenu(MenuRequest menuRequest);

	/** <pre>selectUserAccountByUserId(根据用户Id查询用户)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午8:22:34    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午8:22:34    
	 * 修改备注： 
	 * @param requestUser
	 * @return</pre>    
	 */
	ResponseUser selectUserAccountByUserId(RequestUser requestUser);

	/** <pre>UpdateUser(修改用户)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午8:40:59    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午8:40:59    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void UpdateUser(RequestUser requestUser);

	/** <pre>insertUser(添加用户)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午8:41:50    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午8:41:50    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void insertUser(RequestUser requestUser);

	/** <pre>selectUserMenuListJson(登陆成功后去查询该用户的权限菜单树存入redis)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月28日 下午3:41:51    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月28日 下午3:41:51    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest);

	/** <pre>queryUserPhotoMd(查询数据库的MD5指纹，是否与所上传的一致)   
	 * 创建人：李富豪     
	 * 创建时间：2017年8月3日 下午5:21:56    
	 * 修改人：李富豪       
	 * 修改时间：2017年8月3日 下午5:21:56    
	 * 修改备注： 
	 * @param setFileFingerprint
	 * @return</pre>    
	 */
	ResponseFiles  queryUserPhotoMd(RequestFiles requestFiles);

	/** <pre>insertFiles(把文件信息保存到数据库)   
	 * 创建人：李富豪     
	 * 创建时间：2017年8月3日 下午5:56:19    
	 * 修改人：李富豪       
	 * 修改时间：2017年8月3日 下午5:56:19    
	 * 修改备注： 
	 * @param requestFiles</pre>    
	 */
	void insertFiles(RequestFiles requestFiles);

	

	

	

	
	
}
