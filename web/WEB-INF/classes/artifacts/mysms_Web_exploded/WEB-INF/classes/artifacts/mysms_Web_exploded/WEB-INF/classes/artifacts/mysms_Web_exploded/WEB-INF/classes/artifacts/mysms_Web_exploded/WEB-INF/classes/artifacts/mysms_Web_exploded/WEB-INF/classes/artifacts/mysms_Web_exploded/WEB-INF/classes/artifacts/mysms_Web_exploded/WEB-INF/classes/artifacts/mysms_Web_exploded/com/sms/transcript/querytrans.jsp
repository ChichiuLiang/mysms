<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/26
  Time: 17:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<%@ page import="com.sms.login.domain.UserInfo" %>
<%@ page import="com.sms.transcript.domain.Transcript" %>
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
    <title>成绩查询</title>
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
            <li><a href="<%=basePath%>com/sms/transcript/querytrans.jsp">成绩查询</a></li>
        </ul>

    </div>

    <div class="contentbox">
        <div class="logout">退出登录</div>
        <div class="content">
            <div class="content-header"></div>
            <div class="content-main">

                <form action="<%=basePath%>queryTrans" method="post">
                    <c:forEach items="${transidlist}" var="list" varStatus="stat">
                    <select name="transcript_id" >
                        <option value ="${list}">${list}</option>
                        <option value ="${list}">${list}</option>
                    </select>
                    </c:forEach>
                    <input type="submit" value="查询" id="">
                </form>
                <%
                    if(request.getAttribute("trans")!=null) {
                        Transcript trans = (Transcript) request.getAttribute("trans");


                %>
                <h1>成绩单：</h1>
                <%--                <li>试题号： ${trans.transcriptid}</li>--%>
                <li>考生名：<%=trans.getUsername()%></li>
                <li>总分： <%=trans.getScore()%></li>
                <li>我的选择题答案： <%=trans.getMychoiceanswer()%></li>
                <li>选择题参考答案： <%=trans.getChoiceanswer()%></li>
                <li>选择题分数： <%=trans.getChoicescore()%></li>
                <li>我的简答题答案： <%=trans.getMyshortanswer()%></li>
                <li>简答题参考答案： <%=trans.getShortanswer()%></li>
                <li>简答题分数： <%=trans.getMyshortanswer()%></li>

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
                <%}%>
            </div>
        </div>
    </div>
</div>
<%--盒子 end --%>
<%--<script>--%>
<%--    function expand(obj){--%>
<%--        $.ajax({--%>
<%--            url: "<%=basePath%>ajax",--%>
<%--            type: "post",--%>
<%--            data: {--%>
<%--                cardid: $("input[name=cardid]").val(),--%>
<%--                password: $("input[name=password]").val()--%>
<%--            },--%>
<%--            dataType: "json",--%>
<%--            success: function (result) {--%>
<%--                var flag = result.flag;--%>
<%--                // alert(flag);--%>
<%--                if (flag == 0) {--%>
<%--                    //如果登录成功则跳转到成功页面--%>
<%--                    $("#PError").text("校园卡可注册");--%>
<%--                    $("#form").submit();--%>
<%--                } else if (flag == 3) {--%>
<%--                    $("#PError").text("校园卡格式错误，请输入纯数字");--%>
<%--                } else {--%>
<%--                    alert("校园卡已被注册了");--%>
<%--                }--%>
<%--            }--%>
<%--        });--%>
<%--    }--%>

<%--</script>--%>
</body>
</html>
