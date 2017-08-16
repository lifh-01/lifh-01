package com.jk.dao.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
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
import com.jk.entity.User;
import com.sun.org.apache.xml.internal.dtm.ref.IncrementalSAXSource;
/**
 * 
 * <pre>项目名称：test-02    
 * 类名称：UserDaoImpl    
 * 类描述：  Dao实现类  
 * 创建人：李富豪  
 * 创建时间：2017年7月20日 下午5:38:42    
 * 修改人：李富豪    
 * 修改时间：2017年7月20日 下午5:38:42    
 * 修改备注：       
 * @version </pre>
 */
@Repository
public class UserDaoImpl extends SqlMapClientDaoSupport implements UserDao {


		
	
	@Override
	public void insertFiles(RequestFiles requestFiles) {
		getSqlMapClientTemplate().insert("t_user.insertFiles",requestFiles);
	}

	@Override
	public ResponseFiles queryUserPhotoMd(RequestFiles requestFiles) {
		ResponseFiles responseFiles =  (ResponseFiles) getSqlMapClientTemplate().queryForObject("t_user.queryUserPhotoMd",requestFiles);
		return responseFiles;
	}
	
	@Override
	public List<MenuResponse> selectUserMenuListJson(MenuRequest menuRequest) {
		return getSqlMapClientTemplate().queryForList("t_user.selectUserMenuListJson",menuRequest);
	}
	
	@Override
	public void insertUser(RequestUser requestUser) {
		getSqlMapClientTemplate().insert("t_user.insertUser",requestUser);
	}
	
	
	@Override
	public void UpdateUser(RequestUser requestUser) {
		getSqlMapClientTemplate().update("t_user.UpdateUser",requestUser);
	}
	
	@Override
	public ResponseUser selectUserAccountByUserId(RequestUser requestUser) {
		return (ResponseUser) getSqlMapClientTemplate().queryForObject("t_user.selectUserAccountByUserId",requestUser);
	}
	
	@Override
	public void insertMenu(MenuRequest menuRequest) {
		getSqlMapClientTemplate().insert("menu.insertMenu",menuRequest);
	}
	
	@Override
	public List<MenuResponse> selectMenuModle(MenuRequest menuRequest) {
		return getSqlMapClientTemplate().queryForList("menu.selectMenuModle",menuRequest);
	}
	
	@Override
	public List<MenuResponse> selectMenuListJson() {
		return getSqlMapClientTemplate().queryForList("menu.selectMenuListJson");
	}
	
	@Override
	public void deleteCheckedUser(RequestUser requestUser) {
		getSqlMapClientTemplate().delete("t_user.deleteCheckedUser",requestUser);
	}
	
	@Override
	public List<Map<String, Object>> selectRoleMenuListJson(MenuRequest menuRequest) {
		return getSqlMapClientTemplate().queryForList("tree.selectTreeListJson",menuRequest);
	}
	
	@Override
	public void insertMenuRoleList(final List<MenuRequest> requestMenuList) {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor sqlMap) throws SQLException {
				sqlMap.startBatch();
				for (MenuRequest menuRequest : requestMenuList) {
					sqlMap.insert("role.insertMenuRoleList",menuRequest);
				}
				sqlMap.executeBatch();
				return null;
			}
		});
	}
	
	@Override
	public void deleteMenuRoleList(MenuRequest menuRequest) {
		getSqlMapClientTemplate().delete("role.deleteMenuRoleList",menuRequest);
		
	}
	
	@Override
	public List<MenuResponse> selectUserRoleListJson(MenuRequest menuRequest) {
		
		return getSqlMapClientTemplate().queryForList("role.selectRoleMenuListJson",menuRequest);
	}
 	
 	@Override
 	public Long queryRoleCount() {
 		
 		return (Long) getSqlMapClientTemplate().queryForObject("role.queryRoleCount");
 	}
	
	@Override
	public List<ResponseUser> queryRoleData(RequestRole requestRole) {
		
		return getSqlMapClientTemplate().queryForList("role.queryRoleData",requestRole);
	}
	
	@Override
	public void insertUserRoleList( final List<RequestRole> requestRoleList) {
		getSqlMapClientTemplate().execute(new SqlMapClientCallback<Object>() {

			@Override
			public Object doInSqlMapClient(SqlMapExecutor sqlMap) throws SQLException {
				sqlMap.startBatch();
				for (RequestRole requestRole : requestRoleList) {
					sqlMap.insert("role.insertUserRoleList",requestRole);
				}
				sqlMap.executeBatch();
				return null;
			}
		});
	}
	
	@Override
	public void deleteUserRoleList(RequestRole requestRole) {
		getSqlMapClientTemplate().delete("role.deleteUserRoleList",requestRole);		
	}
	
	@Override
	public List<ResponseRole> selectUserRoleListJson(RequestRole requestRole) {
		return getSqlMapClientTemplate().queryForList("role.selectUserRoleListJson",requestRole);
	}
	
	public List<ResponseUser> queryUserData(RequestUser requestUser) {
		return getSqlMapClientTemplate().queryForList("t_user.queryUserData",requestUser);
	}

	public void registerUser(RequestUser requestUser) {
		getSqlMapClientTemplate().insert("t_user.registerUser",requestUser);
	}
	
	public void updateUserByUserName(ResponseUser responseUser) {
		getSqlMapClientTemplate().update("t_user.updateUserByUserName",responseUser);
	}
	
	public Long queryTreeSonCount(Integer id) {
		Long object = (Long) getSqlMapClientTemplate().queryForObject("tree.selectTreeSonCount",id);
		return object;
	}
	
	@SuppressWarnings("unchecked")
	public List<Tree> queryTreeNodes(Integer i) {
		return getSqlMapClientTemplate().queryForList("tree.selectTreeNodes",i);
	}
		
	public ResponseUser login(RequestUser requestUser) {
		return (ResponseUser) getSqlMapClientTemplate().queryForObject("t_user.login",requestUser);
		
	}
	
	public Long queryUserByUserName(RequestUser requestUser) {
		Long count = (Long) getSqlMapClientTemplate().queryForObject("t_user.checkUserNameCount",requestUser);
		return count;
	}
	
	@Override
	public Long queryUserCount() {
		// TODO Auto-generated method stub
		return (Long) getSqlMapClientTemplate().queryForObject("t_user.queryUserCount");
	}

}
