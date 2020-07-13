<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/6/14
  Time: 11:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.sms.login.domain.UserInfo" %>
<%@ page import="com.sms.transcript.domain.Transcript" %>
<%
    UserInfo loginuser = null;
    if (session.getAttribute("loginuser") != null) {
        loginuser = (UserInfo) session.getAttribute("loginuser");
    } else {
        request.setAttribute("msg", "未登录系统，请登录");
        String url = "jump.jsp";
        response.sendRedirect(url);
    }

%>

<!DOCTYPE html>
<html>
<head>
    <title>测试页面</title>
    <base href="<%=basePath%>">
    <script type="text/javascript" src="<%=basePath%>js/jquery-3.4.1.min.js"></script>
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
                <%
                    if (session.getAttribute("trans") != null) {
                        Transcript trans = (Transcript) request.getSession().getAttribute("trans");
                %>
                <p>上次成绩:<%=trans.getScore()%>
                </p>
                <br/>
                <%
                    }
                %>
                <form action="<%=basePath%>getscore" method="post" id="form">
                    <h1>一、选择题</h1>
                    <%--@elvariable id="choicelist" type="java.util.List"--%>
                    <c:forEach items="${choicelist}" var="qst" varStatus="stat">
                        <div id="choiceqst${stat.index +1 }"
                             style="text-align:justify; text-justify:inter-ideograph;">
                                <%--        <p><input type="checkbox" name="box" id="box_${stat.count}" value="" /></p>--%>
                            <p> ${stat.index +1 }. <span>${qst.choicetitle}</span></p>
                            <p><input type="radio" value="A" name="choice${stat.index +1 }">
                                A. ${qst.choiceop1}</p>
                            <p><input type="radio" value="B" name="choice${stat.index +1 }">
                                B. ${qst.choiceop2}</p>
                            <p><input type="radio" value="C" name="choice${stat.index +1 }">
                                C. ${qst.choiceop3}</p>
                            <p><input type="radio" value="D" name="choice${stat.index +1 }">
                                D. ${qst.choiceop4}</p>
                        </div>
                    </c:forEach>
                    <h1>二、简答题</h1>

                    <%--@elvariable id="shortlist" type="java.util.List"--%>
                    <c:forEach items="${shortlist}" var="shortqst" varStatus="stat">
                        <c:if test="${not empty shortlist}">
                            <div id="shortqst"
                                 style="text-align:justify; text-justify:inter-ideograph;">
                                    <%-- <p><input type="checkbox" name="box" id="box_${stat.index}" value="" /></p>--%>
                                    <%-- <p>${shortqst.shortid}</p>--%>

                                <label for="saq${stat.index +1}">${stat.index + 1}.<span>${shortqst.shorttitle}</span>
                                </label>
                                <textarea onblur="updateInputValue(${stat.index + 1})"
                                          id="saq${stat.index +1}"
                                          value="请输入" name="saq${stat.index +1}">
                    </textarea>
                            </div>
                        </c:if>
                    </c:forEach>

                    <input type="button" name="button" id="submitans" value="提交">
                </form>


            </div>
        </div>
    </div>
</div>
<%--盒子 end --%>


</body>
<script>
    function updateInputValue(index) {
        var strname = "saq" + index;
        console.log(strname);
        var $inputParent = $("[name='" + strname + "']").parent();//获取此元素的父亲
        var $bro = $inputParent.children("label");//获取到此元素的哥哥
        console.log($bro);
        var value = $("[name='" + strname + "']").val();//获取此元素修改后的值
        console.log(value);
        $("#" + strname + "").remove();//删除此元素
        $bro.after($("<textarea   value='" + value +
            "' onblur='updateInputValue(" + strname + ")' name='" + strname + "' id='" + strname + "' >" + value + "</textarea>"));
        //利用修改后的值重新拼接一个input
    }
    $("#submitans").click(function () {
        //单击登录按钮的时候触发ajax事件
        $("#form").submit();
        <%--if (isInt($("input[name=cardid]").val())){--%>
        <%--    $.ajax({--%>
        <%--        url:"<%=basePath%>ajax",--%>
        <%--        type:"post",--%>
        <%--        data:{--%>
        <%--            cardid:$("input[name=cardid]").val(),--%>
        <%--            password:$("input[name=password]").val()--%>
        <%--        },--%>
        <%--        dataType:"json",--%>
        <%--        success:function(result){--%>
        <%--            var flag = result.flag;--%>
        <%--            // alert(flag);--%>
        <%--            if(flag== 0 ){--%>
        <%--                //如果登录成功则跳转到成功页面--%>
        <%--                $("#PError").text("用户不存在");--%>
        <%--                &lt;%&ndash;window.location.href="<%=basePath%>/pages/front/success.jsp";&ndash;%&gt;--%>
        <%--            }else if(flag== 2){--%>
        <%--                //跳回到Index.jsp登录页面，同时在登录页面给用户一个友好的提示--%>
        <%--                $("#PError").text("验证成功");--%>
        <%--            }else{--%>
        <%--                $("#PError").text("密码不正确");--%>
        <%--            }--%>
        <%--        }--%>
        <%--    });--%>
        <%--}else{--%>
        <%--    $("#PError").text("校园卡格式错误，请输入纯数字");--%>
        <%--}--%>
    });
</script>
</html>
