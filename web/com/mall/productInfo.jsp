<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/7/4
  Time: 10:31
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
<br>
<table align="center">
    <tr>
        <td rowspan="5"><img src="http://www.bookEstore.com/${p.imgurl_s}">
        </td>
        <td>商品名称:${p.name}</td>
    </tr>

    <tr>
        <td>商品价格:${p.price}</td>
    </tr>
    <tr>
        <td>商品类别:${p.category}</td>
    </tr>
    <tr>
        <td>商品数量:${p.pnum}</td>
    </tr>
    <tr>
        <td>商品描述:${p.description}</td>
    </tr>

    <tr>
        <td colspan="2" align="right">
            <img
                    src="<%=basePath %>/images/buy.bmp"
                    onclick="addProductToCart('${p.id}')"></td>
    </tr>
</table>
</body>
<script type="text/javascript">
    function addProductToCart(id) {
        location.href = "<%=basePath %>/cart?method=add&id=" + id;
    }
</script>
</html>
