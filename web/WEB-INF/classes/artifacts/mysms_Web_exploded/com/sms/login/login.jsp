<%@ page import="com.sms.login.domain.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/14
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
    UserInfo loginuser = null;
    if(session.getAttribute("loginuser") !=null){
         loginuser = (UserInfo) session.getAttribute("loginuser");
    }else{
        request.setAttribute("msg","未登录系统，请登录");
        String url= "../../../jump.jsp";
        response.sendRedirect(url);
    }

%>
<!DOCTYPE html>
<html>
<head>
    <title>欢迎登陆</title>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="backgorund"></div>

<%--盒子--%>
<div class="container">
    <%--    左边导航栏--%>
    <div class="leftnav">
        <div class="title">在线教学网站系统<div class="settings"></div></div>
        <% if (loginuser!=null) {%>
        <div class="userinfo">
            <div class="sculpture clearfix"></div>
            <div class="username clearfix"> <%=loginuser.getName() %></div>
            <div class="username clearfix"> <%=loginuser.getCardid() %></div>
        </div>
        <ul>
            <li><a href="<%=basePath%>showqstlist">测试题目</a></li>
            <li><a href="<%=basePath%>/com/sms/file/upload.jsp">上传文件</a></li>
            <li><a href="<%=basePath%>filelist">下载文件</a></li>
        </ul>
        <% }else{}%>
    </div>

    <div class="contentbox">
        <div class="logout"></div>
        <div class="content">
            <div class="content-header"> </div>
            <div class="content-main"></div>
        </div>
    </div>
</div>
<%--盒子--%>
</body>
</html>
