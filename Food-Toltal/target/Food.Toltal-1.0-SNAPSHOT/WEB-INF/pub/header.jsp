<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/28
  Time: 22:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/slider.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/common.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/index.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="container header">
    <div class="span5">
        <div class="logo">
            <a>

            </a>
        </div>
    </div>
    <div class="span9">
        <div class="headerAd">
            <img src="../image/pub/header.png">
        </div>	</div>
    <div class="span10 last">
        <div class="topNav clearfix">
            <ul>
                <c:if test="${empty uname}">
                <li id="headerLogin" class="headerLogin" style="display: list-item;">
                    <a href="/User/ToLogin.do">登录</a>|
                </li>
                <li id="headerRegister" class="headerRegister" style="display: list-item;">
                    <a href="/User/ToRsgister.do">注册</a>|
                </li>
                <li id="headerUsername" class="headerUsername"></li>
                <li id="headerLogout" class="headerLogout">
                </li>
                </c:if>
                <c:if test="${not empty uname}">
                    <li id="headerRegister" class="headerRegister" style="display: list-item;">
                       欢迎你：${uname}
                    </li>
                    <li>
                        <a href="/User/LoginOut.do">退出登录</a>
                    </li>
                </c:if>
                <li>
                    <a>使用指南</a>
                    |
                </li>
                <li>
                    <a>关于我们</a>

                </li>
            </ul>
        </div>
        <div class="phone">
            客服热线:
            <strong>96008/53277764</strong>
        </div>
    </div>
    <div class="span24">
        <ul class="mainNav">
            <li>
                <a href="/index.do">首页</a>
                |
            </li>
            <li>
                <a href="/CaiDan/Search.do">菜单</a>
                |
            </li>
            <li>
                <a href="/Cart/index.do" >已点清单</a>
                |
            </li>
            <li>
                <a href="/Order/Search.do">我的订单</a>
                |
            </li>
        </ul>
    </div>
</div>

</body>
</html>
