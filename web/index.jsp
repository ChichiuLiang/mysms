<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/7/5
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<jsp:forward page="/product"></jsp:forward>
<%--实际调到page页面--%>
