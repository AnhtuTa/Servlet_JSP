<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
<!-- link href="mywebsite.css" rel="stylesheet" Gi?i thích như bên select_role.jsp -->
<style type="text/css">
	.login_table {
		margin-bottom: 10px;
	}
	.login_table tr td {
		padding: 4px;
		font-size: 17px;
	}
	.login_input {
		 width: 150px;
		 padding: 5px;
	}
	.btnOK {
		background-color: #1a5fce;
	    color: #fff;
	    font-weight: bold;
	    width: 60px;
	    border-radius: 4px;
		height: 30px;
		text-align: center;
		padding: 10px, 10px, 15px, 10px;
		margin-bottom: 10px
	}
	a {
		text-decoration: none;
		color: blue;
	}
	a:hover {
		color: #00ee11;
	}
	.wrapper {
		width: 98%;
		padding: 10px;
	}
	h2 {
		color: #00ee11;
	}
	.login_inner_wrapper {
		border: 2px solid blue;
		border-radius: 10px;
		width: 400px;
	}
	#inputtxt {
		-webkit-transition: -webkit-transform 0.5s, opacity 0.5s, background 0.5s, width 0.5s, height 1s;
	}
	#inputtxt:FOCUS {
		border: 2px solid blue;
		background-color: #e0e0e0;
	}
</style>
</head>
<body>
	<div align=center class="wrapper">
		<h2>Login with ${roleOfUser}</h2>
		<div align=center class="login_inner_wrapper">
			<p style="color: red;">${error_login}</p>
			<form action="login" method="POST">
				<table class="login_table">
					<tr>
						<td style="padding-right: 5px;">Username</td>
						<td><input id="inputtxt" type="text" name="txtUser" class="login_input"></td>
					</tr>
					<tr>
						<td style="padding-right: 5px;">Password</td>
						<td><input id="inputtxt" type="password" name="txtPass" class="login_input"></td>
					</tr>
				</table> 
				<input type="submit" value="OK" class="btnOK">
				<a href="${pageContext.request.contextPath}/home">Cancel</a>
			</form>
			
			<p><br/><a href="select-role">Login with another role</a></p>
			
		</div>
	</div>
</body>
</html>