<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/bootstrap/comm/Style.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <!-- toolbar -->
	<div id="menu_tb">
		<!-- Single button -->
		<div class="btn-group">
		  <button type="button" class="btn btn-success" onclick="insertUser()">新增</button>
		</div>
	</div>
    <table id="userTable"></table>
</body>
<script type="text/javascript">
		$(function(){
			bootstrapTables();
		}) 
		
		function bootstrapTables(){
			$("#userTable").bootstrapTable({
				 url:'<%=request.getContextPath()%>/queryUserData.jhtml',
				 method:'post',
				 striped: true,  	// 斑马线效果     默认false 
				 //只允许选中一行
				 singleSelect:true,
				 checkbox:true,
				 //选中行是不选中复选框或者单选按钮
				 clickToSelect:true,
				 showToggle:true,                    //是否显示详细视图和列表视图的切换按钮
				 cardView: false,                    //是否显示详细视图
				 uniqueId: "id",                     //每一行的唯一标识，一般为主键列
				 showColumns: true,                  //是否显示所有的列
				 showRefresh: true,                  //是否显示刷新按钮
				 minimumCountColumns: 2, 
				 detailView: false,                  //是否显示父子表
				 //发送到服务器的数据编码类型  
				 contentType:'application/x-www-form-urlencoded;charset=UTF-8',   //数据编码纯文本  offset=0&limit=5
				 toolbar:'#tabToolBar',
				 columns:[    
		                    {
		                    	checkbox:true
							},
							{field:'userId',title:'ID',width:50,},
				           	{field:'userName',title:'用户名',width:50},
							{field:'userPassword',title:'密码',width:100
							}, {
						        field: 'cz',
						        title: '操作',
						        formatter:function(value, row, index) {
						        	var zc_btn_group = '<div class="btn-group">'
						        	+ '<button type="button" class="btn btn-xs btn-success" onclick="UpdatetUser(\'' + row.userId + '\')">编辑</button>'
						        	+ '</div>&nbsp;&nbsp;'
						        	+ '<div class="btn-group">'
						        	+ '<button type="button" class="btn btn-xs btn-danger" onclick="delete_checked_user(\'' + row.userId + '\')">删除</button>'
						        	+ '</div>&nbsp;&nbsp;'
						        	+ '<div class="btn-group">'
						        	+ '<button type="button" class="btn btn-xs btn-success" onclick="edit_user_role(\'' + row.userId + '\')">角色操作</button>'
						        	+ '</div>';
						        	return zc_btn_group;
						        }
							}
				 ],
				//传递参数（*）
				 queryParams: function(params) {
				 	return params;
				 },
				 queryParamsType:"",
				  //分页方式
				 sidePagination:'server',
				 pagination: true,                   //是否显示分页（*）
				 pageNumber: 1,                       //每页的记录行数（*）
				 pageSize: 5,                       //每页的记录行数（*）
				 pageList: [5,6,9,12],//可供选择的每页的行数（*）
			})
		}

		//删除一个用户
		function delete_checked_user(user_id){
			$.ajax({
        		url:"<%=request.getContextPath() %>/deleteCheckedUser.jhtml",
        		data:{userId:user_id},
        		dataType:"json",
        		type:"post",
        		success:function(data) {
        			$("#userTable").bootstrapTable("refresh");
        		},
        	});
		}
		
        //打开dialog弹框加载修改tree
        function edit_user_role(user_id){
        	BootstrapDialog.show({
				title:"用户管理>>用户赋角色",
				message: $('<div></div>').load('<%=request.getContextPath() %>/toUserRolePage.jhtml?userId=' + user_id),
				buttons: [{
	                label: '确定',
	                cssClass:"btn btn-success",
	                action: function(dialogItself){
	                	var role_json_array = get_selection_tree_nodes();
	                	//使用ajax保存结果
	                	$.ajax({
	                		url:"<%=request.getContextPath() %>/insertUserRoleList.jhtml",
	                		data:JSON.stringify(role_json_array),
	                		dataType:"json",
	                		type:"post",
	                		success:function(data) {
	                			//关闭对话框
	                			dialogItself.close();
	                		},
	                		contentType:"application/json"
	                	});
	                }
	            }, {
	                label: '取消',
	                cssClass:"btn btn-danger",
	                action: function(dialogItself){
	                	dialogItself.close();
	                }
	            }]
			});
        }
        
      
      //新增页面
      function insertUser(){
    	  edit_user_update("用户管理>>新增用户","<%=request.getContextPath() %>/insertUser.jhtml")
      }
      
      //修改页面
      function UpdatetUser(user_id){
    	  edit_user_update("用户管理>>修改用户","<%=request.getContextPath() %>/insertUser.jhtml?userId="+user_id)
      }
      
    //打开新增或者修改弹框
        function edit_user_update(title,url){
        	BootstrapDialog.show({
				title:title,
				message: $('<div></div>').load(url),
				buttons: [{
	                label: '确定',
	                cssClass:"btn btn-success",
	                action: function(dialogItself){
	                	//使用ajax保存结果
	                	$.ajax({
	                		url:"<%=request.getContextPath() %>/insertUserOrUpdate.jhtml",
	                		data:$("#save__update_user_form").serialize(),
	                		dataType:"json",
	                		type:"post",
	                		success:function(data) {
	                			$("#userTable").bootstrapTable("refresh");
	                			//关闭对话框
	                			dialogItself.close();
	                		},
	                	});
	                }
	            }, {
	                label: '取消',
	                cssClass:"btn btn-danger",
	                action: function(dialogItself){
	                	dialogItself.close();
	                }
	            }]
			});
        }
        
        

</script>
</html>