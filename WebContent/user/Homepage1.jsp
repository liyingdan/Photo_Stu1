<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
     <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/Homepage1.css">
    <!-- <base target="-black"> -->
</head>
<body>
<!-- 头部 -->
<%@include file="/user/header.jsp" %>
<!-- 中部 -->
<a href=""></a>
<div class="CenSec">   
    <div class="content">
        <div class="con">
            <ul id="oul">
            	<c:forEach items="${allProducts }" var="products">
            		<li>
	                    <img src="${ctx }/user/images/${products.pimage}" alt="">
	                    <div class="wz">
	                        <p>${products.pdesc1}</p>
	                        <p>${products.pdesc2}</p>
	                    </div>
	                    <div class="zt">
	                        <span>${products.ptype}</span>
	                    </div>
                	</li>
            	
            	</c:forEach>
            
            </ul>
            
        </div>
   
   
   
    </div>
</div>


</body>
</html>