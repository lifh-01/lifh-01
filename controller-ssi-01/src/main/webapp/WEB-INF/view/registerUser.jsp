<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/bootstrap/comm/Style.jsp" %>
    <link rel="stylesheet" type="text/css"	href="<%=request.getContextPath()%>/uploadify/uploadify.css" />
   <script type="text/javascript" src="<%=request.getContextPath()%>/uploadify/jquery.uploadify.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
  <center>
    <form id="registerUser">
     <div style="padding-top:50px">
      <div style="padding-right:250px" >
        <table style=" height:60%"  width="800">
           <tr>
              <td align="right" rowspan="4">
                 <div widht="150px" height="250px">
                    <image src="img/IMG_2639.JPG" id="imageUser" widht="140px" height="240px" />
                 </div>
              </td>
              <td align="right"><label for="Nam">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号:</label></td>
              <td><input type="email" class="form-control" name="userName" id="Nam" style="width:208px" onblur="checkUserName()" >
                  <span id="checkUserName"><font color="#bbbbbb" size="2"><b>只能为数字8-16位组成</b></font></span>
              </td>
              
           </tr>
           <tr>
              <td align="right"><label for="Pwd">密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</label></td>
              <td><input type="password" class="form-control" name="userPassword" id="Pwd" onblur="checkUserPwd()" style="width:208px" >
                  <span id="checkUserPwd"><font color="#bbbbbb" size="2"><b>请使用数字，字母下划线。8-16位组成</b></font></span>
              </td>
           </tr></br>
           <tr>
              <td align="right"><label for="exampleInputPassword1">确认密码:</label></td>
              <td><input type="password" id="pwdTow" class="form-control"  style="width:208px" onblur="checkUserPwdTow()">
                  <span id="checkUserPwdTow"><font color="#bbbbbb" size="2"><b>请再次输入密码</b></font></span>
              </td>
           </tr></br>
           <tr>
              <td align="right"><label for="exampleInputEmail1">头像上传:</label></td>
              <td>
                 <input type="file" id="user_img" />
                 <input type="hidden" Id="userImg" value="" name="userNameImg"/>
              </td>
              <td><span id="checkUserImg"></span></td>
           </tr></br>
           <tr>
              <td colspan="3"  style="padding-left:408px">
                  <input type="checkbox" id="checkHttp" onclick="checkHttps()"><font color="#bbbbbb" size="2">你同意我们的要求吗？</font>
              </td>
           </tr> 
           <tr>
              <td colspan="3"  style="padding-left:378px">
              <button type="submit" class="btn btn-default " id="btn" disabled="true" style="width:208px"  onclick="addUser()"><font color="#bbbbbb" ><b>注&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;册</b></font></button>
              </td>
           </tr>
        </table> 
       </div> 
      </div>                
     </form>
   </center>
</body>
<script type="text/javascript">
	var USERNAME=false;
	var PASSWORD=false;
	var PASSWORDTOW=false;
   

   $(function(){
	   $("#user_img").uploadify({
			'swf'     : '${pageContext.request.contextPath}/uploadify/uploadify.swf',//按钮的动画
			'uploader': '${pageContext.request.contextPath}/uploder.jhtml',
			'cancelImg': 'image/uploadify', //uploaddify 图片
			'queueID' :'filequence',  //  存放序列的地方
			'method'  : 'post',			
			'fileObjName' : 'userNameImg',     //和后台的Action 属性驱动名字一样
			'sizeLimit':30,
			'progressData' :'percentage', //  设置上传进度显示方式，percentage显示上传百分比，speed显示上传速度
			'auto':true,   //是否自动  上传
			'multi': false,  //是否选择多个
			'removeCompleted' : false,// 上传完是否自动删除任务
			'fileSizeLimit': 0, // "4MB"  写0的话就是对 他不做限制
			'buttonText' :  '上传照片',
			'buttonCursor': 'head', // 光标的样子
			'fileTypeDesc' : 'mp4/avi/kux', // 你得告知  上传者    可以上传  什么类型的吧  与下面的那个属性连用
			'fileTypeExts' : '*.jpg;*.png;*.bmp',//  告诉 uploadify可以上传  什么类型的
			'uploadLimit': 1, //设置   上传时的上传文件数       超过就会触发 on
			//'onSelectError':uploadErrorMsg,
			'onUploadSuccess': function (file,data,response){  //上传成功回掉函数
				var datas = eval('('+data+')');
			    alert(datas.logMsg);
				$("#userImg").val("ftp://root:root@192.168.1.166/"+datas.dataHref);
				$("#imageUser").attr("src","ftp://root:root@192.168.1.166/"+datas.dataHref);s
			},
       });	
   })
   
   //提交注册信息
   function addUser(){
	   if(USERNAME&&PASSWORD&&PASSWORDTOW){
		   $.ajax({
			   type:"post",
			   data:$("#registerUser").serialize(),
			   dataType:"json",
			   url:"<%=request.getContextPath()%>/registerUserLog.jhtml",
			   success:function(data){
				   if(data.bool){
					   loadDiglog(); 	   
				   }else{
					   alert("系统繁忙请稍后重试哦，亲。")
				   }
			   },
		   })
	   }else{
		   alert("请完善信息后在注册");
	   }
   }
   
 //弹出框
   function loadDiglog(){
	   var dialog = bootbox.dialog({
			 title: "注册用户信息",
			 message:"注册成功，请点击登陆！！！",
			 buttons:{
					"save":{
					  label: '登        陆',
					  //自定义样式
					  className: "btn-success",
					  callback: function() {
						  location="index.jsp";
					  }
					},
			}	
		});
   }
   
   function checkHttps(){
	   var chek=document.getElementById("checkHttp");
	   if(chek.checked){
	       $("#btn").removeAttr("disabled");
	   }else{
		   $("#btn").attr("disabled","true");
	   }  
   }
   
   //验证密码
   function checkUserPwd(){
	   var Pwd = $("#Pwd").val();
	   var reg =/^\w{8,16}$/;
	   var sp=$("#checkUserPwd");
	   if(reg.test(Pwd)){
          sp.html('<font color="#00cc00"><b>∨</b><font>');
		  PASSWORD = true;
	   }else{
		  sp.html('<font color="red" size="2"><b>请使用数字，字母下划线。8-16位组成<b></font>');
		  PASSWORD = false;
	   }
   }

   //验证两次密码是否一致
   function checkUserPwdTow(){
	   var sp=$("#checkUserPwdTow");
	   var pwdTow=$("#pwdTow").val();
	   var Pwd = $("#Pwd").val();
	   if(pwdTow==""||pwdTow==null||pwdTow==undefined){
		   sp.html('<font color="red" size="2"><b>不能为空<b></font>');
		   return;
	   }
	   if(Pwd==pwdTow){
		   sp.html('<font color="#00cc00"><b>∨</b><font>');
		   PASSWORDTOW = true;
	   }else{
		   sp.html('<font color="red" size="2"><b>两次输入密码不一致<b></font>');
		   PASSWORDTOW = false;
	   }
   }
   
   //验证用户名
   function checkUserName(){
	   var Nam = $("#Nam").val();
	   var sp=$("#checkUserName");
	   var reg = /^[0-9]{8,16}$/;
	   if(reg.test(Nam)){
		   $.ajax({
			   type:"post",
			   data:{"userName":Nam},
			   dataType:"json",
			   url:"<%=request.getContextPath()%>/checkUserName.jhtml",
			   success:function(data){
				   if(data.flag==1){
					   sp.html('<font color="red" size="2"><b>用户名已存在<b></font>');
					   USERNAME=false; 
				   }else{
					   sp.html('<font color="#00cc00"><b>∨</b><font>');  
					   USERNAME=true; 
				   }
			   }
		   })
	   }else{
		   sp.html('<font color="red" size="2"><b>只能为数字8-16位组成<b></font>');
	   }
   } 
</script>
</html>