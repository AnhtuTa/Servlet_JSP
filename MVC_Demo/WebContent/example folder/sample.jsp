<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>jsp demo</title>
</head>
<body>
	<%
		//Nhung code java vao day:
		out.print("Hello world 2 </br>");
		out.print("This is another example");
		int i=8;
		
		List<String> list = new ArrayList<String>(); //remember to import package at the front of this file
		list.add("anhtu");
		list.add("bkhn");
		list.add("java");
		list.add("j2ee");
		out.print("</br> list = "+list+"</br>");
	%>
	Value of i: <%=i %>
	
	<!-- Get local init param --><br/>
	<h4>This site's init param is: <%=config.getInitParameter("param_from_jsp") %></h4>
	
	<!-- Get context init param (local param) -->
	<h4>The song param in web.xml: <%=application.getInitParameter("song") %></h4> 
</body>
</html>