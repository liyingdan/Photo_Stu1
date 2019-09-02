<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
     <meta charset="UTF-8">
    <title>登陆界面</title>
    <!-- 设置标签图标 -->
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/login.css">
</head>
<body>
 <!-- 头部 -->
 <div class="header">
    <div class="nr">
        <div class="nav">
            <div class="left">
                <p>摄影工作室</p>
             </div>            
            <div class="right">
                <a href="${pageContext.request.contextPath }/user/regist.jsp" target="-black">请注册</a>
                <a href="${pageContext.request.contextPath }/user/login.jsp">未有账户&nbsp;&nbsp;|</a>
            </div>
        </div>
    </div>

</div>
<!-- 中部 -->
<div class="login_body">
    <div class="login_b_center" >
        <div class="login_bg">
            <h4>欢迎登陆</h4>
            <span style="color:red">${err }</span>
            <form action="${pageContext.request.contextPath }/LoginServlet" id="login" action="post">
                <div class="userName">
                    <span></span> <input type="text" placeholder="请输入账户名" name="username">
                </div>
                <div class="password">
                        <span></span> <input type="password" placeholder="请输入密码"  name="password">
                </div>
                <div class="check_box">
                    <span>验证码:</span>
                    <input type="text" placeholder="请输入验证码" name="code">
                    <img src="${pageContext.request.contextPath }/CreateCode"  onclick="change(this)">
                </div>

                <div class="login_btn">
                         <input type="submit" value="请登录">
                </div>
                <div class="forgot_pwd">
                    <a href="">忘记密码</a>
                    <a href="">忘记账户名</a>
                </div>
               
            </form>

        </div>
    </div>
</div>

 <script>
     function change(obj){
         obj.src = "${pageContext.request.contextPath }/CreateCode?time="+new Date().getTime();
     }
 </script>

<!-- <script type="text/javascript" src="js练习.js"></script> -->
</body>
</html>
