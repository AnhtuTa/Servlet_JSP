<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>My demo</title>
</head>
<body>
	<h3>This is mydemo.jsp</h3>
	Something's send from HelloWorldServlet: <%=request.getAttribute("hello") %><br/><br/>
	<form action="HelloBaby">
		Name <input type="text" name="txtName">
		Address <input type="text" name="txtAddr">
		<input type="submit" value="Let's go!">
	</form>
</body>
</html>