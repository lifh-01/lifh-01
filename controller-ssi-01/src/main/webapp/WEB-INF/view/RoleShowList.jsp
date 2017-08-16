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
    <table id="userTable"></table>
</body>
<script type="text/javascript">
		$(function(){
			bootstrapTables();
		}) 
		
		function bootstrapTables(){
			$("#userTable").bootstrapTable({
				 url:'<%=request.getContextPath()%>/queryRoleData.jhtml',
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
							{field:'roleId',title:'ID',width:50,},
				           	{field:'roleName',title:'角色名',width:50},
							{field:'roleDesc',title:'角色描述',width:100},
							 {
						        field: 'cz',
						        title: '操作',
						        formatter:function(value, row, index) {
						        	var zc_btn_group = '<div class="btn-group">'
						        	+ '<button type="button" class="btn btn-xs btn-success" onclick="show_edit_dialog(\'' + row.bookID + '\')">编辑</button>'
						        	+ '</div>&nbsp;&nbsp;'
						        	+ '<div class="btn-group">'
						        	+ '<button type="button" class="btn btn-xs btn-danger" onclick="delete_checked_book(\'' + row.bookID + '\')">删除</button>'
						        	+ '</div>&nbsp;&nbsp;'
						        	+ '<div class="btn-group">'
						        	+ '<button type="button" class="btn btn-xs btn-success" onclick="edit_user_role(\'' + row.roleId + '\')">权限操作</button>'
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
				 pageSize: 2,                       //每页的记录行数（*）
				 pageList: [2,6,9,12],//可供选择的每页的行数（*）
			})
		}

        //打开dialog弹框加载修改tree
        function edit_user_role(role_id){
        	BootstrapDialog.show({
				title:"角色管理>>用角色赋权限",
				message: $('<div></div>').load('<%=request.getContextPath() %>/toRoleMenuPage.jhtml?roleId=' + role_id),
				buttons: [{
	                label: '确定',
	                cssClass:"btn btn-success",
	                action: function(dialogItself){
	                	var role_json_array = get_selection_tree_nodes();
	                	//使用ajax保存结果
	                	$.ajax({
	                		url:"<%=request.getContextPath() %>/insertMenuRoleList.jhtml",
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
</script>
</html>