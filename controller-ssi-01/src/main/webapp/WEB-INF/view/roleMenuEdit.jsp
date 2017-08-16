<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/zTree_v3-master/css/zTreeStyle/zTreeStyle.css" type="text/css">
<script type="text/javascript" src="<%=request.getContextPath() %>/zTree_v3-master/js/jquery.ztree.all.min.js"></script>
</head>
<body>
	
	<div id="treeDemo" class="ztree"></div>
	
	<script type="text/javascript">
		//定义一个ztree对象
		var zTreeObj;
		// zTree 的参数配置
		var setting = {
				check: {
					//chkStyle: "radio",
					enable: true
				},
				data: {
					simpleData: {
						enable: true,
						idKey: "id",
						pIdKey: "pid",
						rootPId: 0
					}
				}
	   };
	   // zTree 的数据属性
	   var zNodes = [
	                
	                ];
	   
	   //页面加载完成进行ztree初始化
	   $(function() {
		   //ajax请求从后台获取树
		   $.ajax({
			   url:"<%=request.getContextPath() %>/selectRoleMeunListJson.jhtml",
			   data:{roleId:"${roleId}"},
			   dataType:"json",
			   type:"post",
			   success:function(data) {
				   zNodes = data;
				   zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
			   }
		   });
	   })
	   
	 //获取被选中的树节点
	   function get_selection_tree_nodes() {
		   var role_json_array = [];
		   var nodes = zTreeObj.getCheckedNodes(true);
		   for (var i = 0; i < nodes.length; i++) {
			   var role_obj = {roleId:"${roleId}", menuId:nodes[i].id};
			   role_json_array.push(role_obj);
		   }
		   return role_json_array;
	   }
	</script>
</body>
</html>