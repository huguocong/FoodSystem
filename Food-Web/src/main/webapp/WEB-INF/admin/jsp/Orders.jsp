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
    <script type="text/javascript">


        //首页
        $(document).ready(function () {
            $("#shou").click(function () {

                //获取input关键字
                var name=$("#orderid").val();
                var s=$("#shou").attr("href");
                $("#shou").attr("href",s+"&orderid="+name);
            });
        })

        //上一页
        $(document).ready(function () {
            $("#shang").click(function () {
                //获取input关键字
                var name=$("#orderid").val();
                var s=$("#shang").attr("href");
                $("#shang").attr("href",s+"&orderid="+name);
            });
        })

        //下一页
        $(document).ready(function () {
            $("#xia").click(function () {
                //获取input关键字
                var name=$("#orderid").val();
                var s=$("#xia").attr("href");
                $("#xia").attr("href",s+"&orderid="+name);
            })
        })
        //尾页
        $(document).ready(function () {
            $("#wei").click(function () {
                //获取input关键字
                var name=$("#orderid").val();
                var s=$("#wei").attr("href");
                $("#wei").attr("href",s+"&orderid="+name);
            });
        })

        //订单详情
        function XiangQing(id) {
            window.location.href="/AdminOrders/Orderdetail.do?id="+id;
        }

    </script>
</head>
<body>

<div class="box-header with-border">
    <h3 class="box-title">管理</h3>
</div>


<div class="box-body" >

    <!-- 数据表格 -->
    <div class="table-box">

        <!--工具栏-->
        <div class="pull-left">
            <div class="form-group form-inline">
                <div class="btn-group">
                </div>
            </div>
        </div>
        <div class="box-tools pull-right">
            <form action="/AdminOrders/Search.do" method="post">
                <div class="has-feedback">
                    订单号：<input type="text" name="orderid" id="orderid" value="${orderid}">&nbsp
                    <button class="btn btn-default" type="submit" value="">查询</button>
                </div>
            </form>
        </div>
        <!--工具栏/-->

        <!--数据列表-->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
            <thead>
            <tr>
                <th class="sorting">订单编号</th>
                <th class="sorting">下单日期</th>
                <th class="sorting">总金额</th>
                <th class="sorting">状态</th>
                <th class="sorting">餐桌名</th>
                <th class="sorting">预订人</th>
                <th class="sorting">联系电话</th>
                <th class="sorting">下单用户</th>
                <th class="sorting">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Orders.row}" var="s">
                <tr >
                    <td>${s.orderId}</td>
                    <td><fmt:formatDate value="${s.orderdate}"/></td>
                    <td>${s.totalprice}</td>
                    <c:if test="${s.orderstatus==0}">
                        <td>未预定</td>
                    </c:if>
                    <c:if test="${s.orderstatus==1}">
                        <td>已预定</td>
                    </c:if>
                    <c:if test="${s.orderstatus==2}">
                        <td>结束</td>
                    </c:if>
                    <td>${s.dinnertable.tablename}</td>
                    <td>${s.people}</td>
                    <td>${s.tele}</td>
                    <td>${s.user.username}</td>
                    <td>
                        <button class="btn bg-olive btn-xs" onclick="XiangQing(${s.id})">订单详情</button>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="12">
                    第 ${Orders.cunrt } / ${Orders.totalpaeg }
                    &nbsp;&nbsp;
                    每页显示${Orders.size }条  &nbsp;&nbsp;&nbsp;
                    总的记录数${Orders.total } &nbsp;&nbsp;&nbsp;
                    <c:if test="${Orders.cunrt !=1 }">
                        <a href="/AdminOrders/Search.do?Cunt=1" id="shou">首页</a>
                        | <a href="/AdminOrders/Search.do?Cunt=${Orders.cunrt-1}" id="shang">上一页</a>
                    </c:if>
                    <c:if test="${Orders.cunrt !=Orders.totalpaeg}">
                        <a href="/AdminOrders/Search.do?Cunt=${Orders.cunrt+1 }" id="xia">下一页</a> |
                        <a href="/AdminOrders/Search.do?Cunt=${Orders.totalpaeg}" id="wei">尾页</a>
                    </c:if>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
