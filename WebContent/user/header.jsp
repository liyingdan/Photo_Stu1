<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String ctx = request.getContextPath();
	pageContext.setAttribute("ctx", ctx);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="${ctx }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${ctx }/user/css/common.css">
    <link rel="stylesheet" href="${ctx }/user/css/header.css">
    <!-- <base target="-black"> -->
</head>
<body>
<!-- 头部 -->
<div class="header">
    <div class="nr">
        <div class="nav">
            <div class="left">
                <p>摄影工作室</p>
             </div>
            <!--二级菜单-->
            <div class="menu">
                <a href="#">购物车</a>
                <div class="cen">
                	<p class="clo">全部租赁服装</p><br>
                	
                <c:if test="${empty Pclothes }">
	     			<p>购物车是空的哦！</p>
	            </c:if>
	  
		 		<c:forEach items="${Pclothes }" var="Pclothes" >
		            	<div class="good">
	                    	<input type="checkbox" checked="checked">
	                    	<div class="clothes">
	                    		<div class="left">
	                    			<img alt="" src="${ctx }/user/images/clothes/${Pclothes.image }">
	                    		</div>
	                    		<div class="right">
	                    			<span class="name">${Pclothes.name}</span>
	                    			<span class="pri">￥${Pclothes.price}</span>
	                    			<span><a href="#">删除</a></span>
	                    			<span><a href="${ctx }/PurchaseServlet?action=AddOrder&id=${Pclothes.id }">租赁</a></span>
	                    		</div>               
	                    	</div>                    
	                    </div>
			 	</c:forEach>  
			 	
                </div>
                <div class="sjx"></div>
            </div>
            
            <div class="right">
	            <!-- 检测有没有session -->
	            <c:if test="${empty user }">
	                <a href="${ctx }/user/regist.jsp" target="-black">注册</a>
	                <a href="${ctx }/user/login.jsp" target="-black" >登陆&nbsp;&nbsp;|</a>
	            </c:if>
	            
	            <c:if test="${!empty user }">
	            	<%-- <a href="${ctx }/user/Homepage1.jsp">退出</a> --%>
	            	<a href="${ctx }/ProductServlet?action=getAllProducts2">退出</a>
	                <p> 欢迎:${user.username }</p>
	            </c:if>
                
            </div>
        </div>
    </div>
    <!-- 轮播 -->
    <div class="pic" id="slider">
        <!-- <img src="images/lb2.jpg" alt=""> -->
        <div id="top">
            <ul id="ul">
                <li><img src="${ctx }/user/images/lb1.jpg" alt=""></li>
                <li><img src="${ctx }/user/images/lb6.jpg" alt=""></li>
                <li><img src="${ctx }/user/images/lb7.jpg" alt=""></li>
                <li><img src="${ctx }/user/images/lb8.jpg" alt=""></li>
                <li><img src="${ctx }/user/images/lb9.jpg" alt=""></li>
            </ul>
        </div>
        <ol id="ol">

        </ol>
    </div>

    <div class="tb">
        <div class="nav">
            <ul>
                <li><a href="${ctx }/ProductServlet?action=getAllProducts">本店产品</a></li>
                <li><a href="${ctx }/ComboServlet">当季特惠</a></li>
                <li><a href="${ctx }/ClothesServlet">服装租赁</a></li>
                <li><a href="${ctx }/PicturesServlet?action=getAllDate">客照显示</a></li>
                <li><a href="${ctx }/pictureUploadServlet?action=getPicFileWname&cname=${user.username }">我的订单</a></li>
            </ul>  
        </div>
    </div>

</div>


<script src="${ctx }/user/myFunc.js"></script>
<script>
    (
       function () {
           var sliceIndex = 0;
           var cIndex =0;
           var lis = $("ul").children;

           $("ul").appendChild(lis[0].cloneNode(true));
           //动态创建ol li
           for (var i = 0; i < lis.length - 1; i++) {
               var oli = document.createElement("li");
               $("ol").appendChild(oli)
           }
           var olis = $("ol").children;
           olis[0].className = "current";
           for (var i = 0; i < olis.length; i++) {
               (
                   function (i) {
                       olis[i].onmouseover = function () {
                           for (var j = 0; j < olis.length; j++) {
                               olis[j].className = ""
                           }
                           this.className = "current";
                           constant($("ul"),-(i * 1536),100)
                           sliceIndex=cIndex = i;
                       }
                   })(i)
           }


           //自动轮播
           var timer = setInterval(autoPlay,3000);
           $("slider").onmouseover = function(){
               clearInterval(timer)
           };
           $("slider").onmouseout = function(){
               timer = setInterval(autoPlay,3000)
           };
           function autoPlay(){
               sliceIndex ++;
               if (sliceIndex >lis.length-1){
                   $("ul").style.left = 0;
                   sliceIndex = 1;
               }
               constant($("ul"),-(1528*sliceIndex),100);
               cIndex ++;
               if (cIndex > olis .length -1){
                   cIndex = 0
               }
               for(var i = 0;i<olis.length;i++){
                   olis[i].className = ""
               }
               olis[cIndex].className = "current"
           }
           function $(id) {
               return document.getElementById(id)
           }
       }
   )()

</script>
    
</body>
</html>