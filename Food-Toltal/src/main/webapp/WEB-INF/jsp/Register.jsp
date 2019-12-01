
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../css/common.css" rel="stylesheet" type="text/css">
    <link href="../../css/product.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/register.css" rel="stylesheet" type="text/css"/>
    <script src="../../js/jquery-2.2.3.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function register() {
            var username=$("#username").val();
            var password=$("#password").val();
            var password2=$("#password2").val();
            var name=$("#name").val();
            var tele=$("#tele").val();
            if (username==""){
                $("#s").html("<font color='red'>用户名不能为空</font> ");
            } else if (password==""){
                $("#s").html("<font color='red'>密码不能为空</font> ");
            } else if (password2!=password){
                $("#s").html("<font color='red'>两次密码不一致</font> ");
            } else if (name==""){
                $("#s").html("<font color='red'>昵称不能为空</font> ");
            } else if (tele==""){
                $("#s").html("<font color='red'>电话不能为空</font> ");
            } else {
                var fora = {};
                var as = $("#registerForm").serializeArray();
                $.each(as, function (i, item) {
                    fora[item.name] = item.value;
                });
                $.ajax({
                    type: "POST",
                    url: "/User/Register.do",
                    data: JSON.stringify(fora),
                    contentType: 'application/json',
                    crossDomain: true,
                    success: function (data) {
                        if (data.bool==true) {
                            alert(data.message);
                            window.location.href = "/User/ToLogin.do";
                        } else {
                            alert(data.message);
                            window.location.reload();
                        }
                    },
                    error: function (data) {
                        alert("错误");
                    }
                });
            }
        }
        $(document).ready(function () {
            $("#username").blur(function () {
                var username = $("#username").val();
                $.post("/User/CheckUsername.do", {username: username}, function (data) {
                    if (data.bool == false) {
                        $("#d").html("<font color='red'>用户名存在</font>");
                    }else {
                        $("#d").html("<font color='red'>用户名可用</font>");
                    }
                });
            })
        })


    </script>
</head>
<body>
<%@ include file="../pub/header.jsp" %>
<div class="container register">
    <div class="span24">
        <div class="wrap">
            <div class="main clearfix">
                <div class="title">
                    <strong>会员注册</strong>USER REGISTER
                </div>
                <form id="registerForm"  method="post" novalidate="novalidate">
                    <table>
                        <tbody><tr>
                            <th>
                                <span class="requiredField">*</span>用户名:
                            </th>
                            <td>
                                <input type="text" id="username" name="username" class="text"  maxlength="20"><span id="d"></span>
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="requiredField">*</span>密&nbsp;&nbsp;码:
                            </th>
                            <td>
                                <input type="password" id="password" class="text" maxlength="20" autocomplete="off">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="requiredField">*</span>确认密码:
                            </th>
                            <td>
                                <input type="password" name="password" id="password2"  class="text" maxlength="20" autocomplete="off">
                            </td>
                        </tr>

                        <tr>
                            <th>
                                昵称:
                            </th>
                            <td>
                                <input type="text" name="name" id="name" class="text" maxlength="200">
                            </td>
                        </tr>
                        <tr>
                            <th>
                                <span class="requiredField">*</span>电话:
                            </th>
                            <td>
                                <input type="text" id="tele" name="tele" class="text" maxlength="200">
                            </td>
                        </tr>

                        <tr>
                            <th>&nbsp;

                            </th>
                            <td>
                                <input type="button" class="submit" value="注册" onclick="register()">
                            </td>
                        </tr>
                        <tr>
                            <th>&nbsp;

                            </th>
                            <td>
                                <span id="s"></span>
                            </td>
                        </tr>

                        </tbody></table>
                    <div class="login">
                        <div class="ad">
                            <dl>
                                <dt>
                                    注册
                                </dt>
                                <dd>
                                    建绿色餐馆，倡导绿色生活
                                </dd>
                                <dd>
                                    创建绿色餐饮店，共建环境友好社会
                                </dd>
                                <dd>
                                    公众参与环保，共建绿色家园！
                                </dd>
                            </dl>
                        </div>							<dl>
                        <dt>已经拥有账号了？</dt>
                        <dd>
                            立即登录即可体验在线订餐！
                            <a href="/User/ToLogin.do">立即登录</a>
                        </dd>
                    </dl>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@ include file="../pub/foot.jsp" %>
</body>
</html>
