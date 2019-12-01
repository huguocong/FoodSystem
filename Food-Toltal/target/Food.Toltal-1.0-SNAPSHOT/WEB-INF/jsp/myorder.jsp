
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>我的订单</title>
    <link href="../../css/common.css" rel="stylesheet" type="text/css">
    <link href="../../css/cart.css" rel="stylesheet" type="text/css">
    <link href="../../css/product.css" rel="stylesheet" type="text/css"/>
    <script src="../../js/jquery-2.2.3.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript">
        //首页
        $(document).ready(function () {
            $("#shou").click(function () {
                //获取input关键字
                var name=$("#id").val();
                var s=$("#shou").attr("href");
                $("#shou").attr("href",s+"&id="+name);
            });
        })

        //上一页
        $(document).ready(function () {
            $("#shang").click(function () {
                //获取input关键字
                var name=$("#id").val();
                var s=$("#shang").attr("href");
                $("#shang").attr("href",s+"&id="+name);
            });
        })

        //下一页
        $(document).ready(function () {
            $("#xia").click(function () {
                //获取input关键字
                var name=$("#id").val();
                var s=$("#xia").attr("href");
                $("#xia").attr("href",s+"&id="+name);
            })
        })
        //尾页
        $(document).ready(function () {
            $("#wei").click(function () {
                //获取input关键字
                var name=$("#id").val();
                var s=$("#wei").attr("href");
                $("#wei").attr("href",s+"&id="+name);
            });
        })

        //删除
        function Delete(id) {
            window.location.href="/Order/Delete.do?id="+id;
        }
        function Yu(id) {
            window.location.href="Order/ToJieSuan.do?id="+id;
        }
    </script>
</head>
<body>
<%@ include file="../pub/header.jsp" %>
<div class="container cart">

    <c:if test="${empty orders}">
        <div class="row">
            <div class="col-md-12">
                <h1 style="text-align: center;">居然一个订单都没有</h1>
            </div>
        </div>
    </c:if>
<c:if test="${ not empty orders}">
<div class="span24">
    <div class="box-tools pull-right" style="text-align: right">
        <form action="/Order/Search.do" method="post">
            <div class="has-feedback">
                订单：<input type="text" name="id" id="id" value="">&nbsp
                <button class="btn btn-default" type="submit" value="">查询</button>
            </div>
        </form>
    </div>
        <table>
            <tbody>
            <c:forEach items="${orders.row}" var="order" >
            <tr class="warning">
                <th colspan="4">
                   订单编号:${order.orderId}&nbsp; &nbsp;
                    日期：<f:formatDate value="${order.orderdate}"/> &nbsp; &nbsp;&nbsp; &nbsp;
                    状态：<c:if test="${order.orderstatus==0}">未预定</c:if>
                    <c:if test="${order.orderstatus==1}">已预定:&nbsp;&nbsp;<a href="javascript:void(0);" onclick="Yu(${order.id})">去预定</a> </c:if>
                    <c:if test="${order.orderstatus==2}">交易成功</c:if>
                </th>
                <th>
                    <a href="javascript:void(0);" onclick="Delete(${order.id})">删除</a>
                </th>



            </tr>
            <tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
            </tr>
         <c:forEach items="${order.list}" var="c">
                <tr>
                    <td width="60">
                        <img src="${c.food.img}"/>
                    </td>
                    <td>
                        <a target="_blank">${c.food.foodname}</a>
                    </td>
                    <td>
                            ${c.food.price}
                    </td>
                    <td class="quantity" width="60">
                            ${c.foodcount}
                    </td>
                    <td width="140">
                        <span class="subtotal">￥${c.count}</span>
                    </td>
                </tr>
            </c:forEach>
                <tr>
                    <th colspan="4">
                    </th>
                    <td>
                        总金额：￥${order.totalprice}
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="12">
                    第 ${orders.cunrt } / ${orders.totalpaeg }
                    &nbsp;&nbsp;
                    每页显示${orders.size }条  &nbsp;&nbsp;&nbsp;
                    总的记录数${orders.total } &nbsp;&nbsp;&nbsp;
                    <c:if test="${orders.cunrt !=1 }">
                        <a href="/Order/Search.do?cunt=1" id="shou">首页</a>
                        | <a href="/Order/Search.do?cunt=${orders.cunrt-1}" id="shang">上一页</a>
                    </c:if>
                    <c:if test="${orders.cunrt !=orders.totalpaeg}">
                        <a href="/Order/Search.do?cunt=${orders.cunrt+1 }" id="xia">下一页</a> |
                        <a href="/Order/Search.do?cunt=${orders.totalpaeg}" id="wei">尾页</a>
                    </c:if>
                </td>
            </tr>
            </tbody>

        </table>
    </div>

</c:if>
</div>


<%@ include file="../pub/foot.jsp" %>
</body>
</html>
