<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="search-image" method="post">
		Enter a person's ID <input type="text" name="personID">
		<div>Example: 1, 2, 3...</div>
		<input type="submit" value="Search image!">
	</form>
	
	<img alt="the person's image above will be display here..." src="${imagePath}">
</body>
</html>