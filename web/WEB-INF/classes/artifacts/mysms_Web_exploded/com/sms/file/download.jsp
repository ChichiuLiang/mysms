<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/20
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page import="com.sms.login.domain.UserInfo" %>
<%
    UserInfo loginuser = null;
    if(session.getAttribute("loginuser") !=null){
        loginuser = (UserInfo) session.getAttribute("loginuser");
    }else{
        request.setAttribute("msg","未登录系统，请登录");
        String url= "jump.jsp";
        response.sendRedirect(url);
    }

%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.min.js"></script>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body>
<%--背景盒子--%>
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
            <li><a href="<%=basePath%>com/sms/file/upload.jsp">上传文件</a></li>
            <li><a href="<%=basePath%>filelist">下载文件</a></li>
        </ul>
        <% }else{}%>
    </div>

    <div class="contentbox">
        <div class="logout">退出登录</div>
        <div class="content">
            <div class="content-header"></div>
            <div class="content-main">

                <!-- 实现文件的上传 -->
                <!-- 1.要上传文件 表单提交请求的方式必须为post请求 -->
                <!-- 2.要上传文件 需要设置form表单的enctype
                    application/x-www-form-urlencoded是form表单enctype的默认值
                    需要将enctype的值设置为 multipart/form-data
                -->
                <!-- 遍历Map集合 -->
                <%--@elvariable id="fileNameMap" type="java.util.List"--%>
                <c:forEach var="file" items="${fileNameMap}">

                    <c:url value="/downloads" var="downurl">
                         <c:param name="filename" value="${file.key}"></c:param>
                    </c:url>
                    <li class="download-item"> ${file.value} <span class="download-link"> <a
                            href="${downurl}">下载</a></span></li>
                </c:forEach>

            </div>
        </div>
    </div>
</div>
<%--盒子--%>
</body>
</html>
