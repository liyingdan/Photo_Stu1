<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>摄影工作室后台管理系统</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/amazeui.min.css" />
    <link rel="stylesheet" href="${pageContext.request.contextPath }/admin/js/pageStyle.css">
    <script src="${pageContext.request.contextPath }/admin/js/jquery.min.js"></script>
</head>
<body>
<%@include file="/admin/style.jsp" %>
<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">管理员列表</strong><small></small></div>
    </div>
    <hr>
    <div class="am-g">
        <div class="am-u-sm-12 am-u-md-6">
            <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                    <button id="add" class="am-btn am-btn-default">
                        <span class="am-icon-plus"></span> 添加管理员
                    </button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="goods_list" id="account_List">
    <ul class="title_ul">
        <li>序号</li>
        <li>用户</li>
        <li>修改密码</li>
        <li>移除管理员</li>
    </ul>
    
	<c:forEach items="${allAdmin }" var="admin" varStatus="status">
		<ul class="list_goods_ul">
	        <li>${status.index + 1 }</li>
	        <li>${admin.username}</li>
	        <li><a href="#"><img class="img_icon alter" src="${ctx }/admin/images/edit_icon.png" alt="" ></a></li>
	        <li><a href="${ctx }/AdminServlet?action=DelAdmin&id=${admin.id}"><img class="img_icon" src="${ctx }/admin/images/delete_icon.png" alt=""></a></li>
	    </ul>
	</c:forEach>    

</div>

    <div id="modal_view">


    </div>

<!-- 添加管理员 -->
<div id="modal_content_account">
    <div id="close"><img src="${ctx }/admin/images/delete_icon.png" alt=""></div>
    <div class="edit_content">
		<form action="${ctx }/AdminServlet?action=addAdmin"  id="add_form" method="post" style="background: none; width: 700px">
	        <div class="item1">
	            <div>
	                <span>添加管理员：</span>
	            </div>
	        </div>
	        <div class="item1">
	            <div>
	                <span>用户名：</span>
	                <input type="text" class="am-form-field" name="username" >&nbsp;&nbsp;
	            </div>
	
	        </div>
	        <div class="item1">
	            <div>
	                <span>密码：</span>
	                <input type="text" class="am-form-field" name="password" >&nbsp;&nbsp;
	            </div>
	
	        </div>
	        <div class="item1">
	            <button class="am-btn am-btn-default" type="button" id="addadmin">添加</button>
	        </div>
		</form>
    </div>
</div>

<!-- 修改管理员 -->
<div id="alter_account">
    <div id="Aclose"><img src="${ctx }/admin/images/delete_icon.png" alt=""></div>
    <div class="edit_content">
		<form action="${ctx }/AdminServlet?action=addAdmin"  id="alter_form" method="post" style="background: none; width: 700px">
	        <div class="item1">
	            <div>
	                <span>修改管理员密码：</span>
	            </div>
	        </div>
	        <div class="item1">
	            <div>
	                <span>密码：</span>
	                <input type="text" class="am-form-field" name="password" >&nbsp;&nbsp;
	            </div>
	
	        </div>
	        <div class="item1">
	            <button class="am-btn am-btn-default" type="button" id="AlterAdmin">确定修改</button>
	        </div>
		</form>
    </div>
</div> 


<script>
    $(function () {
        $('#add').click(function () {
            $("#modal_view").fadeIn();
            $("#modal_content_account").fadeIn();
        });
       

        $("#close").click(function () {
            $("#modal_view").fadeOut();
            $("#modal_content_account").fadeOut();
        });
    });
    
     $(function () {
        $('.alter').click(function () {
            $("#modal_view").fadeIn();
            $("#alter_account").fadeIn();
        });
       

        $("#Aclose").click(function () {
            $("#modal_view").fadeOut();
            $("#alter_account").fadeOut();
        });
    }); 
    
    
    $("#addadmin").click(function () {
        $("#add_form").submit();
    });
</script>
</body>
</html>