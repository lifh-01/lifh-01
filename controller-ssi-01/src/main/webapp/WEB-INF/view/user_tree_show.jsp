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
 <!-- 导航条Action -->
   <nav class="navbar navbar-default">
	  <div class="container-fluid">
	    <!-- Brand and toggle get grouped for better mobile display -->
	    <div class="navbar-header">
	      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
	        <span class="sr-only">Toggle navigation</span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </button>
	      <a class="navbar-brand" href="#">用户:${userInfo.userName}</a>
	    </div>
	    <!-- Collect the nav links, forms, and other content for toggling -->
	    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
	      <ul class="nav navbar-nav">
	        <li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>
	        <li><a href="#">Link</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">Separated link</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">One more separated link</a></li>
	          </ul>
	        </li>
	      </ul>
	      <form class="navbar-form navbar-left">
	        <div class="form-group">
	          <input type="text" class="form-control" placeholder="Search">
	        </div>
	        <button type="submit" class="btn btn-default">Submit</button>
	      </form>
	      <ul class="nav navbar-nav navbar-right">
	        <li><a href="<%=request.getContextPath()%>/loginOut.jhtml">退出登录</a></li>
	        <li class="dropdown">
	          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
	          <ul class="dropdown-menu">
	            <li><a href="#">Action</a></li>
	            <li><a href="#">Another action</a></li>
	            <li><a href="#">Something else here</a></li>
	            <li role="separator" class="divider"></li>
	            <li><a href="#">Separated link</a></li>
	          </ul>
	        </li>
	      </ul>
	    </div><!-- /.navbar-collapse -->
	  </div><!-- /.container-fluid -->
	</nav>
  <!-- 导航条End -->
  <!-- TreeAction -->
    <div class="row">
			<!-- 添加列 -->
			<div class="col-xs-3 lie">
				<!-- 添加列表组（树菜单） -->
				<div id="treeDiv"></div>
			</div>
			<div class="col-xs-9 lie">
				<div id="content-div">
					<!-- 选项卡 -->
					<div id="tabs">
                        <!-- Nav tabs -->
                        <ul class="nav nav-tabs" role="tablist">
                            <li role="presentation" class="active">
                                <a href="#home" aria-controls="home" role="tab" data-toggle="tab">主页</a></li>
                        </ul>
                        <!-- Tab panes（放置结果页面） -->
                        <div class="tab-content">
                        </div>
                    </div>
				</div>
			</div>
		</div>
	<!-- TreeEnd -->
</body>
<script type="text/javascript">
        $(function(){
        	loadAjax();
        })
    
        
        function loadAjax(){
        	$.ajax({
        		type:"post",
        		dataType:"json",
        		data:{userId:"${userInfo.userId}"},
        		url:"<%=request.getContextPath()%>/selectRoleMenuListJson.jhtml",
        		success:function(data){
        			loadTree(data);
        		}
        	})
        }
        


        
        
        //加载树
        function loadTree(tree){
        	$("#treeDiv").treeview({
				//data属性 树节点信息 json数组
				  data: tree,         
				  //tree默认展开的节点级别默认为2
				  levels: 0,
				  //含有子节点的图标
				  collapseIcon:'glyphicon glyphicon-star-empty',
				  //没有子节点的图标
				  emptyIcon:'glyphicon glyphicon-usd',
				  //背景颜色
				  //backColor: 'green'
				  //是否显示复选框
				  showCheckbox:true,
				  //是否允许选中多个节点
				  //multiSelect:true,
				  //启用节点的超链接功能默认为false,节点需指定href属性
				  enableLinks:true,
				  //事件当节点选中时
				  onNodeSelected:function(event,node){
					  //动态向 nav-tabs 导航标签添加tab选项卡
					  //addTabs方法  add() 添加tab  close()关闭tab  closeAll() 关闭全部tab
					  if(null !=  node.url){
						  $.addtabs.add({
							   id:node.id,
							   title:node.text,
							   url:node.url,
						  })
					  }

				  }
		     })
        }
    </script>
</html>