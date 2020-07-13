<%@ taglib prefix="privilege" uri="http://www.mall.cn/privilege" %>
<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/7/4
  Time: 10:51
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
<privilege:mall user="${user}"/>
<br>
<br>
<form action="${pageContext.request.contextPath}/addProduct"
      method="post" enctype="multipart/form-data">
    <table border="1" width="65%" align="center">
        <caption>
            <b>添加图书</b>
        </caption>

        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name"></td>
        </tr>

        <tr>
            <td>商品价格</td>
            <td><input type="text" name="price"></td>
        </tr>

        <tr>
            <td>商品类别</td>
            <td><select name="category">
                <option>--请选择类别--</option>
                <option value="JAVASE">JAVASE</option>
                <option value="JAVAWEB">JAVAWEB</option>
                <option value="JAVA框架">JAVA框架</option>
                <option value="JAVA高级">JAVA高级</option>
            </select></td>
        </tr>

        <tr>
            <td>商品数量</td>
            <td><input type="text" name="pnum"></td>
        </tr>

        <tr>
            <td>商品图片</td>
            <td><input type="file" name="f"></td>
        </tr>

        <tr>
            <td>商品描述</td>
            <td><textarea name="description" rows="10" cols="40"></textarea>
            </td>
        </tr>

        <tr>
            <td colspan="2" align="center"><input type="submit"
                                                  value="添加商品"> <input type="reset" value="取消"></td>
        </tr>
    </table>

</form>
</body>
</html>
