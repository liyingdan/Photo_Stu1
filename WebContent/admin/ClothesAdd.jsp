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
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">添加商品</strong><small></small></div>
    </div>
    <hr>

    <div class="edit_content">
		<form action="${ctx }/AdClothesServlet?action=AddClothes"  id="add_form" method="post"  enctype="multipart/form-data" style="background: none; width: 700px">
	        <div class="item1">
	            <div>
	                <span>衣服名称：</span>
	                <input type="text" class="am-form-field" name="name">&nbsp;&nbsp;
	            </div>
	            <div>
	                <span>衣服价格：</span>
	                <input type="text" class="am-form-field" name="price">
	            </div>
	
	        </div>
	
	        <div class="item1 update_pic">
	                <span>商品图片：</span>
	                 <img src="" id="imageview" class="item_img" style="display: none;">
	                 <label for="fileupload" id="label_file">上传文件</label>
	                <input type="file" name="upload" id="fileupload"/>
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
        /* $(window).attr('location','${pageContext.request.contextPath }/AClothesAddServlet'); */
        $("#add_form").submit();
    });
    
    $("#reset").click(function () {
       $(window).attr('location','ClothesAdd.jsp');
    });
    
    $("#fileupload").change(function(){
    	var $file = $(this);
    	var objUrl = $file[0].files[0];
    	var windowURL = window.URL||window.webkitURL;
    	var dataURL;
    	dataURL = windowURL.createObjectURL(objUrl);
    	$("#imageview").attr("src",dataURL);
    	console.log($('#imageview').attr('style'));
    	if($('#imageview').attr('style')==='display: none;'){
    		$('#imageview').attr('style','inline');
    		$('#imageview').width('100px');
    		$('#imageview').height('50px');
    		$('.update_pic').attr('style','margin-bottom: 10px');
    	}
    	
    });
</script>
</body>
</html>