<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>摄影工作室后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
</head>
<body>
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改服装信息</strong><small></small></div>
    </div>
    <hr>

    <div class="edit_content">
		<form action="${ctx }/AdClothesServlet?action=AlterClothes" id="alter_form" method="post" style="background: none; width: 700px">
	        <div class="item1">
	        	<input type="text" name="id" value="${clothes.id }" style="display: none" >
	            <div>
	                <span>衣服名称：</span>
	                <input type="text" class="am-form-field" name="name" value="${clothes.name }" >&nbsp;&nbsp;
	            </div>
	            <div>
	                <span>衣服价格：</span>
	                <input type="text" name="price" value="${clothes.price }" class="am-form-field" >
	            </div>
	
	        </div>
	
	        <div class="item1">
	                <span>商品图片：</span>
	                <input type="file" name="image" value="${clothes.image }" />
	        </div>
	        <button class="am-btn am-btn-default" type="button" id="alter">提交</button>
	        	&nbsp;&nbsp;&nbsp;&nbsp;
	        <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
        </form>
    </div>


</div>

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>

<script>
    $("#alter").click(function () {
       $("#alter_form").submit();
    });
    
    $("#reset").click(function () {
       $(window).attr('location','${pageContext.request.contextPath }/admin/ClothesAlter.jsp');
    });
</script>
</body>
</html>