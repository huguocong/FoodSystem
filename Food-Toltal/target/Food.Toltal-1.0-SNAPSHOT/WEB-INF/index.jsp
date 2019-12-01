<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>网络订餐系统</title>
    <link href="../css/slider.css" rel="stylesheet" type="text/css"/>
    <link href="../css/common.css" rel="stylesheet" type="text/css"/>
    <link href="../css/index.css" rel="stylesheet" type="text/css"/>
    <link href="../css/common.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript">
        function findone(id) {
            window.location.href="/CaiDan/Desc.do?id="+id;
        }
    </script>
</head>
<body>


<%@ include file="pub/header.jsp" %>

<div class="container index">
    <div class="span24">
        <div id="hotProduct" class="hotProduct clearfix">
            <div class="title">
                <strong>店主推荐</strong>
            </div>
            <ul class="tab">
            </ul>
            <ul class="tabContent" style="display: block;">
                <c:forEach items="${tui}" var="s">
                    <li>
                        <a href="javascript:void(0);" onclick="findone(${s.id})">
                            <img src="${s.img}"style="display:block;">
                            <span style='color:green'>
                                    ${s.foodname}
                            </span>
                            <div class="price">
                                价格： ￥${s.price}
                            </div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="span24">
        <div id="newProduct" class="newProduct clearfix">
            <div class="title">
                <strong>最新菜品</strong>
                <a  target="_blank"></a>
            </div>
            <ul class="tab">
            </ul>
            <ul class="tabContent" style="display: block;">
                <c:forEach items="${new1}" var="s">
                    <li>
                        <a href="javascript:void(0);" onclick="findone(${s.id})">
                            <img src="${s.img}"style="display:block;">
                            <span style='color:green'>
                                    ${s.foodname}
                            </span>
                            <div class="price">
												价格： ￥${s.price}
											</div>
                        </a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </div>
    <div class="span24">
        <div class="friendLink">
            <dl>
                <dt>新手指南</dt>
                <dd>
                    <a  target="_blank">支付方式</a>
                    |
                </dd>
                <dd>
                    <a  target="_blank">预约订购</a>
                    |
                </dd>
                <dd>
                    <a  target="_blank">售后服务</a>
                    |
                </dd>
                <dd>
                    <a  target="_blank">使用帮助</a>
                    |
                </dd>
                <dd>
                    <a  target="_blank">套餐</a>
                    |
                </dd>
                <dd>
                    <a  target="_blank">礼品卡</a>
                    |
                </dd>
                <dd>
                    <a target="_blank">银联卡</a>
                    |
                </dd>
                <dd>
                    <a  target="_blank">亿家卡</a>
                    |
                </dd>

                <dd class="more">
                    <a >更多</a>
                </dd>
            </dl>
        </div>
    </div>
</div>
<%@ include file="pub/foot.jsp" %>
</body></html>