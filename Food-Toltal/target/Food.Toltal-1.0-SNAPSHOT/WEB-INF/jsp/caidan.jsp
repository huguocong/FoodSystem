
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>网络订餐系统</title>
    <link href="../../css/common.css" rel="stylesheet" type="text/css"/>
    <link href="../../css/product.css" rel="stylesheet" type="text/css"/>
    <script type="text/javascript">
        function Page(id) {
            if (id>${food.totalpaeg}){
                id=${food.totalpaeg};
            }
            if (id<1){
                id=1;
            }
            var cat1='';
            var cat2='';
            if (${cat1!=0}){
                alert("sss");
                cat1=${cat1};
            }
            if (${cat2!=0}){
                cat2=${cat2};
            }
            window.location.href="/CaiDan/Search.do?cunt="+id+"&cat1="+cat1+"&cat2="+cat2;
        }

        function fen(cat1,cat2) {
            window.location.href="/CaiDan/Search.do?cat1="+cat1+"&cat2="+cat2;
        }

        function findone(id) {
            window.location.href="/CaiDan/Desc.do?id="+id;
        }
    </script>
</head>
<body>
<%@ include file="../pub/header.jsp" %>
<div class="container productList">
    <div class="span6">
        <div class="hotProductCategory">
            <c:forEach items="${foodcat}" var="s">
            <dl>
                <dt>
                   <a href="javascript:void(0);" onclick="fen(${s.get("parent").getId()},'')">${s.get("parent").getName()}</a>
                </dt>
                <c:forEach items="${s.get('list')}" var="ss">
                    <dd>
                        <a href="javascript:void(0);" onclick="fen('',${ss.id})">${ss.name}</a>
                    </dd>
                </c:forEach>
            </dl>
            </c:forEach>
        </div>
    </div>
    <div class="span18 last">
            <div id="result" class="result table clearfix">
                <ul>
                    <c:forEach items="${food.row}" var="s">
                    <li>
                        <a href="javascript:void(0);" onclick="findone(${s.id})">
                            <img src="${s.img}" width="170" height="170"  style="display: inline-block;">
                            <span style='color:green'>
											 ${s.foodname}
											</span>
                            <span class="price">
												价格： ￥${s.price}
											</span>
                        </a>
                    </li>
                    </c:forEach>
                </ul>
            </div>
            <div class="pagination">
                <a class="firstPage" href="javascript:Page(1);">&nbsp;</a>
                <a class="previousPage" href="javascript:Page(${food.cunrt-1});">&nbsp;</a>
                <span class="currentPage">${food.cunrt}/${food.totalpaeg}</span>
                <a class="nextPage"href="javascript:Page(${food.cunrt+1});">&nbsp;</a>
                <a class="lastPage" href="javascript:Page(${food.totalpaeg});">&nbsp;</a>
            </div>
    </div>
</div>
<%@ include file="../pub/foot.jsp" %>
</body>
</html>
