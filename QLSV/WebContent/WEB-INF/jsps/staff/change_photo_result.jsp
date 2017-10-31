<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Change photo result</title>
	<link href="mywebsite.css" rel="stylesheet" type="text/css">
	<link href="timetable.css" rel="stylesheet" type="text/css">
	<style type="text/css">
		tr td input {
			padding: 3px;
		}
	</style>
</head>
<body>
	<div class="wrapper" >
		<%@ include file="_menu_staff.jsp" %>
		
		<div align="center" class="inner_wrapper">
			<h3 style="color: blue;">${infoString}</h3>
			<h3 style="color: blue;">${errorString}</h3>
		</div>
		
		<%@ include file="../_footer.jsp" %>
	</div>
</body>
</html>