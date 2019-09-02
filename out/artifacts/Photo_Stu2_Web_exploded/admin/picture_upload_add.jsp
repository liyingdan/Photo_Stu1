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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加套餐</strong><small></small></div>
    </div>
    <hr>

    <div class="edit_content">
		<form action="${ctx }/pictureUploadServlet?action=PictureUpLoad"  id="add_form" method="post" enctype="multipart/form-data" style="background: none; width: 700px">
	        <div class="item1">
	            <div>
	                <span>用户名：</span>
	                <input type="text" class="am-form-field" name="name" >&nbsp;&nbsp;
	            </div>
	
	        </div>
			<br>
	        <div class="item1">
	                <span>图片压缩包：</span>
	                <input type="file"  name="fileUpload" />
	        </div>
	        <button class="am-btn am-btn-default" type="button" id="add">添加</button>
	        &nbsp;&nbsp;&nbsp;&nbsp;
	        <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
        </form>
    </div>


</div>

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>

<script>
    $("#add").click(function () {
        $("#add_form").submit(); 
    });
    
    $("#reset").click(function () {
       $(window).attr('location','picture_upload_add.jsp');
    });
</script>
</body>
</html>