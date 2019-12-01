<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <link href="../../css/common.css" rel="stylesheet" type="text/css">
    <link href="../../css/product.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/login.css" rel="stylesheet" type="text/css"/>
    <script src="../../js/jquery-2.2.3.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript">
        function login() {
            var fora = {};
            var as = $("#loginform").serializeArray();
            $.each(as, function (i, item) {
                fora[item.name] = item.value;
            });
            $.ajax({
                type: "POST",
                url: "/User/Login.do",
                data: JSON.stringify(fora),
                contentType: 'application/json',
                crossDomain: true,
                success: function (data) {
                    if (data.bool==true) {
                        window.location.href = data.message;
                    } else {

                        window.location.reload();
                    }
                },
                error: function (data) {
                    alert("错误");
                }
            });

        }
    </script>
</head>
<body>
<%@ include file="../pub/header.jsp" %>
<div class="container login">
    <div class="span12">
        <div class="ad">

            <img src="../../images/12.png" width="500" height="330" alt="会员登录" title="会员登录">

        </div>
    </div>
    <div class="span12 last">
        <div class="wrap">
            <div class="main">
                <div class="title">
                    <strong>用户登录</strong>USER LOGIN
                </div>
                <form id="loginform"  method="post" novalidate="novalidate">
                    <table>
                        <tbody>
                        <tr>
                            <th>
                                用户名:
                            </th>
                            <td>
                                <input type="text" id="username" name="username" class="text" maxlength="20">

                            </td>
                        </tr>
                        <tr>
                            <th>
                                密&nbsp;&nbsp;码:
                            </th>
                            <td>
                                <input type="password" id="password" name="password" class="text" maxlength="20" autocomplete="off">
                            </td>
                        </tr>

                        <tr>
                            <th>&nbsp;

                            </th>
                            <td>
                                <label>
                                    <input type="checkbox" id="remebername" name="remebername" ${not empty cookie.uremebername?"checked='checked'":""}>记住用户名
                                </label>&nbsp;&nbsp;
                                <label>
                                    <input type="checkbox" id="remebername" name="autologin" ${not empty cookie.uautologin?"checked='checked'":""}>自动登录
                                </label>
                            </td>
                        </tr>
                        <tr>
                            <th>&nbsp;

                            </th>
                            <td>
                                <input type="button" class="submit" value="登 录" onclick="login()"><div>${loginerror}</div>
                            </td>
                        </tr>
                        <tr class="register">
                            <th>&nbsp;

                            </th>
                            <td>
                                <dl>
                                    <dt>还没有注册账号？</dt>
                                    <dd>
                                        立即注册即可体验在线订餐！
                                        <a href="/User/ToRsgister.do">立即注册</a>
                                    </dd>
                                </dl>
                            </td>
                        </tr>
                        </tbody></table>
                </form>
            </div>
        </div>
    </div>

</div>
<%@ include file="../pub/foot.jsp" %>
</body>
</html>
