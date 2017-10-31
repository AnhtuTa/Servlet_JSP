<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Select role</title>
	<!-- link href="mywebsite.css" rel="stylesheet" type="text/css" Do chạy trên localhost nên lúc ban đầu đăng nhập ko load đc cái file css này, đành phải dùng style ở dưới	-->
	<style type="text/css">
		body {
			text-align: center;
		}
		.selectRole-button {
			background-color: #0095e5;
		    color: #fff;
		    font-weight: bold;
		    width: 30%;
		    border-radius: 10px;
			height: 50px;
			text-align: center;
			margin-bottom: 10px;
			-webkit-transition: -webkit-transform 0.5s, opacity 0.5s, background 0.5s, width 0.5s, height 0.5s;
			-webkit-border-radius: 10px;
			cursor: pointer;
		}
		.selectRole-button:hover {
			width: 35%;
			height: 60px;
			background-color: #00475b;
			opacity: 0.8;
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
	</style>
</head>
<body>
	<div class="wrapper">
		<h2>Select role to login</h2>
		
		<form action="select-role" method="post">
			<input class="selectRole-button" type="submit" value="Login with student" name="roleOfUser">
		</form>
		
		<form action="select-role" method="post">
			<input class="selectRole-button" type="submit" value="Login with teacher" name="roleOfUser">
		</form>
		
		<form action="select-role" method="post">
			<input class="selectRole-button" type="submit" value="Login with academic staff" name="roleOfUser">
		</form>
		
		<br><br>
		<p>Try this account:</p>
		<div><b>Student:</b> ID: 20134509, pass: 1</div>
		<div><b>Teacher:</b> ID: nampn, pass: 1</div>
	</div>
</body>
</html>