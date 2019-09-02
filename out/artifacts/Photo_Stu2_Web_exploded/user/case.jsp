<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/case.css">
</head>

<body>
<!-- 头部 -->
<%@include file="/user/header.jsp" %>
<!-- 中部 -->
<div class="cent">
    <div class="left">
    <ul>
    
    <c:if test="${empty allCombos }">没有商品</c:if>
    
    <c:forEach items="${allCombos }" var="combos">
    	<li>
	    	<div class="case">
	            <div class="tp">
	                <a href="detail.jsp"><img src="${ctx }/user/images/combos/${combos.image }" alt=""></a>
	            </div>
	            <div class="bt">
	                <p class="bty">套餐${combos.id }   【${combos.name }】</p>
	                <span>价格：</span><i class="yuan">￥</i> <span class="price">${combos.price }</span>
	                <p class="pri">摄影师：${combos.camerist }</p>
	               <%--  <p class="pri">套餐类型：${combos.type }</p> --%>
	                <p class="pri">套餐类型：<a href="#">${combos.type }</a></p>
	                <div class="order">
	                    <a href="${ctx }/user/detail.jsp"><span>查看详情</span></a>
	                </div>
	            </div>
	        </div>
    	
    	</li>
    </c:forEach>
    
    </ul>
        
 


    </div>
    <div class="right">
        <p class="bt">购买须知</p>
        <div>
            <p class="xbt">有效期</p>
            <ul>
                <li><p>购买后360天内有效</p></li>
            </ul>
        </div>
        <div>
            <p class="xbt">预约信息</p>
            <ul>
                <li><p>请提前一天预约</p></li>
            </ul>
        </div>
        <div>
            <p class="xbt">商家服务</p>
            <ul>
                <li><p>提供免费WiFi</p></li>
                <li><p>停车位信息详询商户</p></li>
                <li><p>免费提供卸妆油、专业老师指导茶水等</p></li>
            </ul>
        </div>
        <div>
            <p class="xbt">温馨提示</p>
            <ul>
                <li><p>如需发票，请您在消费时向商户咨询</p></li>
            </ul>
        </div>
 		
    </div>
</div>

</body>
</html>