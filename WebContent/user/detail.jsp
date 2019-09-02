<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/detail.css">
</head>

<body>
<!-- 头部 -->
<%@include file="/user/header.jsp" %>


<!-- 面包屑导航 -->
<div class="bread_crumb">
    <div class="bread_center">
        <a href="${ctx }/user/Homepage1.jsp">首页  <small>&gt</small></a>
     
        <a href="${ctx }/ComboServlet">当季特惠   <small>&gt</small></a>
      
        <a href="#">海景拍</a>
    </div>
</div>
<!-- 详情展示 -->
<div class="detail">
    <div class="detail_img">
        <img src="${ctx }/user/images/combos/fm.jpg" alt="">
    </div>
    <div class="detail_price">
        <h3>我们结婚吧</h3>
        <div class="goods_price">
            <p class="ori_price">原价：￥5999.00 <em></em></p>
            <p>价格：<i class="yuan">￥</i> <span class="price">5888.00</span></p>
        </div>
        <div class="goods_count">
            购买数量<input type="text" value="1">
        </div>
        <div class="goods_buy">
            <input type="submit" value="预约购买" id="buy">
        </div>
    </div>
</div>

<div class="purchase" id="purchase">
	<div class="left">
		<p>以下商家将收到您的预约信息</p>
		<div class="sjxx">
			<div class="le">
				<img src="${ctx }/user/images/quinyus.png" alt="" >
			</div>
			<div class="ri">
				<p>单椒煜泽摄影工作室</p>
				<p class="addr">地址：济南市明湖北路大明翠庭湖畔苑</p>
			</div>
			
		</div>
		<p>预约购买：</p>
		<div class="gi">
			<p class="ft">￥5888.00</p>
			<p>我们结婚吧</p>
		</div>
		<p>独家优惠，预约即可领取：</p>
		<div class="gi">
			<p class="ft">到店礼</p>
			<p>预约咨询顾客即可赠送爱慕摆台一组</p>
		</div>
		
	</div>
	
	<div class="right">
		<form action="${ctx }/PurchaseServlet?action=addComboOrder" method="post" id="combobuy">
			<h3>请填写预约信息</h3>
			<div class="order">
				<span>预约人姓名：</span>
				<input type="text" name="cname">
			</div>
			<div class="order">
				<span>预约&nbsp;&nbsp;&nbsp;&nbsp;电话：</span>
				<input type="text" name="cphone">
			</div>
			<div class="order">
				<span>预约&nbsp;&nbsp;&nbsp;&nbsp;时间：</span>
				<input type="date" name="ctime">
			</div>
			<input type="submit" value="立即购买" class="buy" id="buyy">
		</form>
		
		<p class="infor">您的重要信息不会泄露，详见隐私条款</p>
	</div>
	
	<div id="close"><img src="${ctx }/admin/images/delete_icon.png" alt=""></div>

</div>

<!-- 商品介绍 -->
<div class="introduce">
    <h3>商品展示</h3>
    <div class="introduce_body">
        <img src="${ctx }/user/images/combos/jh1.jpg" alt="">
        <img src="${ctx }/user/images/combos/jh2.jpg" alt="">
        <img src="${ctx }/user/images/combos/jh3.jpg" alt="">
        <img src="${ctx }/user/images/combos/jh4.jpg" alt="">
        <img src="${ctx }/user/images/combos/jh5.jpg" alt="">
        <img src="${ctx }/user/images/combos/jh6.jpg" alt="">
        <img src="${ctx }/user/images/combos/jh7.jpg" alt="">
    </div>
</div>
<script>
	var buy=document.getElementById("buy");
	var purchase=document.getElementById("purchase");
	var close=document.getElementById("close");
	buy.onclick=function(){
		purchase.style.display="block";
	}
	close.onclick=function(){
		purchase.style.display="none";
	}
	
	 $("#buyy").click(function () {
	        $("#combobuy").submit(); 
	    });
</script>


</body>
</html>
