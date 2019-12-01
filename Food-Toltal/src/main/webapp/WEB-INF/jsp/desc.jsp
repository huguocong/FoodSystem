<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网络订餐系统</title>
    <link href="../../css/common.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/product.css" rel="stylesheet" type="text/css"/>
    <script src="../../js/jquery-2.2.3.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function add1() {
            var i=$("#quantity").val();
            $("#quantity").val(++i);
        }
        function res() {
            var i=$("#quantity").val();
            if (i>1) {
                $("#quantity").val(--i);
            }
        }

        function Cart() {
            var id=$("#ids").val();
            var num=$("#quantity").val();
         $.post("/Cart/Add.do",{id:id,num:num},function (data) {
            alert(data.message);
         });
        }
    </script>
</head>
<body>
<%@ include file="../pub/header.jsp" %>

<div class="container productContent">
    <div class="span6">
    </div>
    <div class="span18 last">

        <form id="des">
            <input type="hidden" id="ids" name="id" value="${findfood.id}">
        <div class="productImage">
            <a title="" style="outline-style: none; text-decoration: none;" id="zoom" href="#" rel="gallery">
                <div class="zoomPad">
                    <img style="opacity: 1;" title="" class="medium" src="${findfood.img}">
                </div>
            </a>
        </div>
        <div class="name">${findfood.foodname}</div>
        <div class="sn">
            <div>编号：${findfood.id}</div>
        </div>
        <div class="info">
            <dl>
                <dt>价格:</dt>
                <dd>
                    <strong>￥：${findfood.price}</strong>
                    会员价：
                    <del>￥${findfood.mprice}</del>
                </dd>
            </dl>
            <dl>
                <dt>热销:</dt>
                <dd>
                    <a target="_blank" title="限时抢购 (2014-07-30 ~ 2015-01-01)">热门推荐</a>
                </dd>
            </dl>
            <dl>
                <dt>    </dt>
                <dd>
                    <span>    </span>
                </dd>
            </dl>
        </div>
        <div class="action">

            <dl class="quantity">
                <dt>预订:</dt>
                <dd>
                    <input id="quantity" name="num" value="1" maxlength="4" onpaste="return false;" type="text">
                    <div>
                        <a id="increase" class="increase"href="javascript:void(0);" onclick="add1()">&nbsp;</a>
                        <a id="decrease" class="decrease" href="javascript:void(0);" onclick="res()">&nbsp;</a>
                    </div>
                </dd>
                <dd>
                    件
                </dd>
            </dl>
            <div class="buy">
                <input id="addCart" class="addCart" value="加入列表清单" type="button" onclick="Cart()">
            </div>
        </div>
        </form>
    </div>
</div>
<%@ include file="../pub/foot.jsp" %>
</body>
</html>
