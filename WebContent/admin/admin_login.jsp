<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html dir="ltr" lang="en-US">
<head>
	<link href="${pageContext.request.contextPath }/admin/favition.ico" rel="shortcut icon">
	<title>摄影工作室后台管理系统</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/admin/css/style.css" type="text/css" />

</head>
<body>
		<div id="container">
			
			<form action="${pageContext.request.contextPath }/AdminLoginServlet">
				<div class="login">摄影工作室后台管理系统
				<span style="color:red">${err }</span>
				</div>
				<div class="username-text">用户名:</div>
				<div class="password-text">密码:</div>
				<div class="username-field">
					<input type="text" name="username" />
				</div>
				<div class="password-field">
					<input type="password" name="password"/>
				</div>
				<input type="checkbox" name="remember-me" id="remember-me" /><label for="remember-me">记住用户名</label>
	
				<div class="forgot-usr-pwd"></div>
				<input type="submit" name="submit" value="GO" />
			</form>
		</div>

	</body>
</html>
