
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列表清单</title>
    <link href="../../css/common.css" rel="stylesheet" type="text/css">
    <link href="../../css/cart.css" rel="stylesheet" type="text/css">
    <link href="../../css/product.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function add(id,num) {
            num++;
            window.location.href="/Cart/Yun.do?id="+id+"&num="+num;
        }

        function res(id,num) {
            if (num>1){
                num--;
            }
            window.location.href="/Cart/Yun.do?id="+id+"&num="+num;
        }

        function del(id) {
            window.location.href="/Cart/Delete.do?id="+id;
        }

        function cha(id,num) {
            window.location.href="/Cart/Yun.do?id="+id+"&num="+num;
        }
    </script>
</head>
<body>
<%@ include file="../pub/header.jsp" %>
<div class="container cart">
    <c:if test="${empty cart}">
        <div class="row">
            <div class="col-md-12">
                <h1 style="text-align: center;">列表清单空空如也</h1>
            </div>
        </div>
    </c:if>
    <c:if test="${cart!=null}">
    <div class="span24">
        <div class="step step1">

        </div>
        <table>
            <tbody><tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
                <th>操作</th>
            </tr>
            <c:forEach items="${cart.map}" var="x">
            <tr>
                <td width="60">
                    <input type="hidden" name="id" id="id" value="${x.key}">
                    <img src="${x.value.food.img}">
                </td>
                <td>
                    <a target="_blank">${x.value.food.foodname}</a>
                </td>
                <td>
                    ￥${x.value.food.price}
                </td>
                <td class="quantity" width="60">

                      <input type="text" name="quantity" readonly="readonly" value=" ${x.value.num}" maxlength="4" size="10" id="num">
                        <div>
                            <button id="jia" class="increase" onclick="add(${x.key},${x.value.num})">+</button>
                            <button id="jian" class="decrease" onclick="res(${x.key},${x.value.num})">-</button>
                        </div>


                </td>
                <td width="140">
                    <span class="subtotal">￥${x.value.count}</span>
                </td>
                <td>
                    <a href="javascript:del(${x.key});" class="delete">删除</a>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            商品金额: <strong id="effectivePrice">￥${cart.getTotal()}元</strong>
        </div>
        <div class="bottom">
            <a href="/Cart/Clear.do" id="clear" class="clear">清空购物车</a>
            <a href="/Order/JieSuan.do" id="submit" class="submit">提交订单</a>
        </div>
    </div>
    </c:if>

</div>
<%@ include file="../pub/foot.jsp" %>
</body>
</html>
