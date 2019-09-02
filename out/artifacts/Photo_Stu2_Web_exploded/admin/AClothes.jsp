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

</head>
<body style="background:#f3f3f3;">
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">衣服管理</strong><small></small></div>
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
    <ul class="title_ul">
        <li>序号</li>
        <li>衣服图片</li>
        <li>衣服名称</li>
        <li>衣服租金</li>
        <li>编辑</li>
        <li>删除</li>
    </ul>

	<c:forEach items="${pageBean.clothesList }" var="clothes" varStatus="status">
		<ul class="list_goods_ul">
	        <li>${status.index + 1 }</li>
	        <li><img src="${ctx }/user/images/clothes/${clothes.image}" alt=""></li>
	        <li>${clothes.name}</li>
	        <li>${clothes.price}</li>
	        <li><a href="${ctx }/AdClothesServlet?action=AlterUI&id=${clothes.id}"><img class="img_icon" src="${ctx }/admin/images/edit_icon.png" alt=""></a></li>
	        <li><a href="${ctx }/AdClothesServlet?action=DelClothes&id=${clothes.id}"><img class="img_icon" src="${ctx }/admin/images/delete_icon.png" alt=""></a></li>
    	</ul>
	</c:forEach>
    <!--分页-->
    <div id="page" class="page_div">aaa</div>
</div>

<script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/admin/js/paging.js"></script>
<script>
    //分页
    $("#page").paging({ 
        pageNo: ${pageBean.currentPage},
        totalPage: ${pageBean.totalPage},  
        totalSize: ${pageBean.totalCount},
        callback: function(num) {
        	$(window).attr('location','${pageContext.request.contextPath }/AdClothesServlet?action=getPageDate&currentPage='+num);
        }
    });

    $("#add").click(function () {
        $(window).attr('location','${pageContext.request.contextPath }/admin/ClothesAdd.jsp');
    });

</script>

</body>
</html>