<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/order.css">
</head>
<body>
<!-- 头部 -->
<%@include file="/user/header.jsp" %>
<!-- 中部 -->
<div class="cent">
    <div class="left">
        <h3>请填写预约信息</h3>
        <form action="#">
            <div>
                <label>套餐名称</label>
                <input type="text" >
            </div>
            <div>
                <label>预约时间</label>
                <input type="text">
            </div>

        </form>



    </div>
    <div class="right">

    </div>
</div>









</body>
</html>