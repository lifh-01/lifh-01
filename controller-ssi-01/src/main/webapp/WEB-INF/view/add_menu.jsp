<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form id="save_menu_form">
       <table>
           <tr>
              <td align="right"><label for="Nam">选择模块:</label></td>
              <td>
                   <select class="form-control" name="pid">
					  <option value="0">添加模块</option>
					  <c:forEach items="${MenuResponseList}" var="menu">
					     <option value="${menu.id}">${menu.name}</option>
					  </c:forEach>
					</select>
              </td> 
           </tr>
           <tr>
              <td align="right"><label for="Nam">菜单名称:</label></td>
              <td><input type="text" name="name" class="form-control">
              </td>
           </tr>
           <tr>
              <td align="right"><label for="Nam">菜单连接:</label></td>
              <td><input type="text" name="url" class="form-control">
              </td>
           </tr>
           <tr>
              <td align="right"><label for="Nam">请求详情:</label></td>
              <td>
                    <input name="type" type="radio" value="0" checked="checked">常规功能
					<input name="type" type="radio" value="1">ajax请求
					<input name="type" type="radio" value="2">基本功能
					<input name="type" type="radio" value="3">按钮功能<br>
              </td>
           </tr>
       </table>
   </form>
</body>
</html>
