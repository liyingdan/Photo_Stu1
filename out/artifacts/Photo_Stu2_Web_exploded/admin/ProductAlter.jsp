<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
</head>
<body>
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改产品分类</strong><small></small></div>
    </div>
    <hr>

    <div class="edit_content">
		<form action="${ctx }/AProductServlet?action=AlterProducts" method="post" id="alter_form" style="background: none; width: 700px">
	        <div class="item1">
	       		<input type="text" name="pid" value="${product.pid }" style="display:none;">
	            <div>
	                <span>分类名称：</span>
	                <input type="text" name="ptype" value="${product.ptype }" class="am-form-field" >&nbsp;&nbsp;
	            </div>
	        </div>
			<br>
	        <div class="item1">
	                <span>分类图片：</span>
	                <input type="file" name="pimage" value="${product.pimage }"/>
	        </div>
	        <br>
	        <div class="item1 item_desc">
	            <span>分类描述1：</span>
	            <textarea name="pdesc1" rows="2" cols="30">${product.pdesc1 }</textarea>
	        </div>
	        <br>
	        <div class="item1 item_desc">
	            <span>分类描述2：</span>
	            <textarea name="pdesc2" rows="2" cols="30">${product.pdesc2 }</textarea>
	        </div>
	        <br>
	        
	        <button class="am-btn am-btn-default" type="button" id="alter" >提交</button>
	        &nbsp;&nbsp;&nbsp;&nbsp;
	        <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
        </form>
    </div>


</div>

<script src="${ctx }/admin/js/jquery.min.js"></script>

<script>
	$("#alter").click(function () {
	/* 	alert("xxx"); */
   		$("#alter_form").submit();
 	});
    
    $("#reset").click(function () {
       $(window).attr('location','${pageContext.request.contextPath }/admin/ProductAlter.jsp');
    });
</script>
</body>
</html>