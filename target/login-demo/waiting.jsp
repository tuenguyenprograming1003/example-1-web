<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="vn.edu.webpr.model.User" %>
<%
    User u = (User) request.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h2>Xin chào, <%= u != null ? u.getFullName() : "Guest" %></h2>
<p>Tên đăng nhập: <%= u != null ? u.getUserName() : "" %></p>
<p><a href="<%= request.getContextPath() %>/login">Quay lại</a></p>
</body>
</html>
