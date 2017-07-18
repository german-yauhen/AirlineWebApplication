<%--Created by Yauheni Hermanovich 14.07.2017--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
	<head>
		<title>Login Page</title>
		<style type="text/css">
			body {
				margin: 0px;
				padding: 0px;
				display: inline-block;
				background: url("/images/bg_main.jpg") no-repeat center center fixed;
				background-size: cover;
			}
			.loginform {
				position: absolute;
				top: 30%;
				left: 20%;
			}
			.itputelem {
				opacity: 0.7;
			}
			#error {
				color: firebrick;
			}
		</style>
	</head>
	<body>
		<div class="loginform">
			<form name="loginForm" method="POST" action="controller">
				<fieldset>
					<legend align="center">Login Form</legend>
					<input type="hidden" name="command" value="login"/>
					Login:<br/><input class="itputelem" type="text" name="login" value=""/><br/>
					Password:<br/><input class="itputelem" type="password" name="password" value=""/><br/><br/>
					<input type="submit" value="Log In"/>
					<input type="button" value="Registration" onclick='location.href="controller?command=gotoregistration"'/>
				</fieldset>
				<h4 id="error">${errorLoginOrPassword}</h4>
			</form>
		</div>
	</body>
</html>
