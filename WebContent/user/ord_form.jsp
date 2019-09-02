<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/ord_form.css">
</head>
<body>
<!-- 头部 -->
<%@include file="/user/header.jsp" %>
<!-- 中部 -->
<div class="cent">
  <div class="dd">
    <p class="zt">预约订单:</p>
    <table >
		<tr>
			<td>预约时间</td>
			<td>2018-11-10</td>
		</tr>
	 	<tr>
	 		<td>是否预约成功</td>
			<td>成功</td>
	 	</tr>
	</table>
    
  </div>
  <div class="pic">
    <p class="zt">我的照片:</p>
    <a href="#">${picFileWname.filename}</a>
    <%-- <a href="${ctx}/pictureUploadServlet?action=PictureDownLoad&path=${picFileWname.file_add}">${picFileWname.filename}</a> --%>
  </div>
</div>









</body>
</html>