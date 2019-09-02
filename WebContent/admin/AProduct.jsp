<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>摄影工作室后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />
   <%--  <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/category.css" type="text/css" /> --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/js/pageStyle.css">
    <script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
</head>
<body>
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">分类管理</strong><small></small></div>
    </div>
    <hr>
</div>

<div class="goods_list" id="account_List">
    <ul class="title_ul">
        <li>序号</li>
        <li>分类名称</li>
        <li>分类图片</li>
        <li>产品描述1</li>
        <li>产品描述2</li>
        <li>修改分类</li>
        <!-- <li>删除分类</li> -->
    </ul>
    
    <c:forEach items="${allProducts }" var="product">
    	<ul class="list_goods_ul">
	        <li>${product.pid }</li>
	        <li>${product.ptype }</li>
	        <li><img src="${ctx }/user/images/${product.pimage }" alt=""></li>
	        <li>${product.pdesc1 }</li>
	        <li>${product.pdesc2 }</li>
	        <li><a href="${ctx }/AProductServlet?action=AlterUI&id=${product.pid}"><img class="img_icon" src="${ctx }/admin/images/edit_icon.png" alt=""></a></li>
	       <%--  <li><a href="#"><img class="img_icon" src="${ctx }/admin/images/delete_icon.png" alt=""></a></li> --%>
    	</ul>
    	
    </c:forEach>
    

    
</div>

<div id="modal_view">


</div>

<div id="modal_content">
    <div id="close"><img src="${ctx }/admin/images/delete_icon.png" alt=""></div>
    <div class="edit_content">

        <div class="item1">
            <div>
                <span>添加分类：</span>
            </div>
        </div>
        <div class="item1">
            <div>
                <span>商品名称：</span>
                <input type="text" class="am-form-field" >&nbsp;&nbsp;
            </div>
        </div>
        <div class="item1">
            <button class="am-btn am-btn-default" type="button" >添加</button>
        </div>
        
    </div>
</div>

<script>
    $(function () {
        $('#add').click(function () {
            $("#modal_view").fadeIn();
            $("#modal_content").fadeIn();
        });

        $("#close").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content").fadeOut();
        });
    });
</script>
</body>
</html>