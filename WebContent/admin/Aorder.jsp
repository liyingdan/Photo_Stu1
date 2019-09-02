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
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/Aorder.css" type="text/css" />

</head>
<body style="background:#f3f3f3;">
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">订单管理</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
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
	<p>租赁服装管理</p>
	<table >
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td class="com">服装名字</td>
			<td>租赁金额</td>
			<td>删除</td>
		</tr>
	 	<c:forEach items="${allClothesOrder }" var="allClothesOrder" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>${allClothesOrder.username}</td>
				<td>${allClothesOrder.clothesname}</td>
				<td class="com">${allClothesOrder.price}</td>
				<td><a href="#"><img class="img_icon" src="${ctx }/admin/images/delete_icon.png" style="width: 20px;height:20px;"></a></td>
			</tr>
		</c:forEach>
	</table>

</div>
<div class="goods_list">
	<p>预约管理</p>
	<table >
		<tr>
			<td>序号</td>
			<td>预约人</td>
			<td class="com">电话号码</td>
			<td>预约时间</td>
			<td>是否接受预约</td>
		</tr>
	 	<c:forEach items="${allcomboOrder }" var="allcomboOrder" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>${allcomboOrder.cname}</td>
				<td>${allcomboOrder.cphone}</td>
				<td >${allcomboOrder.ctime}</td>
				<td>
				<input type="radio" name="isaccept" value="accept" checked="checked">接受
				<input type="radio" name="isaccept" value="refuse">拒绝
				</td>
			</tr>
		</c:forEach>
	</table>

</div>

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script>
    $("#add").click(function () {
        $(window).attr('location','${pageContext.request.contextPath }/admin/edit.jsp');
    });

</script>

</body>
</html>