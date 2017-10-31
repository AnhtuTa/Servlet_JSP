<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="../error/my-error-page.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Chia 2 so</title>
</head>
<body>
	<form name="frm" method="get">
		So a: <input type="text" name="num1"><br>
		So b: <input type="text" name="num2"><br>
		<input name="btChia" value="Chia" type="submit">
	</form>
	<%
		String str1 = request.getParameter("num1");
		String str2 = request.getParameter("num2");
		
		if(str1 != null && str2 != null) {
			Double a = Double.valueOf(str1);
			Double b = Double.valueOf(str2);
			Double kq = a/b;
			out.println("ket qua phep chia = " + kq);
		}
	%>
</body>
</html>