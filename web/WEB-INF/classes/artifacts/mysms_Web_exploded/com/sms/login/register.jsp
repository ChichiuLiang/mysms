<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/10
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
    <title>注册</title>
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.min.js"></script>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="backgorund"></div>
<%--登录盒子--%>
<div class="box register">
    <h1>注册用户</h1>
    <!--注册表单-->
    <form method="post" action="<%=basePath%>register" id="form">
        <input type="text" name="cardid" id="cardid" placeholder="校园卡">
        <input type="text" name="username" id="username" placeholder="用户名">
        <input type="password" name="password" id="password" placeholder="密码">
        <span id="PError"></span>
        <input type="button" id="register" value="注册">
        <a href="../index.jsp">登录</a>
        <%--            <input type="button" id="vertify" class="" value="检验">--%>
        <%--            <input type="reset" class="" value="重置">--%>
    </form>

</div>
<script>
    function isInt(number) {
        if (!(/(^[1-9]\d*$)/.test(number))) {
            console.log("不符合格式");
            return false;
        } else {
            console.log("符合格式");
            return true;
        }
    }

    // flag 0 未注册 1 已注册密码不正确 2 已注册密码错误
    $("#vertify").click(function () {
        //单击登录按钮的时候触发ajax事件
        if (isInt($("input[name=cardid]").val())) {
            $.ajax({
                url: "<%=basePath%>ajax",
                type: "post",
                data: {
                    cardid: $("input[name=cardid]").val(),
                    password: $("input[name=password]").val()
                },
                dataType: "json",
                success: function (result) {
                    var flag = result.flag;
                    // alert(flag);
                    if (flag == 0) {
                        //如果登录成功则跳转到成功页面
                        $("#PError").text("校园卡可注册");
                    } else {
                        $("#PError").text("校园卡已被注册了");
                    }
                }
            });
        } else {
            $("#PError").text("校园卡格式错误，请输入纯数字");
        }
    });
    // flag 0 未注册 1 已注册密码不正确 2 已注册密码错误
    $("#register").click(function () {
        //单击登录按钮的时候触发ajax事件
        if (isInt($("input[name=cardid]").val())) {
            $.ajax({
                url: "<%=basePath%>ajax",
                type: "post",
                data: {
                    cardid: $("input[name=cardid]").val(),
                    password: $("input[name=password]").val()
                },
                dataType: "json",
                success: function (result) {
                    var flag = result.flag;
                    // alert(flag);
                    if (flag == 0) {
                        //如果登录成功则跳转到成功页面
                        $("#PError").text("校园卡可注册");
                        $("#form").submit();
                    } else if (flag == 3) {
                        $("#PError").text("校园卡格式错误，请输入纯数字");
                    } else {
                        alert("校园卡已被注册了");
                    }
                }
            });
        } else {
            alert("校园卡格式错误，请输入纯数字");
        }
    });
</script>
</body>
</html>
