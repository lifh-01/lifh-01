package com.jk.dao;

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
/**
 * 
 * <pre>项目名称：test-02    
 * 类名称：UserDao    
 * 类描述：    Dao接口层
 * 创建人：李富豪  
 * 创建时间：2017年7月20日 下午5:37:29    
 * 修改人：李富豪    
 * 修改时间：2017年7月20日 下午5:37:29    
 * 修改备注：       
 * @version </pre>
 */
public interface UserDao {

	/** <pre>login(用户登陆)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月19日 下午5:05:28    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月19日 下午5:05:28    
	 * 修改备注： 
	 * @param requestUser
	 * @return</pre>    
	 */
	ResponseUser login(RequestUser requestUser);

	/** <pre>queryTreeNodes(查询所有的父节点)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月20日 上午11:19:18    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月20日 上午11:19:18    
	 * 修改备注： 
	 * @param i
	 * @return</pre>    
	 */
	List<Tree> queryTreeNodes(Integer i);

	/** <pre>queryTreeSonCount(查询同步树父节点下的子节点的条数)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月20日 上午11:24:32    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月20日 上午11:24:32    
	 * 修改备注： 
	 * @param id
	 * @return</pre>    
	 */
	Long queryTreeSonCount(Integer id);

	/** <pre>queryUserByUserName(根据用户名查看是否存在该用户)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月20日 下午3:33:03    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月20日 下午3:33:03    
	 * 修改备注： 
	 * @param requestUser
	 * @return</pre>    
	 */
	Long queryUserByUserName(RequestUser requestUser);

	/** <pre>updateUserByUserName(根据用户名来修改登录次数)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月20日 下午6:02:55    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月20日 下午6:02:55    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void updateUserByUserName(ResponseUser responseUser);

	/** <pre>registerUser(用户注册信息保存数据库)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月22日 上午8:56:03    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月22日 上午8:56:03    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void registerUser(RequestUser requestUser);

	/** <pre>queryUserData(加载用户信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月24日 下午1:59:25    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月24日 下午1:59:25    
	 * 修改备注： 
	 * @param requestUser 
	 * @return</pre>    
	 */
	List<ResponseUser> queryUserData(RequestUser requestUser);

	/** <pre>selectUserRoleListJson(加载权限树节点)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月25日 下午7:56:35    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月25日 下午7:56:35    
	 * 修改备注： 
	 * @param requestRole
	 * @return</pre>    
	 */
	List<ResponseRole> selectUserRoleListJson(RequestRole requestRole);

	/** <pre>queryUserCount(这里用一句话描述这个方法的作用)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 上午8:54:47    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 上午8:54:47    
	 * 修改备注： 
	 * @return</pre>    
	 */
	Long queryUserCount();

	/** <pre>deleteUserRoleList(把原有的权限全部删除)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午12:02:29    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午12:02:29    
	 * 修改备注： 
	 * @param userId</pre>    
	 */
	void deleteUserRoleList(RequestRole requestRole);

	/** <pre>insertUserRoleList(批量保存权限数据)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午12:10:50    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午12:10:50    
	 * 修改备注： 
	 * @param requestRoleList</pre>    
	 */
	void insertUserRoleList(List<RequestRole> requestRoleList);

	/** <pre>queryRoleData(查询角色信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午7:41:02    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午7:41:02    
	 * 修改备注： 
	 * @param requestRole
	 * @return</pre>    
	 */
	List<ResponseUser> queryRoleData(RequestRole requestRole);

	/** <pre>queryRoleCount(查询角色信息总条数)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午8:00:26    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午8:00:26    
	 * 修改备注： 
	 * @return</pre>    
	 */
	Long queryRoleCount();

	/** <pre>selectUserRoleListJson(查询角色信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午8:18:51    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午8:18:51    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectUserRoleListJson(MenuRequest menuRequest);

	/** <pre>deleteMenuRoleList(删除用户原有权限在赋予新的权限)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午8:29:44    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午8:29:44    
	 * 修改备注： 
	 * @param requestRole</pre>    
	 */
	void deleteMenuRoleList(MenuRequest menuRequest);

	/** <pre>insertMenuRoleList(给角色赋予新的权限)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午9:06:41    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午9:06:41    
	 * 修改备注： 
	 * @param requestMenuList</pre>    
	 */
	void insertMenuRoleList(List<MenuRequest> requestMenuList);

	/** <pre>selectRoleMenuListJson(查询坐厕菜单树)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午9:37:36    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午9:37:36    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<Map<String, Object>> selectRoleMenuListJson(MenuRequest menuRequest);

	/** <pre>deleteCheckedUser(删除一个用户信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月26日 下午10:17:51    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月26日 下午10:17:51    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void deleteCheckedUser(RequestUser requestUser);

	/** <pre>selectMenuListJson(查询权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午3:25:09    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午3:25:09    
	 * 修改备注： 
	 * @return</pre>    
	 */
	List<MenuResponse> selectMenuListJson();

	/** <pre>selectMenuModle(跳转到加载新增权限信息页面并动态加载下拉列表数据)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午5:16:02    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午5:16:02    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectMenuModle(MenuRequest menuRequest);

	/** <pre>insertMenu(添加权限信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午5:34:16    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午5:34:16    
	 * 修改备注： 
	 * @param menuRequest</pre>    
	 */
	void insertMenu(MenuRequest menuRequest);

	/** <pre>selectUserAccountByUserId(根据用户Id查询单条用户信息)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午8:23:26    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午8:23:26    
	 * 修改备注： 
	 * @param requestUser
	 * @return</pre>    
	 */
	ResponseUser selectUserAccountByUserId(RequestUser requestUser);

	/** <pre>UpdateUser(修改用户)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午8:42:46    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午8:42:46    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void UpdateUser(RequestUser requestUser);

	/** <pre>insertUser(新增用户)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月27日 下午8:42:59    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月27日 下午8:42:59    
	 * 修改备注： 
	 * @param requestUser</pre>    
	 */
	void insertUser(RequestUser requestUser);

	/** <pre>selectUserMenuListJson(登陆成功后去查询该用户的权限菜单树存入redis)   
	 * 创建人：李富豪     
	 * 创建时间：2017年7月28日 下午3:43:24    
	 * 修改人：李富豪       
	 * 修改时间：2017年7月28日 下午3:43:24    
	 * 修改备注： 
	 * @param menuRequest
	 * @return</pre>    
	 */
	List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest);

	/** <pre>queryUserPhotoMd(查询数据库的MD5指纹，是否与所上传的一致)   
	 * 创建人：李富豪     
	 * 创建时间：2017年8月3日 下午5:27:34    
	 * 修改人：李富豪       
	 * 修改时间：2017年8月3日 下午5:27:34    
	 * 修改备注： 
	 * @param requestFiles
	 * @return</pre>    
	 */
	ResponseFiles  queryUserPhotoMd(RequestFiles requestFiles);

	/** <pre>insertFiles(把文件信息保存到数据库)   
	 * 创建人：李富豪     
	 * 创建时间：2017年8月3日 下午5:57:02    
	 * 修改人：李富豪       
	 * 修改时间：2017年8月3日 下午5:57:02    
	 * 修改备注： 
	 * @param requestFiles</pre>    
	 */
	void insertFiles(RequestFiles requestFiles);


	
	

	
	
	
}
