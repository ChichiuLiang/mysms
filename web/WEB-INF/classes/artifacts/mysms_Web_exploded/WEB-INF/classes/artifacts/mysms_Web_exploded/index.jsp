<%@ page import="com.sms.login.domain.UserInfo" %><%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/10
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
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
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
    <title>登录</title>
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.min.js"></script>
    <base href="<%=basePath%>">
    <link rel="stylesheet" href="<%=basePath%>css/style.css">
</head>
<body>
<div class="backgorund"></div>

<%--登录盒子--%>
<div class="box login">
    <h1>在线教学网站系统</h1>
    <!--这里的action是关键-->
    <form method="post" action="<%=basePath%>login" id="form" >
            <input type="text" name="cardid" id="cardid" placeholder="校园卡">
            <span id="CIDError"></span>
            <input type="password" name="password" id="password" placeholder="密码">
            <span id="PError"></span>
            <input type="button" id="login" value="登录">
            <a href="com/sms/login/register.jsp">注册</a>
<%--            <input type="button" id="vertify" class="" value="检验">--%>
<%--            <input type="reset" class="" value="重置">--%>
    </form>

</div>


<script>
    function isInt(number){
       if(!(/(^[1-9]\d*$)/.test(number))){
            console.log("不符合格式");
            return false;
       }else{
           console.log("符合格式");
           return true;
       }
    }
    $("#vertify").click(function(){
        //单击登录按钮的时候触发ajax事件
        if (isInt($("input[name=cardid]").val())){
            $.ajax({
                url:"<%=basePath%>ajax",
                type:"post",
                data:{
                    cardid:$("input[name=cardid]").val(),
                    password:$("input[name=password]").val()
                },
                dataType:"json",
                success:function(result){
                    var flag = result.flag;
                    // alert(flag);
                    if(flag== 0 ){
                        //如果登录成功则跳转到成功页面
                        $("#PError").text("用户不存在");
                        <%--window.location.href="<%=basePath%>/pages/front/success.jsp";--%>
                    }else if(flag== 2){
                        //跳回到Index.jsp登录页面，同时在登录页面给用户一个友好的提示
                        $("#PError").text("验证成功");
                    }else{
                        $("#PError").text("密码不正确");
                    }

                }

            });

        }else{
            $("#PError").text("校园卡格式错误，请输入纯数字");
        }

    });
    $("#login").click(function(){
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
                        $("#PError").text("用户不存在");
                        alert("用户不存在");
                    } else if (flag == 3) {
                        $("#PError").text("校园卡格式错误，请输入纯数字");
                    } else if (flag == 2) {
                        $("#PError").text("验证成功");
                        $("#form").submit();
                    } else {
                        alert("密码不正确");
                    }

                }

            });

        }
        else{
            alert("校园卡格式错误，请输入纯数字");
        }
    });

</script>
</body>

</html>

