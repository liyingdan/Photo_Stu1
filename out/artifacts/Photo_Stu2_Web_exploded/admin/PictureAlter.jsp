<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css" type="text/css" />
    <link rel="stylesheet" href="css/amazeui.min.css" />
</head>
<body>

<div class="main_top">
    <div class="am-cf am-padding am-padding-bottom-0">
        <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">修改客照信息</strong><small></small></div>
    </div>
    <hr>

    <div class="edit_content">

        <div class="item1">
            <div>
                <span>期刊名称：</span>
                <input type="text" class="am-form-field" >&nbsp;&nbsp;
            </div>
        </div>
        
        <div class="item1">
                <span>客照图片1：</span>
                <input type="file"  id="upload"/>
                
                 <span>客照图片6：</span>
                <input type="file"  id="upload"/>
        </div>
        <div class="item1">
                <span>客照图片2：</span>
                <input type="file"  id="upload"/>
                 <span>客照图片7：</span>
                <input type="file"  id="upload"/>
        </div>
        <div class="item1">
                <span>客照图片3：</span>
                <input type="file"  id="upload"/>
                <span>客照图片8：</span>
                <input type="file"  id="upload"/>
        </div>
        <div class="item1">
                <span>客照图片4：</span>
                <input type="file"  id="upload"/>
                 <span>客照图片9：</span>
                <input type="file"  id="upload"/>
        </div>
         <div class="item1">
                <span>客照图片5：</span>
                <input type="file"  id="upload"/>
                 <span>客照图片10：</span>
                <input type="file"  id="upload"/>
        </div>

        <button class="am-btn am-btn-default" type="button" id="add">修改</button>
        &nbsp;&nbsp;&nbsp;&nbsp;
        <button class="am-btn am-btn-default" type="button" id="reset">重置</button>
    </div>


</div>

<script src="js/jquery.min.js"></script>

<script>
    $("#add").click(function () {
        $(window).attr('location','PictureAlter.jsp');
    });
    
    $("#reset").click(function () {
       $(window).attr('location','edit.jsp');
    });
</script>
</body>
</html>