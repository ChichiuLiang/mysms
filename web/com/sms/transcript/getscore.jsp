<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/15
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sms.login.domain.UserInfo" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%
    UserInfo loginuser = null;

    if (session.getAttribute("loginuser") != null) {
        loginuser = (UserInfo) session.getAttribute("loginuser");

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
<%--背景--%>
<div class="backgorund"></div>

<%--盒子 start--%>
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
                <jsp:useBean id="trans" type="com.sms.transcript.domain.Transcript"
                             scope="session"/>
                <h1>成绩单：</h1>
                <%--                <li>试题号： ${trans.transcriptid}</li>--%>
                <li>考生名： ${trans.username}</li>
                <li>总分： ${trans.score}</li>
                <li>我的选择题答案： ${trans.mychoiceanswer}</li>
                <li>选择题参考答案： ${trans.choiceanswer}</li>
                <li>选择题分数： ${trans.choicescore}</li>
                <li>我的简答题答案： ${trans.myshortanswer}</li>
                <li>简答题参考答案： ${trans.shortanswer}</li>
                <li>简答题分数： ${trans.shortscore}</li>

                <%--                 transcriptid;--%>
                <%--                 score;--%>
                <%--                 username;--%>
                <%--                 mychoiceanswer;--%>
                <%--                myshortanswer;--%>
                <%--                shortanswer;--%>
                <%--                choiceanswer;--%>
                <%--                choicenum;--%>
                <%--                shortnum;--%>
                <%--                shortscore;--%>
                <%--                choicescore;--%>
            </div>
        </div>
    </div>
</div>
<%--盒子 end --%>
</body>
</html>
