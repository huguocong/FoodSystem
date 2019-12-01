<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/21
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="../../../admin/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../../../admin/css/index_1.css" />
    <script src="../../../admin/plugins/jquery-2.2.3.min.js"></script>
    <script src="../../../admin/plugins/bootstrap.min.js"></script>
    <script type="text/javascript">
        function save() {
            var url="/AdminTable/Save.do";
            var ids=$("#id").val();
            if (ids!=""){
                url="/AdminTable/Updata.do";
            }
            var forObjext={};
            var fs=$("#dinnertableform").serializeArray();
            $.each(fs,function(i,item){
                forObjext[item.name]=item.value;
            });
            $.ajax({
                type:"POST",
                url:url,
                data:JSON.stringify(forObjext),
                contentType:'application/json',
                success:function (date) {
                    alert(date.message);
                    window.location.reload();
                },
                error:function (data) {
                    alert("错误");
                }
            });
        }
    </script>
</head>
<body>
<!-- 主内容区域（数据列表或表单显示） -->
<div id="MainArea">
    <!-- 表单内容 -->
    <form id="dinnertableform">
    <!-- 本段标题（分段标题） -->
    <div class="ItemBlock_Title">
         新桌信息&nbsp;
    </div>
    <!-- 本段表单字段 -->
    <div class="ItemBlockBorder">
        <div class="ItemBlock">
            <div class="ItemBlock2">
                <table cellpadding="0" cellspacing="0" class="mainForm">
                    <tr>
                        <td><input type="hidden" id="id" name="id" class="InputStyle"/></td>
                    </tr>
                    <tr>
                        <td width="80px">新桌名字</td>
                        <td><input type="text" id="tablename" name="tablename" class="InputStyle"/>*</td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
    </form>
    <!-- 表单操作 -->
    <div id="InputDetailBar">
        <button class="FunctionButtonInput" onclick="save()" >保存</button>
        <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
    </div>

</div>


</body>
</html>
