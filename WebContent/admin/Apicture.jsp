<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>摄影工作室后台管理系统</title>
    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" /> --%>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/pageStyle.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/Apicture.css">

</head>
<body style="background:#f3f3f3;">
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">客照管理</strong><small></small></div>
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
			<td>期刊</td>
			<td>客照1</td>
			<td>客照2</td>
			<td>客照3</td>
			<td>客照4</td>
			<td>客照5</td>
			<td>客照6</td>
			<td>客照7</td>
			<td>客照8</td>
			<td>客照9</td>
			<td>客照10</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${allPictures }" var="pictures" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>${pictures.pdate}</td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic1}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic2}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic3}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic4}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic5}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic6}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic7}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic8}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic9}" alt=""></td>
				<td><img src="${ctx }/user/images/picture/${pictures.ppic10}" alt=""></td>
				<td><a href="#"><img class="img_icon" src="${ctx }/admin/images/edit_icon.png" alt=""></a></td>
				<td><a href="#"><img class="img_icon" src="${ctx }/admin/images/delete_icon.png" alt=""></a></td>
			</tr>
		</c:forEach>
	</table>

</div>

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/paging.js"></script>
<script>
    //分页
    $("#page").paging({
        pageNo:5,
        totalPage: 10,
        totalSize: 300,
        callback: function(num) {
            alert(num);
        }
    });

    $("#add").click(function () {
        $(window).attr('location','${ctx }/admin/PictureAdd.jsp');
    });

</script>

</body>
</html>