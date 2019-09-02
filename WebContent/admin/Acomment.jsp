<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>摄影工作室后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/Acomment.css" type="text/css" />
    <%-- <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/pageStyle.css"> --%>

</head>
<body style="background:#f3f3f3;">
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf">
        <div class="am"><strong class="am-text-primary am-text-lg">评论管理</strong><small></small></div>
    </div>
    <hr>



</div>
<div class="goods_list">
	<table >
		<tr>
			<td>序号</td>
			<td>用户名</td>
			<td class="com">评论</td>
			<td>时间</td>
			<!-- <td>编辑</td> -->
			<td>删除</td>
		</tr>
		<c:forEach items="${allCom }" var="comment" varStatus="status">
			<tr>
				<td>${status.index + 1 }</td>
				<td>${comment.username}</td>
				<td>${comment.ccom}</td>
				<td class="com">${comment.cdate}</td>
				<%-- <td><a href="#"><img class="img_icon" src="${ctx }/admin/images/edit_icon.png" alt=""></a></td> --%>
				<td><a href="${ctx }/AComServlet?action=DelComment&id=${comment.cid}"><img class="img_icon" src="${ctx }/admin/images/delete_icon.png" alt=""></a></td>
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
        $(window).attr('location','${pageContext.request.contextPath }/admin/edit.jsp');
    });

</script>

</body>
</html>