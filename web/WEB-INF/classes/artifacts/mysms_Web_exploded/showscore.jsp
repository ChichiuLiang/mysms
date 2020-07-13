<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/7/1
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>new jsp</title>
</head>
<body>

<%--//获取bean--%>
<table>
    <tr>
        <td>姓名：</td>
        <td>${requestScope.scorebean.name}</td>
    </tr>
    <tr>
        <td>分数：</td>
        <td>${requestScope.scorebean.score}</td>
    </tr>
    <tr>
        <td>学号：</td>
        <td>${requestScope.scorebean.stunum}</td>
    </tr>
</table>
</body>
</html>
