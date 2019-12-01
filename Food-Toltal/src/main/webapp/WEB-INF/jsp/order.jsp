
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>生成订单</title>
    <link href="../../css/common.css" rel="stylesheet" type="text/css">
    <link href="../../css/cart.css" rel="stylesheet" type="text/css">
    <link href="../../css/product.css" rel="stylesheet" type="text/css"/>
    <script src="../../js/jquery-2.2.3.min.js"></script>
    <script src="../../js/bootstrap.min.js"></script>
    <script type="text/javascript">
      function x() {
          $.post("/Order/Zhuo.do",function (data) {
              $("#tableid") .html("<option value='' >-请选择-");
              $(data).each(function (index,c) {
                  $("#tableid").append("<option value='"+c.id+"'>"+c.tablename);
              });
          });
      }
      function sub() {
          var id=$("#id").val();
          var tableid=$("#tableid").val();
          var peple=$("#peple").val();
          var tel=$("#tel").val();
          $.post("/Order/YuDing.do",{id:id,tableid:tableid,people:peple,tele:tel},function (data) {
              if (data.bool==true){
                  alert(data.message);
                  window.location.href="/Order/Search.do";
              }
          });
      }
    </script>
</head>
<body onload="x()">
<%@ include file="../pub/header.jsp" %>
<div class="container cart">

    <div class="span24">

        <div class="step step1">
            <ul>

                <li  class="current"></li>
                <li  >生成订单成功</li>
            </ul>
        </div>


        <table>
            <tbody>
            <tr class="warning">
                <th colspan="5">
                    订单编号:${order.orderId} &nbsp; &nbsp;
                    日期：<f:formatDate value="${order.orderdate}"/>
                </th>
            </tr>
            <tr>
                <th>图片</th>
                <th>商品</th>
                <th>价格</th>
                <th>数量</th>
                <th>小计</th>
            </tr>

            <c:forEach items="${order.list}" var="c">
            <tr>
                <td width="60">
                    <img src="${c.food.img}"/>
                </td>
                <td>
                    <a target="_blank">${c.food.foodname}</a>
                </td>
                <td>
                   ${c.food.price}
                </td>
                <td class="quantity" width="60">
                   ${c.foodcount}
                </td>
                <td width="140">
                    <span class="subtotal">￥${c.count}</span>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <dl id="giftItems" class="hidden" style="display: none;">
        </dl>
        <div class="total">
            <em id="promotion"></em>
            商品金额: <strong id="effectivePrice">￥${order.totalprice}</strong>
        </div>
        <form id="orderForm" action="/Order/YuDing.do" method="post">
            <div class="span24">
                <p>
                    <input type="hidden" name="id" value="${order.id}" id="id"/>
                    预订餐桌：<select style="width:150px"  name="tableid"  id="tableid">
                            <option value=""/>--请选择--
                            </select>
                    <br />
                    联系人&nbsp;&nbsp;&nbsp;：<input name="people" type="text"  style="width:150px" id="peple" />
                    <br />
                    联系方式：<input name="tele" type="text" style="width:150px"  id="tel"/>

                <hr />
                <p style="text-align:right">
                  <%--  <a href="javascript:document.getElementById('orderForm').submit();">--%>
                    <a href="javascript:void(0);" onclick="sub()">
                        <img src="../../images/finalbutton.gif" width="204" height="51" border="0" />
                    </a>
                </p>
            </div>
        </form>
    </div>

</div>



<%@ include file="../pub/foot.jsp" %>
</body>
</html>
