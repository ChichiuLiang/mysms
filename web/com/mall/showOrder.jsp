<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/7/4
  Time: 10:19
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
<br/>
<div align="center">
    <h1>生成订单</h1>
</div>
<br/>
<table align="center" border="1">
    <tr>
        <td>订单编号</td>
        <td>订单信息</td>
        <td>订单状态</td>
        <td>订单用户</td>
        <td>订单操作</td>
    </tr>


    <c:forEach items="${orders}" var="order">
        <tr>
            <td>${order.id }</td>
            <td>
                <table align="center" border="1">
                    <tr>
                        <td>商品名称</td>
                        <td>商品单价</td>
                        <td>购买数量</td>
                    </tr>

                    <c:forEach items="${order.orderItems}" var="item">
                        <tr>
                            <td>${item.name }</td>
                            <td>${item.price }</td>
                            <td>${item.buynum }</td>
                        </tr>
                    </c:forEach>

                    <tr>
                        <td colspan="3" align="right">总价:${order.money}</td>
                    </tr>

                </table>
            </td>
            <td><c:if test="${order.paystate==0}">
                <a
                        href='<%=basePath %>/pay.jsp?id=${order.id}&money=${order.money}'>未支付</a>
            </c:if> <c:if test="${order.paystate==1}">
                已支付
            </c:if></td>
            <td>${order.username}【${order.nickname}】</td>

            <td><a
                    href="<%=basePath %>/order?method=del&id=${order.id}">取消订单</a>
            </td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
