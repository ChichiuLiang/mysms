<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/7/5
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
         isELIgnored="false" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <base href="<%=basePath %>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>new jsp</title>
</head>
<body>
<br>
<div align="center">
    <font size="5">订单信息</font>
</div>
<br>
<form action="<%=basePath %>">/order"
      method="post">
    <input type="hidden" name="method" value="add">
    <table align="center" width="400px" border="1">
        <tr>
            <td>收货地址</td>
            <td><input type="text" name="receiverinfo">
            </td>
        </tr>

        <tr>
            <td colspan="2">
                <table border="1" width="400px">
                    <tr>
                        <td>商品名称</td>
                        <td>单价</td>
                        <td>数量</td>
                    </tr>
                    <c:set value="0" var="all" />
                    <c:forEach items="${cart}" var="entry">
                        <tr>
                            <td>${entry.key.name}</td>
                            <td>${entry.key.price}</td>
                            <td>${entry.value}</td>
                        </tr>
                        <c:set value="${entry.key.price*entry.value+all}" var="all" />
                    </c:forEach>
                </table></td>
        </tr>
        <tr>
            <td>订单总价:${all}元 <input type="hidden" value="${all}"
                                    name="money"></td>
            <td align="right"><input type="submit" value="生成订单">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
