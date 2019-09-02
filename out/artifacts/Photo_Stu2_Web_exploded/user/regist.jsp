<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <link href="${pageContext.request.contextPath }/user/favition.ico" rel="shortcut icon">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/common.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/user/css/regist.css">
</head>
<body>
<!-- 头部 -->
<div class="reg_header">
    <div class="reg_h_center">
        <div class="reg_h_left">
             <!--<img src="images/2.jpg" alt="">-->
            <h4>摄影工作室</h4>
        </div>
        <div class="reg_h_right">
            <a href="${pageContext.request.contextPath }/user/login.jsp" target="-black">请登陆</a>
            <span>已有账户</span>

        </div>
    </div>
</div>
<p class="hyzc">欢迎注册</p>
<!-- 中部 -->
<div class="reg_content">
    <div class="reg_content_left">
        <form action="${pageContext.request.contextPath }/RegistServlet" method="POST" id="form">
            <div>
                <label>用户名</label>
                <input type="text" placeholder="请输入用户名" id="username" name="username">
            </div>
            <div>
                <label>密码</label>
                <input type="password" placeholder="请输入密码" id="password1" name="password">
            </div>
            <div>
                <label>确认密码</label>
                <input type="password" placeholder="请确认密码" id="password2">
            </div>
            <div>
                <label>电话</label>
                <input type="text" placeholder="请输入电话号码" id="phone" name="phone">
            </div>
           <!--  <div class="iden">
                <input type="radio" name="iden" value="user">普通用户&nbsp;&nbsp;
                <input type="radio" name="iden" value="admin">管理员    
            </div> -->
            <div class="check_box">
                <label>验证码</label>
                <input type="text" placeholder="请输入验证码" id="code" name="code">
                <!-- <img src="/Photo_Stu/CreateCode"  onclick="change(this)"> -->
                <img src="${pageContext.request.contextPath }/CheckCodeServlet"  onclick="change(this)">
            </div>
            
            <div class="submit_button">
                <input type="button" value="立即注册"  onclick="checkData()">
            </div>
        </form>
    </div>

    <div class="reg_content_right">
        <a href="#">
            <img src="${pageContext.request.contextPath }/user/images/555.jpg" alt="">
        </a>
    </div>
</div>

 <script type="text/javascript">
     function change(obj){
         obj.src = "${pageContext.request.contextPath }/CheckCodeServlet?time="+new Date().getTime();
     }
     
     function checkData(){
    	 //alert("jjjj");
    	 //1.获取用户名、密码、电话号码
    	 var name = document.getElementById("username");
    	 var psd1 = document.getElementById("password1");
    	 var psd2 = document.getElementById("password2");
    	 var phone = document.getElementById("phone");
    	 var code = document.getElementById("code");
    	 //2.判断是否为空，否则重新输入
    	 if(name.value==""){
    		 alert("用户名不能为空");
    		 return;
    	 } 
    	 if(psd1.value==""){
    		 alert("密码不能为空");
    		 return;
    	 } 
    	 if(psd2.value==""){
    		 alert("请确认密码");
    		 return;
    	 } 
    	 if(phone.value==""){
    		 alert("电话号码不能为空");
    		 return;
    	 } 
    	 if(code.value==""){
    		 alert("验证码不能为空");
    		 return;
    	 } 
    	 //3.验证两次密码是否一样
    	 if(psd1.value == psd2.value){
    		 var form = document.getElementById("form");
    		 form.submit();
    	 }
    	 else{
    		 alert("两次输入的密码不一样！")
    	 }
   																					 	
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
    	 
     }
     
 </script>
 
</body>

</html>