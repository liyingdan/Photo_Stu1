<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@ page import="java.text.*" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/clothes.css">
</head>
<body>
<!-- 头部 -->
<%@include file="/user/header.jsp" %>

<div class="cen">
    <div class="clo">
		 <ul>
		 <c:if test="${empty allClothes }">
		 	没有商品
		 </c:if>
		 <c:forEach items="${allClothes }" var="clothes">
		 	<li>
                <div class="yf">
                    <img src="${ctx }/user/images/clothes/${clothes.image }" alt="">
                    <!-- <input type="submit" value="加入购物车" class="purchase"> -->
                    <a href="${ctx }/PurchaseServlet?action=getAllPurchases&id=${clothes.id }">加入购物车</a>
                    <p>${clothes.name }</p>                  
                    <p><span class="pr">租金：</span><i class="yuan">￥</i><span class="price">${clothes.price }</span></p>               
                
                </div>
            </li>
		 </c:forEach>

        </ul>
    </div>

    <div class="zk">
        <h3>留言板</h3>
        	<c:forEach items="${allCom }" var="comment" varStatus="status">
		 		<div class="comment">
        			<div class="lef">
        				<span>${status.index + 1 }.</span>
        			</div>
        			<div class="rig">
        				<!-- <span>用户名：</span> -->
       					<p>${comment.ccom }</p>
       					<span class="date">${comment.cdate }</span>
        			</div>
        		</div>
		 	</c:forEach>
		 <form action="${ctx }/ComServlet?action=AddComment" method="post" id="com_add">
			 <div class="smon" id="smon" >
			 	<textarea rows="5" cols="30" name="ccom"></textarea>
			 	<input type="text" value="${user.username }" name="username" style="display:none">
			 	<%
			 		Date d = new Date();
			 		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			 		String now = df.format(d);
			 	%>
			 	<%-- <%=now %> --%>
			 	<input type="text" value="<%=now %>" name="cdate" style="display:none">
			 </div>
			 <button class="publish" id="publish">发表</button>
        </form>
        
        <button class="say" id="say">我也想说</button>
    
        
    </div>

</div> 

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script>
    $('#say').click(function () {
        $("#smon").fadeIn();
        $("#publish").fadeIn();
        $("#say").fadeOut();
    });
    
    $("#publish").click(function () {
        $("#com_add").submit();
    });

    
/*      $(".purchase").click(function () {
        $(window).attr('location','${pageContext.request.contextPath }/PurchaseServlet?id=1&name=${clothes.name }');
    });  */
</script>

</body>
</html>