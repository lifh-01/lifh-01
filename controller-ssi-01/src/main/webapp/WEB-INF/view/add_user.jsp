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
   <form id="save__update_user_form">
      <input type="hidden" value="${responseUser.userId}" name="userId">
       <table>
           <tr>
              <td align="right"><label for="Nam">用户名:</label></td>
              <td><input type="text" name="userName" value="${responseUser.userName}" class="form-control">
              </td>
           </tr>
           <tr>
              <td align="right"><label for="Nam">密码:</label></td>
              <td><input type="text" name="userPassword" value="${responseUser.userPassword}" class="form-control">
              </td>
           </tr>
       </table>
   </form>
</body>
</html>
