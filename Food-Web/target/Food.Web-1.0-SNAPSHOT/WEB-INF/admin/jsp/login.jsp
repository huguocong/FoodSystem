<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>餐厅后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="../../../admin/css/login.css"/>
    <script src="../../../admin/plugins/jquery-2.2.3.min.js"></script>
    <script src="../../../admin/plugins/bootstrap.min.js"></script>
    <script type="text/javascript">
        function login() {
            var fora={};
            var as=$("#loginform").serializeArray();
            $.each(as,function (i,item) {
                fora[item.name]=item.value;
            });
            $.ajax({
                type:"POST",
                url:"/AdminUser/Login.do",
                data:JSON.stringify(fora),
                contentType:'application/json',
                crossDomain:true,
                success:function (data) {
                    if (data.bool==true) {
                        window.location.href="/AdminIndex.do";
                    }else {
                        window.location.reload();
                    }
                },
                error:function (data) {
                    alert("错误");
                }
            })
        }
    </script>
</head>
<body>
<div class='signup_container'>
    <div class="w-load"><div class="spin"></div></div>
    <h1 class='signup_title'>餐厅后台管理系统</h1>
    <div id="userInfo">
        <span style="float:left; margin-left:20px; height:200px; border:0px solid red"><img src='../../../admin/images/1.png' id='admin'/></span>
        <span style="float:left; margin-left:40px; height:200px; border:0px solid red">
             <div id="err">${loginerror}</div>
            <div id="signup_forms" class="signup_forms clearfix">
                        <form class="signup_form_form" id="loginform" >
                                <div class="form_row first_row">
                                    <label for="signup_email">请输入用户名</label>
                                    <input type="text" name="username" placeholder="请输入用户名" id="signup_name" value="${cookie.remebername.value}">
                                </div>
                                <div class="form_row">
                                    <label for="signup_password">请输入密码</label>
                                    <input type="password" name="password" placeholder="请输入密码" id="signup_password" >
                                </div>
								<div class="form_row">
								  <span><input type="checkbox" id="autologin" name="autologin" ${not empty cookie.autologin?"checked='checked'":""}> 自动登录
								  <input type="checkbox" id="remebername" name="remebername" ${not empty cookie.remebername?"checked='checked'":""}> 记住用户名
								  </span>

                                </div>

                       </form>
            </div>
            <div id="foo"></div>
                	<br/>
        </span>
    </div>

    <div class="login-btn-set"><a href='javascript:void (0)' class='login-btn' onclick="login()"></a></div>
</div>
</body>
</html>
