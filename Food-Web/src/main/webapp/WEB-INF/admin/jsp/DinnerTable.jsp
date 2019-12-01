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
        //删除
        function Delete(id){
            $.post("/AdminTable/Delete.do",{id:id},function (data) {
                if (data==null){
                    alert("错误");
                } else {
                    alert(data.message);
                    window.location.reload();
                }
            })
        }
        //退桌
        function Tuizhuo(id){
            $.post("/AdminTable/TuiZhuo.do",{id,id},function (date) {
                if (date==null){
                    alert("错误");
                } else {
                    alert(date.message);
                    window.location.reload();
                }
            })
        }

        function ToSave(){
            window.location.href="/AdminTable/ToSave.do";
        }
        //首页
        $(document).ready(function () {
            $("#shou").click(function () {

                //获取input关键字
                var name=$("#username").val();
                var s=$("#shou").attr("href");
                $("#shou").attr("href",s+"&DinnerTableName="+name);
            });
        })

        //上一页
        $(document).ready(function () {
            $("#shang").click(function () {
                //获取input关键字
                var name=$("#username").val();
                var s=$("#shang").attr("href");
                $("#shang").attr("href",s+"&DinnerTableName="+name);
            });
        })

        //下一页
        $(document).ready(function () {
            $("#xia").click(function () {
                //获取input关键字
                var name=$("#username").val();
                var s=$("#xia").attr("href");
                $("#xia").attr("href",s+"&DinnerTableName="+name);
            })
        })
        //尾页
        $(document).ready(function () {
            $("#wei").click(function () {
                //获取input关键字
                var name=$("#username").val();
                var s=$("#wei").attr("href");
                $("#wei").attr("href",s+"&DinnerTableName="+name);
            });
        })

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
                    <button type="button" class="btn btn-default" title="添加" data-toggle="modal" onclick="ToSave()">新建</button>
                </div>
            </div>
        </div>
        <div class="box-tools pull-right">
            <form action="/AdminTable/Search.do" method="post">
                <div class="has-feedback">
                    餐桌：<input type="text" name="DinnerTableName" id="username" value="${DinnerTableName}">&nbsp
                    <button class="btn btn-default" type="submit" value="">查询</button>
                </div>
            </form>
        </div>
        <!--工具栏/-->

        <!--数据列表-->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
            <thead>
            <tr>
                <th class="sorting">编号</th>
                <th class="sorting">餐桌</th>
                <th class="sorting">状态</th>
                <th class="sorting">预订时间</th>
                <th class="sorting">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${dinnertable.row}" var="s">
                <tr >
                    <td>${s.id}</td>
                    <td>${s.tablename}</td>
                    <td>${s.tablestatus==1?'预订':'空闲'}</td>
                    <td><fmt:formatDate value="${s.orderdate}"/></td>
                    <td><button class="btn bg-olive btn-xs" onclick="Delete(${s.id})">删除</button>  &nbsp
                        <c:if test="${s.tablestatus==1}"><button class="btn bg-olive btn-xs" data-toggle="modal" onclick="Tuizhuo(${s.id})">退桌</button></c:if>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="12">
                    第 ${dinnertable.cunrt } / ${dinnertable.totalpaeg }
                    &nbsp;&nbsp;
                    每页显示${dinnertable.size }条  &nbsp;&nbsp;&nbsp;
                    总的记录数${dinnertable.total } &nbsp;&nbsp;&nbsp;
                    <c:if test="${dinnertable.cunrt !=1 }">
                        <a href="/AdminTable/Search.do?Cunt=1" id="shou">首页</a>
                        | <a href="/AdminTable/Search.do?Cunt=${dinnertable.cunrt-1}" id="shang">上一页</a>
                    </c:if>
                    <c:if test="${dinnertable.cunrt !=dinnertable.totalpaeg}">
                        <a href="/AdminTable/Search.do?Cunt=${dinnertable.cunrt+1 }" id="xia">下一页</a> |
                        <a href="/AdminTable/Search.do?Cunt=${dinnertable.totalpaeg}" id="wei">尾页</a>
                    </c:if>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
