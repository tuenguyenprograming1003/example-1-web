<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<h2>Đăng nhập</h2>
<c:if test="${not empty alert}">
    <div style="color:red">${alert}</div>
</c:if>
<form action="${pageContext.request.contextPath}/login" method="post">
    <div><label>Tên đăng nhập: <input type="text" name="username"/></label></div>
    <div><label>Mật khẩu: <input type="password" name="password"/></label></div>
    <div><label><input type="checkbox" name="remember"/> Ghi nhớ</label></div>
    <div><button type="submit">Đăng nhập</button></div>
</form>
</body>
</html>
