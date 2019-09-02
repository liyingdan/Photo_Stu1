<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <title>首页</title>
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/picture.css">
</head>
<body>
<!-- 头部 -->
<%@include file="/user/header.jsp" %>
<!-- 中部 -->
<div class="cent">
	<div class="left">
		<ul>
			<c:if test="${empty picture }">
				<li class="tp1" id="tp1">
					<div class="pic">
						<img src="${ctx }/user/images/picture/p1.jpg" alt="">
					</div>
					<div class="pic">
						<img src="${ctx }/user/images/picture/p2.jpg" alt="">
					</div>
					<div class="pic">
						<img src="${ctx }/user/images/picture/p3.jpg" alt="">
					</div>
					<div class="pic">
						<img src="${ctx }/user/images/picture/p4.jpg" alt="">
					</div>
					<div class="pic">
						<img src="${ctx }/user/images/picture/p5.jpg" alt="">
					</div>
					<div class="pic">
						<img src="${ctx }/user/images/picture/p8.jpg" alt="">
					</div>
					<div class="pic">
						<img src="${ctx }/user/images/picture/p9.jpg" alt="">
					</div>
					<div class="pic">
						<img src="${ctx }/user/images/picture/p10.jpg" alt="">
					</div>
				</li>
			</c:if>
			
			
		
		<c:if test="${!empty picture }">
			<li class="tp2" id="tp2">
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic1}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic2}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic3}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic4}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic5}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic6}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic7}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic8}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic9}" alt="">
				</div>
				<div class="pic">
					<img src="${ctx }/user/images/picture/${picture.ppic10}" alt="">
				</div>
			</li>
		</c:if>
		</ul>
	</div>
	<div class="right">
		<ul>
			<c:forEach items="${allPictures }" var="pictures">
				<li class="date">
					<a href="${ctx }/PicturesServlet?action=getpicture&id=${pictures.pid }" >${pictures.pdate }</a>
				</li>
			</c:forEach>
		</ul>
	</div>

</div>
<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script>
 /*    $(".date").click(function (e) {
    	this.addClass("activity");
    	console.log(777);
    }); */

</script>
</body>
</html>