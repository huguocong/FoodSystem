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
            $.post("/AdminFoodCat/Delete.do",{id:id},function (data) {
                if (data==null){
                    alert("错误");
                } else {
                    alert(data.message);
                    window.location.reload();
                }
            })
        }
        function Next(id,name){
            window.location.href="/AdminFoodCat/Find.do?parentID="+id+"&name="+name;
        }

        function ToSave(id,name) {
            window.location.href="/AdminFoodCat/ToSave.do?id="+id+"&name="+name;
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
        <ol class="breadcrumb">
            <li>
                <a href="/AdminFoodCat/Find.do" >顶级分类列表</a>
            </li>
            <li>
                <a href="javascript:void(0);" onclick="Next(${parentid},'${parentname}')">${parentname} </a>
            </li>
        </ol>

        <!--工具栏-->
        <div class="pull-left">
            <div class="form-group form-inline">
                <div class="btn-group">
                    <button type="button" class="btn btn-default" title="添加" data-toggle="modal" onclick="ToSave(${parentid==null?0:parentid},0)">新建</button>
                </div>
            </div>
        </div>
        <!--工具栏/-->

        <!--数据列表-->
        <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
            <thead>
            <tr>
                <th class="sorting">编号</th>
                <th class="sorting">目录</th>
                <th class="sorting">操作</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${FoodCat}" var="s">
                <tr >
                    <td>${s.id}</td>
                    <td>${s.name}</td>
                    <td>
                        <c:if test="${parentid==null}">
                        <button class="btn bg-olive btn-xs" onclick="Next(${s.id},'${s.name}')">下级目录</button>
                        </c:if>
                        &nbsp<button class="btn bg-olive btn-xs" onclick="ToSave(${s.id},1)">更新</button>
                        &nbsp<button class="btn bg-olive btn-xs" onclick="Delete(${s.id})">删除</button>
                    </td>
                </tr>
            </c:forEach>


            </tbody>
        </table>
    </div>

</div>
</body>
</html>
