<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="bootstrap/comm/Style.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    
    <center>
     <form id="user_login" >
        <table style=" height:30%">
           <tr>
              <td rowspan="4">
                   <div widht="150px" height="250px">
				         <image src="img/IMG_2639.JPG" id="userImage" widht="140px" height="240px" />
				    </div>
              </td>
              <td><label>账&nbsp;&nbsp;&nbsp;&nbsp;号:</label></td>
              <td><input type="email" class="form-control" name="userName" style="width:208px"  onblur="loadImgUser()" ></td>
              <td style="padding-left:12px"><a href="javascript:registerUser()"><font color="#33ccff" size="3"><b>注册用户</b></font></a></td>
           </tr>
           <tr>
              <td><label >密&nbsp;&nbsp;&nbsp;&nbsp;码:</label></td>
              <td><input type="password" class="form-control" name="userPassword"  style="width:208px" ></td>
              <td style="padding-left:12px"><a href="#"><font color="#33ccff" size="3"><b>找回密码</b></font></a></td>
           </tr></br>
           <tr>
              <td><label >验证码:</label></td>
              <td>
                 <input type="email" class="form-control" name="userImgCode"  style="width:208px" >
                   <span  onclick="loadImgCode()">
			            <font color="red">看不清，点击换一张</font>
			            <img id="img_src_Code" src="<%=request.getContextPath()%>/inImgCode">    
			        </span>
              </td>
           </tr></br>
           <tr>
              <td colspan="4" align="right" style="padding-right:80px" >
              <button type="submit" class="btn btn-default "  style="width:208px"  onclick="checkLogin()"><font color="#bbbbbb" ><b>登&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;陆</b></font></button>
              </td>
           </tr>
        </table>                  
     </form>
    </center>
</body>
 <script type="text/javascript">
      //加载图片
      function loadImgUser(){
    	  $.ajax({
     		 url:"<%=request.getContextPath()%>/loadImgUser.jhtml",
     		 type:"post",
     		 data:$("#user_login").serialize(),
     		 dataType:"json",
     		 success:function(data){
     			 if(data.img==false){
     				$("#userImage").attr("src","img/IMG_2639.JPG");
     			 }else{
     			    $("#userImage").attr("src",data.img); 
     			 }
     	     }
     	  });
      }
      
      //登陆请求 
      function checkLogin(){
    	 $.ajax({
    		 url:"<%=request.getContextPath()%>/login.jhtml",
    		 type:"post",
    		 data:$("#user_login").serialize(),
    		 dataType:"json",
    		 success:function(data){
    			if(data.temp==1){
    				location="<%=request.getContextPath()%>/toStudent_list.jhtml";
    			}
    			if(data.temp==2){
    				alert("用户不存在");
    				return;
    			}
    			if(data.temp==3){
    				alert("密码错误"+data.flag+"次");
    				return;
    			}
    			if(data.temp==4){
    				alert("验证码错误");
    				return;
    			}
    			if(data.temp==5){
    				alert("验证码为空");
    				return;
    			}
    			if(data.temp==6){
    				alert("账号已被锁定请五分钟后再试");
    				return;
    			}
    		 }
    	 })
     }
     
     //加载验证码
     function loadImgCode(){
    	 $("#img_src_Code").attr("src","<%=request.getContextPath()%>/inImgCode?time="+ new Date().getTime());
     }
     
     //跳转注册页面
     function registerUser(){
    	 location="<%=request.getContextPath()%>/registerUser.jhtml";
     }
 </script>
</html>