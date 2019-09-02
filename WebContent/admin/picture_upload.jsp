<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>摄影工作室后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/pageStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/Acomment.css" type="text/css" />

</head>
<body style="background:#f3f3f3;">
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">客照压缩包上传</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 新增</button>
                </div>
            </div>
        </div>
        <div class="am-u-sm-12 am-u-md-3">

        </div>
        <div class="am-u-sm-12 am-u-md-3">
            <div class="am-input-group am-input-group-sm">
                <input type="text" class="am-form-field" id="input_search">
                <span class="am-input-group-btn">
                    <button class="am-btn am-btn-default" type="button" id="input_search_btn">搜索</button>
                </span>
            </div>
        </div>
    </div>



</div>

<div class="goods_list">
	<table >
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td class="com">上传文件</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${allPicFile }" var="allPicFile" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>${allPicFile.username}</td>
				<td><a href="${ctx}/pictureUploadServlet?action=PictureDownLoad&path=${allPicFile.file_add}">${allPicFile.filename}</a></td>
				<td class="delete"><a href="${ctx}/pictureUploadServlet?action=deletePicFile&id=${allPicFile.fid}"><img class="img_icon" src="${ctx }/admin/images/delete_icon.png" style="width:20px;height:20px"></a></td>
			</tr>
		</c:forEach>
	</table>

</div>

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script>
    $("#add").click(function () {
        $(window).attr('location','${pageContext.request.contextPath }/admin/picture_upload_add.jsp');
    });

</script>

</body>
</html>