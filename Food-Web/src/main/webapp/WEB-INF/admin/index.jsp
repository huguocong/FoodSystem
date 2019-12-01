<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/8/15
  Time: 17:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html >
<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>餐厅后台管理系统</title>
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../../admin/plugins/bootstrap.min.css">
    <link rel="stylesheet" href="../../admin/plugins/AdminLTE.css">
    <link rel="stylesheet" href="../../admin/plugins/_all-skins.min.css">
    <link rel="stylesheet" href="../../admin/css/style.css">
    <script src="../../admin/plugins/jquery-2.2.3.min.js"></script>
    <script src="../../admin/plugins/bootstrap.min.js"></script>
    <script src="../../admin/plugins/app.min.js"></script>
    <script type="text/javascript">
        function SetIFrameHeight(){
            var iframeid=document.getElementById("iframe"); //iframe id
            if (document.getElementById){
                iframeid.height =document.documentElement.clientHeight;
            }
        }


        $(document).ready(function () {
            $("#addIn").click(function () {
                var oldpwd=$("#yuanmima").val();
                var newpwd1=$("#newmima").val();
                var newpwd=$("#cnewmima").val();
                if (oldpwd==""){
                    $("#liang").html("<font color='red'>原密码不能为空</font> ");
                } else if (newpwd1==""){
                    $("#liang").html("<font color='red'>新密码不能为空</font> ");
                } else if (newpwd!=newpwd1){
                    $("#liang").html("<font color='red'>两次输入密码不一致</font> ");
                } else {
                    $.post("/AdminUser/UpdataPwd.do", {oldpassword: oldpwd, newpassword: newpwd}, function (data) {
                        alert(data.message);
                        window.location.reload();
                    })
                }
            });
        });

    </script>
</head>
<body class="hold-transition skin-green sidebar-mini">
<div class="wrapper">
    <!-- 页面头部 -->
    <header class="main-header">
        <a href="index.jsp" class="logo">
            <span class="logo-lg"><b>餐厅后台管理系统</b></span>
        </a>
        <nav class="navbar navbar-static-top">
            <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>

            <c:if test="${not empty name}">
                <div class="navbar-custom-menu">
                    <ul class="nav navbar-nav">
                        <!-- Messages: style can be found in dropdown.less-->
                        <li class="dropdown messages-menu">
                            <a href="javascript:void(0)"  data-toggle="modal" data-target="#editModal" class="dropdown-toggle" >
                                <i class="fa fa-envelope-o"></i>
                                <span >修改密码</span>
                            </a>
                        </li>
                        <!-- Notifications: style can be found in dropdown.less -->
                        <li class="dropdown messages-menu">
                            <a href="/AdminUser/LoginOut.do" class="dropdown-toggle" >
                                <span>退出登录</span>
                            </a>
                        </li>
                        <!-- Tasks: style can be found in dropdown.less -->
                        <li class="dropdown tasks-menu">

                        </li>
                        <!-- User Account: style can be found in dropdown.less -->
                        <li class="dropdown user user-menu">
                        </li>
                    </ul>
                </div>
            </c:if>
        </nav>
    </header>
    <!-- 页面头部 /-->

    <!-- 导航侧栏 -->
    <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
            <!-- Sidebar user panel -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="../../admin/images/user2-160x160.jpg" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <c:if test="${not empty name}">
                        <p>${name}</p>
                        <a href="#"><i class="fa fa-circle text-success"></i> 欢迎您</a>
                    </c:if>

                </div>
            </div>
            <ul class="sidebar-menu"  >
                <li class="header">菜单</li>
                <li id="admin-index"><a href="/index.do" target="_parent"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>
                <li class="treeview">
                    <a href="#">
                        <i class="fa fa-folder"></i>
                        <span>系统菜单</span>
                        <span class="pull-right-container">
				       			<i class="fa fa-angle-left pull-right"></i>
				   		 	</span>
                    </a>
                    <ul class="treeview-menu">
                        <li id="admin-login">
                            <a href="/AdminTable/Search.do" target="iframe">
                                <i class="fa fa-circle-o"></i>餐桌管理
                            </a>
                        </li>
                        <li id="admin-login">
                            <a href="/AdminFood/Search.do" target="iframe">
                                <i class="fa fa-circle-o"></i>菜系管理
                            </a>
                        </li>
                        <li id="admin-login">
                            <a href="/AdminFoodCat/Find.do" target="iframe">
                                <i class="fa fa-circle-o"></i>分类管理
                            </a>
                        </li>
                        <li id="admin-login">
                            <a href="/AdminOrders/Search.do" target="iframe">
                                <i class="fa fa-circle-o"></i>订单管理
                            </a>
                        </li>
                    </ul>
                </li>
            </ul>
        </section>
        <!-- /.sidebar -->
    </aside>
    <!-- 导航侧栏 /-->

    <!-- 内容区域 -->
    <div class="content-wrapper">
        <iframe width="100%" id="iframe" name="iframe"	onload="SetIFrameHeight()"
                frameborder="0" src="/home"></iframe>


    </div>
    <!-- 底部导航 -->
    <footer class="main-footer">
        <div class="pull-right hidden-xs">
            <b>Version</b> 1.0.8
        </div>
        <strong>Copyright &copy; 2014-2017 <a href="#">研究院研发部</a>.</strong> All rights reserved.
    </footer>
    <!-- 底部导航 /-->



</div>


<!-- 编辑窗口 -->
<div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog" >
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h3 id="myModalLabel">编辑</h3>
            </div>
            <div class="modal-body">
                <form id="empupdata" action="/User/UpdataPwd.do" >
                    <table class="table table-bordered table-striped"  width="800px">
                        <tr>
                            <td>原密码</td>
                            <td><input type="password" id="yuanmima" name="yuanmima" class="form-control" placeholder="原密码" ></td>
                        </tr>
                        <tr>
                            <td>新密码</td>
                            <td><input type="password" id="newmima"  class="form-control" placeholder="新密码" ></td>
                        </tr>
                        <tr>
                            <td>确认密码</td>
                            <td><input type="password" id="cnewmima" name="newmima" class="form-control" placeholder="请重新输入" ></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><span id="liang"></span></td>
                        </tr>
                    </table>
                </form>
            </div>
            <div class="modal-footer">
                <button id="addIn" class="btn btn-success"  >保存</button>
                <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">关闭</button>
            </div>
            </form>
        </div>
    </div>
</div>



</body>

</html>
