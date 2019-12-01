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
            $.post("/AdminFood/Delete.do",{id:id},function (data) {
                if (data==null){
                    alert("错误");
                } else {
                    alert(data.message);
                    window.location.reload();
                }
            })
        }
        function ToSave(id){
            if (id==0){
                window.location.href="/AdminFood/ToSave.do";
            } else {
                window.location.href="/AdminFood/ToSave.do?id="+id;
            }
        }
        //首页
        $(document).ready(function () {
            $("#shou").click(function () {

                //获取input关键字
                var name=$("#foodname").val();
                var cat=$("#findcat").val();
                var s=$("#shou").attr("href");
                $("#shou").attr("href",s+"&foodname="+name+"&findfoodcat="+cat);
            });
        })

        //上一页
        $(document).ready(function () {
            $("#shang").click(function () {
                //获取input关键字
                var name=$("#foodname").val();
                var cat=$("#findcat").val();
                var s=$("#shang").attr("href");
                $("#shang").attr("href",s+"&foodname="+name+"&findfoodcat="+cat);
            });
        })

        //下一页
        $(document).ready(function () {
            $("#xia").click(function () {
                //获取input关键字
                var name=$("#foodname").val();
                var cat=$("#findcat").val();
                var s=$("#xia").attr("href");
                $("#xia").attr("href",s+"&foodname="+name+"&findfoodcat="+cat);
            })
        })
        //尾页
        $(document).ready(function () {
            $("#wei").click(function () {
                //获取input关键字
                var name=$("#foodname").val();
                var cat=$("#findcat").val();
                var s=$("#wei").attr("href");
                $("#wei").attr("href",s+"&foodname="+name+"&findfoodcat="+cat);
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
                    <button type="button" class="btn btn-default" title="添加" data-toggle="modal" onclick="ToSave(0)">新建</button>
                </div>
            </div>
        </div>
        <div class="box-tools pull-right">
            <form action="/AdminFood/Search.do" method="post">
                <div class="has-feedback">
                    菜名：<input type="text" name="foodname" id="foodname" value="${foodname}">&nbsp
                    分类：<select name="findfoodcat"  style="width: 150px" id="findcat">
                    <c:if test="${findfoodcat!=null}">
                        <option value="${findfoodcat.id}">${findfoodcat.name}</option>
                    </c:if>
                    <option value="">--请选择--</option>
                    <c:forEach items="${allcat}" var="s">
                        <option value="${s.id}">${s.name}</option>
                    </c:forEach>
                </select>&nbsp
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
                <th class="sorting">菜名</th>
                <th class="sorting">一级分类</th>
                <th class="sorting">二级分类</th>
                <th class="sorting">图片</th>
                <th class="sorting">价格</th>
                <th class="sorting">是否推荐</th>
                <th class="sorting">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${Food.row}" var="s">
                <tr >
                    <td>${s.id}</td>
                    <td>${s.foodname}</td>
                    <td>${s.cat1}</td>
                    <td>${s.cat2}</td>
                    <td><img width="40" height="45" src="${s.img}"></td>
                    <td>${s.price}</td>
                    <td>${s.istuijian==0?'是':'否'}</td>
                    <td>
                        <button class="btn bg-olive btn-xs" onclick="ToSave(${s.id})">更新</button>
                        &nbsp<button class="btn bg-olive btn-xs" onclick="Delete(${s.id})">删除</button>
                    </td>
                </tr>
            </c:forEach>

            <tr>
                <td colspan="12">
                    第 ${Food.cunrt } / ${Food.totalpaeg }
                    &nbsp;&nbsp;
                    每页显示${Food.size }条  &nbsp;&nbsp;&nbsp;
                    总的记录数${Food.total } &nbsp;&nbsp;&nbsp;
                    <c:if test="${Food.cunrt !=1 }">
                        <a href="/AdminFood/Search.do?Cunt=1" id="shou">首页</a>
                        | <a href="/AdminFood/Search.do?Cunt=${Food.cunrt-1}" id="shang">上一页</a>
                    </c:if>
                    <c:if test="${Food.cunrt !=Food.totalpaeg}">
                        <a href="/AdminFood/Search.do?Cunt=${Food.cunrt+1 }" id="xia">下一页</a> |
                        <a href="/AdminFood/Search.do?Cunt=${Food.totalpaeg}" id="wei">尾页</a>
                    </c:if>
                </td>
            </tr>
            </tbody>
        </table>
    </div>

</div>
</body>
</html>
