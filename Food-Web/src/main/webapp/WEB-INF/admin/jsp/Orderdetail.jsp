<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>餐桌管理</title>
    <link rel="stylesheet" href="../../../admin/plugins/bootstrap.min.css">
    <link rel="stylesheet" href="../../../admin/plugins/AdminLTE.css">
    <link rel="stylesheet" href="../../../admin/plugins/_all-skins.min.css">
    <link rel="stylesheet" href="../../../admin/css/style.css">
    <script src="../../../admin/plugins/jquery-2.2.3.min.js"></script>
    <script src="../../../admin/plugins/bootstrap.min.js"></script>
</head>
<body>

<div class="box-header with-border">
    <h3 class="box-title">管理</h3>
</div>


<div class="box-body" >

    <!-- 数据表格 -->
    <div class="table-box">

        <!--工具栏/-->

        <!--数据列表-->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
            <thead>
            <tr>
                <th class="sorting">订单编号</th>
                <th class="sorting">菜名</th>
                <th class="sorting">单价</th>
                <th class="sorting">数量</th>
                <th class="sorting">小计</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Orderdetail}" var="s">
                <tr >
                    <td>${s.orders.orderId}</td>
                    <td>${s.food.foodname}</td>
                    <td>${s.food.price}</td>
                    <td>${s.foodcount}</td>
                    <td>${s.count}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
