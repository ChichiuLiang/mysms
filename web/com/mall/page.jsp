<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Chichiu
  Date: 2020/7/4
  Time: 17:09
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
<div id="art-main">
    <div class="art-sheet">
        <%=basePath %>">
        <div class="art-sheet-body">
            <div class="art-header">
                <div class="art-header-png"></div>
                <div class="art-header-jpeg"></div>
                <div class="art-logo">
                    <h1 id="name-text" class="art-logo-name">
                        <a href="#">Estore图书商城</a>
                    </h1>
                    <div id="slogan-text" class="art-logo-text">快乐的购物天堂...</div>
                </div>
            </div>
            <div class="art-nav">
                <div class="l"></div>
                <div class="r"></div>
                <ul class="art-menu">
                    <li><a href="#" class="active"><span class="l"></span><span
                            class="r"></span><span class="t">主页</span> </a>
                    </li>
                    <li><a href="#"><span class="l"></span><span class="r"></span><span
                            class="t">商品分类</span> </a></li>
                    <li><a href="#"><span class="l"></span><span class="r"></span><span
                            class="t">关于我们</span> </a>
                    </li>
                    <li></li>
                    <li></li>
                    <li></li>


                    <c:if test="${empty user }">
                        <li>用户未登录</li>
                    </c:if>

                    <c:if test="${not empty user }">
                        <li>当前用户:${user.username}</li>
                        <li><a
                                href='<%=basePath %>/user?method=logout'>注销</a>
                        </li>
                    </c:if>


                </ul>
            </div>
            <div class="art-content-layout">
                <div class="art-content-layout-row">
                    <div class="art-layout-cell art-content">
                        <div class="art-post">
                            <div class="art-post-body">
                                <div class="art-post-inner art-article">
                                    <div class="art-postmetadataheader">
                                        <h2 class="art-postheader">商品促销信息</h2>
                                    </div>
                                    <div class="art-postcontent">
                                        <!-- article-content -->
                                        <script type="text/javascript"
                                                src="mutilpleFlash.js"></script>
                                        <!-- /article-content -->
                                    </div>
                                    <div class="cleared"></div>
                                </div>

                                <div class="cleared"></div>
                            </div>
                        </div>

                        <div class="art-post">
                            <div class="art-post-body">
                                <div class="art-post-inner art-article">
                                    <div class="art-postmetadataheader">
                                        <h2 class="art-postheader">热卖商品销售中</h2>
                                    </div>
                                    <div class="art-postcontent">
                                        <!-- article-content -->
                                        <p>
												<span class="art-button-wrapper"> <span class="l">
												</span> <span class="r"> </span> <a
                                                        class="art-button"
                                                        href="javascript:void(0)">更多商品...</a> </span>
                                        </p>

                                        <div class="cleared"></div>


                                        <div class="art-content-layout overview-table">


                                            <div class="art-content-layout-row">
                                                <c:forEach items="${ps}" var="p" varStatus="vs">
                                                <div class="art-layout-cell">
                                                    <div class="overview-table-inner">
                                                        <h4>${p.name }</h4>
                                                        <img
                                                                src="http://www.bookEstore.com/${p.imgurl}"
                                                                width="55px" height="55px"
                                                                alt="an image" class="image"/>
                                                        <p>价格: ￥${p.price }</p>
                                                        <p>
                                                            <a
                                                                    href='<%=basePath %>/product?method=findById&id=${p.id}'>速速抢购</a>
                                                        </p>
                                                    </div>
                                                </div>
                                                <!-- end cell -->

                                                <c:if test="${vs.count%5==0}">
                                            </div>
                                            <!-- end row -->
                                            <div class="art-content-layout-row">
                                                </c:if>

                                                </c:forEach>
                                            </div>
                                            <!-- end row -->

                                        </div>
                                        <!-- end table -->

                                        <!-- /article-content -->
                                    </div>
                                    <div class="cleared"></div>
                                </div>

                                <div class="cleared"></div>
                            </div>
                        </div>
                    </div>
                    <div class="art-layout-cell art-sidebar1">
                        <div class="art-vmenublock">
                            <div class="art-vmenublock-body">
                                <div class="art-vmenublockheader">
                                    <div class="l"></div>
                                    <div class="r"></div>
                                    <div class="t">导航菜单</div>
                                </div>
                                <div class="art-vmenublockcontent">
                                    <div class="art-vmenublockcontent-tl"></div>
                                    <div class="art-vmenublockcontent-tr"></div>
                                    <div class="art-vmenublockcontent-bl"></div>
                                    <div class="art-vmenublockcontent-br"></div>
                                    <div class="art-vmenublockcontent-tc"></div>
                                    <div class="art-vmenublockcontent-bc"></div>
                                    <div class="art-vmenublockcontent-cl"></div>
                                    <div class="art-vmenublockcontent-cr"></div>
                                    <div class="art-vmenublockcontent-cc"></div>
                                    <div class="art-vmenublockcontent-body">
                                        <!-- block-content -->
                                        <ul class="art-vmenu">
                                            <li><a
                                                    href="<%=basePath %>com/mall/index.jsp"><span
                                                    class="l"></span><span class="r"></span><span
                                                    class="t">主页</span>
                                            </a>
                                            </li>
                                            <li><a
                                                    href="<%=basePath %>com/mall/addProduct.jsp"><span
                                                    class="l"></span><span class="r"></span><span
                                                    class="t">添加商品</span>
                                            </a>
                                            </li>

                                            <li><a
                                                    href="<%=basePath %>com/mall/showCart.jsp"><span
                                                    class="l"></span><span class="r"></span><span
                                                    class="t">查看购物车</span>
                                            </a>
                                            </li>
                                            <li><a
                                                    href="<%=basePath %>order?method=search"><span
                                                    class="l"></span><span class="r"></span><span
                                                    class="t">查看订单</span>
                                            </a>
                                            </li>

                                            <li><a
                                                    href="<%=basePath %>download"><span
                                                    class="l"></span><span class="r"></span><span
                                                    class="t">下载榜单</span>
                                            </a>
                                            </li>
                                            <li><a href="#"><span class="l"></span><span
                                                    class="r"></span><span class="t">关于我们</span>
                                            </a>
                                            </li>
                                            <li><a href="#"><span class="l"></span><span
                                                    class="r"></span><span class="t">联系方式</span>
                                            </a>
                                            </li>
                                        </ul>
                                        <!-- /block-content -->

                                        <div class="cleared"></div>
                                    </div>
                                </div>
                                <div class="cleared"></div>
                            </div>
                        </div>
                        <div class="art-block">
                            <div class="art-block-body">
                                <div class="art-blockheader">
                                    <div class="l"></div>
                                    <div class="r"></div>
                                    <div class="t">用户登陆</div>
                                </div>
                                <div class="art-blockcontent">

                                    <div class="art-blockcontent-body">
                                        <!-- block-content -->
                                        <div>
                                            <form method="post" id="loginForm"
                                                  action="<%=basePath %>/user">
                                                <input type="hidden" name="method" value="login">
                                                <table>
                                                    <tr>
                                                        <td colspan="2"><p
                                                                color='red'>${requestScope["login.message"]
                                                                }</p>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td>用户</td>
                                                        <td><input type="text" value=""
                                                                   name="username"
                                                                   id="username"/><br/></td>
                                                    </tr>
                                                    <tr>
                                                        <td>密码</td>
                                                        <td><input type="password" value=""
                                                                   name="password"
                                                                   id="password"/></td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2"><input type="checkbox"
                                                                               name="remember"
                                                                               value="on"/>记住用户
                                                            <input
                                                                    type="checkbox" name="autologin"
                                                                    value="on"/>自动登陆
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td colspan="2"><span
                                                                class="art-button-wrapper">
																	<span class="l"> </span> <span
                                                                class="r"> </span> <input
                                                                class="art-button" type="submit"
                                                                name="loginbtn"
                                                                value="登陆"/> </span> &nbsp;&nbsp;&nbsp;<a
                                                                href='<%=basePath %>com/mall/register.jsp'>注册</a>
                                                        </td>
                                                </table>
                                            </form>
                                        </div>
                                        <!-- /block-content -->

                                        <div class="cleared"></div>
                                    </div>
                                </div>
                                <div class="cleared"></div>
                            </div>
                        </div>
                        <div class="art-block">
                            <div class="art-block-body">
                                <div class="art-blockheader">
                                    <div class="l"></div>
                                    <div class="r"></div>
                                    <div class="t">查询商品</div>
                                </div>
                                <div class="art-blockcontent">
                                    <!-- block-content -->
                                    <div>
                                        <form method="get" id="newsletterform"
                                              action="javascript:void(0)">
                                            <input type="text" value="" name="email" id="s"
                                                   style="width: 95%;"/> <span
                                                class="art-button-wrapper">
														<span class="l"> </span> <span
                                                class="r"> </span> <input
                                                class="art-button" type="submit" name="search"
                                                value="查询"/>
													</span>

                                        </form>
                                    </div>
                                    <!-- /block-content -->

                                    <div class="cleared"></div>
                                </div>
                            </div>
                            <div class="cleared"></div>
                        </div>
                    </div>

                    <div class="art-block">
                        <div class="art-block-body">
                            <div class="art-blockheader">
                                <div class="l"></div>
                                <div class="r"></div>
                                <div class="t">联系信息</div>
                            </div>
                            <div class="art-blockcontent">
                                <div class="art-blockcontent-body">
                                    <!-- block-content -->
                                    <div>

                                        <b>公司信息</b><br/> 传智播客<br/> 电子邮箱: <a
                                            href="mailto:yuyang@itcast.cn">duhong@itcast.cn</a><br/>
                                        <br/> 电话: (010)51552112 <br/> 传真: (010)51552110
                                    </div>
                                    <!-- /block-content -->

                                    <div class="cleared"></div>
                                </div>
                            </div>
                            <div class="cleared"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="cleared"></div>
        <div class="art-footer">
            <div class="art-footer-body">
                <a href="#" class="art-rss-tag-icon" title="RSS"></a>
                <div class="art-footer-text">
                    <p>
                        <a href="#">关于我们</a> | <a href="#">联系我们</a> | <a href="#">人才招聘</a>
                        | <a href="#">商家入驻</a><br/> 版权 &#169; 2012 ---. 传智播客 版权所有.
                    </p>
                </div>
                <div class="cleared"></div>
            </div>
        </div>
        <div class="cleared"></div>
    </div>
</div>
<div class="cleared"></div>
</div>
</body>
</html>
