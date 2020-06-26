<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sms.login.domain.UserInfo" %>
<%@ page import="com.sms.transcript.domain.Transcript" %><%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/15
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    UserInfo loginuser = null;
    Transcript trans = null;
    if (session.getAttribute("loginuser") != null) {
        loginuser = (UserInfo) session.getAttribute("loginuser");
        trans = (Transcript) request.getSession().getAttribute("trans");
    } else {
        request.setAttribute("msg", "未登录系统，请登录");
        String url = "jump.jsp";
//        response.setStatus(HttpServletResponse.SC_MOVED_PERMANENTLY);
//        response.setHeader("Location",url);
        response.sendRedirect(url);
    }

%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>成绩单</title>
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body>


<div class="backgorund"></div>
<%--盒子--%>
<div class="container">
    <%--    左边导航栏--%>
    <div class="leftnav">
        <div class="title">在线教学网站系统
            <div class="settings"></div>
        </div>

        <div class="userinfo">
            <div class="sculpture clearfix"></div>
            <% if (loginuser != null) { %>
            <div class="username clearfix"><%=loginuser.getName() %>
            </div>
            <div class="username clearfix"><%=loginuser.getCardid() %>
            </div>
            <% } else {
            }%>
        </div>

        <ul>
            <li><a href="<%=basePath%>showqstlist">测试题目</a></li>
            <li><a href="<%=basePath%>com/sms/file/upload.jsp">上传文件</a></li>
            <li><a href="<%=basePath%>filelist">下载文件</a></li>
        </ul>

    </div>

    <div class="contentbox">
        <div class="logout">退出登录</div>
        <div class="content">
            <div class="content-header"></div>
            <div class="content-main">
                <h1>成绩单： <%=trans.getScore()%>
                </h1>

            </div>
        </div>
    </div>
</div>
<%--盒子--%>
</body>
</html>
