<%--
  Created by IntelliJ IDEA.
  User: qinjun
  Date: 2016/2/5
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>

this is login jsp ...
这是一个登录页面。。。
<form action="${pageContext.request.contextPath}/login" method="post">
    <c:if test="${param.error == true}"><p class="login-box-msg" style="color: red;">用户名或密码错误！</p></c:if>
    </br>
    <input type="text" name="username" id="username"/>
    </br>
    <input type="password" name="pwd" id="pwd"/>
    <input type="submit"/>
</form>


</body>
</html>
