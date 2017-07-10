<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
		</style>
	</head>
	<body>
		<div class="loginform">
			<form name="loginForm" method="POST" action="controller">
				<fieldset>
					<legend align="center">Login Form</legend>
					<input type="hidden" name="command" value="login"/>
					Login:<br/><input type="text" name="login" value=""/><br/>
					Password:<br/><input type="password" name="password" value=""/><br/>
					<br/>
					<input type="submit" value="Log In"/>
					<input type="button" value="Registration" onclick='location.href="registration"'/>
				</fieldset>
			</form>
		</div>
	</body>
</html>
