<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 2019/11/21
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="../../../admin/css/common_style_blue.css" rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css" href="../../../admin/css/index_1.css" />
    <script src="../../../admin/plugins/jquery-2.2.3.min.js"></script>
    <script src="../../../admin/plugins/bootstrap.min.js"></script>
    <script type="text/javascript">
        function save() {
            var url="/AdminFood/Save.do";
            var ids=$("#id").val();
            if (ids!=""){
                url="/AdminFood/Updata.do";
            }
            var forObjext={};
            var fs=$("#foodform").serializeArray();
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

        //图片上传
        function send() {
            if ($("#img_1").val()!='') {
                var formate = new FormData();
                //formate.append("file",$("#img_1").get(0).files[0]);
                formate.append("file",document.getElementById("img_1").files[0]);
                $.ajax({
                    url:"/AdminFood/UploadFD.do",
                    type:"POST",
                    data:formate,
                    processData : false, // jQuery不要去处理发送的数据
                    contentType : false, // jQuery不要去设置Content-Type请求头
                    success:function (data) {
                        alert("上传成功");
                        $("#imgname").val(data);
                        document.getElementById("img1").src=data;
                    },
                    error:function () {
                        alert("错误");
                    }
                })
            }
        }

        $(document).ready(function () {
            $("#cat1").change(function () {
                var cat1=$(this).val();
                $.post("/AdminFoodCat/OneToTwo.do",{id:cat1},function (data) {
                    $("#cat2").html("<option value=''>--请选择--");
                    $(data).each(function (index,c) {
                        $("#cat2").append("<option value='"+c.id+"'>"+c.name)
                    });
                },"json")
            })
        });
    </script>
</head>
<body>
<div id="MainArea">
    <!-- 表单内容 -->
    <form id="foodform">
        <!-- 本段标题（分段标题） -->
        <div class="ItemBlock_Title">
         菜品信息&nbsp;
        </div>
        <!-- 本段表单字段 -->
        <div class="ItemBlockBorder">
            <div class="ItemBlock">
                <div class="ItemBlock2">
                    <table cellpadding="0" cellspacing="0" class="mainForm">
                        <tr>
                            <td><input type="hidden" name="id" value="${FoodInput.id}" id="id" /></td>
                        </tr>
                        <tr>
                            <td width="80px">一级分类</td>
                            <td>
                                <select name="foodtypeId1" style="width:80px" id="cat1">
                                    <c:if test="${FoodInput.foodtypeId1!=null}">
                                        <option value="${FoodInput.foodtypeId1}">${FoodInput.cat1}</option>
                                    </c:if>
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${footcat1}" var="s">
                                        <option value="${s.id}">${s.name}</option>
                                    </c:forEach>
                                </select>
                                *</td>
                        </tr>
                        <tr>
                            <td width="80px">二级分类</td>
                            <td>
                                <select name="foodtypeId2" style="width:80px" id="cat2">
                                    <c:if test="${FoodInput.foodtypeId2!=null}">
                                    <option value="${FoodInput.foodtypeId2}">${FoodInput.cat2}</option>
                                    </c:if>
                                    <option value="">--请选择--</option>
                                </select>
                                *</td>
                        </tr>
                        <tr>
                            <td width="80px">菜名</td>
                            <td><input type="text" name="foodname" class="InputStyle" value="${FoodInput.foodname}"/> *</td>
                        </tr>
                        <tr>
                            <td>价格</td>
                            <td><input type="text" name="price" class="InputStyle" value="${FoodInput.price}"/> *</td>
                        </tr>
                        <tr>
                            <td>会员价格</td>
                            <td><input type="text" name="mprice" class="InputStyle" value="${FoodInput.mprice}"/> *</td>
                        </tr>
                        <tr>
                            <td>是否推荐</td>
                            <td><select name="istuijian" style="width:80px" >
                                <c:if test="${FoodInput.istuijian!=null}">
                                    <option value="${FoodInput.istuijian}">${FoodInput.istuijian==0?'是':'否'}</option>
                                </c:if>
                                <option value="0" }>是</option>
                                <option value="1">否</option>
                            </select>
                            </td>
                        </tr>
                        <tr>
                            <td>简介</td>
                            <td><textarea name="remark" class="TextareaStyle"  >${FoodInput.remark}</textarea></td>
                        </tr>
                        <tr>
                            <td width="80px">菜品图片</td>
                            <td>
                                <input type="hidden" id="imgname" name="img" value="${FoodInput.img}">
                                <input type="file" name="img" id="img_1"/>
                            <input type="button" class="FunctionButtonInput" onclick="send()" value="上传"></input>
                            </td>
                        </tr>
                        <tr>
                            <td></td>
                            <td>
                              <img id="img1" width="40" height="45" src="${ pageContext.request.contextPath }/${FoodInput.img}" alt="未上传">
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
        <!-- 表单操作 -->
        <div id="InputDetailBar">
            <button class="FunctionButtonInput" onclick="save()" >保存</button>
            <a href="javascript:history.go(-1);" class="FunctionButton">返回</a>
        </div>
    </form>
</div>
</body>
<
</html>
