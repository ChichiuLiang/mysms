<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/11
  Time: 13:09
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script type="text/javascript" src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/css/style.css">
</head>
<body>
<div class="backgorund"></div>
<%--盒子--%>
<div class="box jump">
    <h1 id="title">${requestScope.msg}</h1>
    <!--这里的action是关键-->
    <div id="box" >
        <p>页面在
            <span id="Os">3</span>
            s 后跳转
        </p>
    </div>
    <a href="#" onclick="javascript:history.back(-1);" >若页面未响应，请点击返回</a>

</div>

<script>
    var basePath = null;
    basePath = "<%=basePath%>" ;

    //先取得Os容器
    var url = null;
    url = "${requestScope.url}";
    if(url == "" || url == null ){
        url= basePath + "/index.jsp";
        $("#title").after("<h1>未登录，请先登录</h1>");
    }else{
        url = basePath +url;
    }
    var Os=document.getElementById("Os");
    //几秒倒计时
    var num=3;
    //设置一个定时器，每一秒执行一次num自减1，
    var timer = setInterval(function () {
        num--;
        Os.innerText = num;
        if( num === 0 ){
            window.location.href= url ;
        }
    },1000)
</script>
</body>
</html>