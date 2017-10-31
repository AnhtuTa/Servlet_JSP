<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Using JavaBean with JSP</h1>
	<jsp:useBean id="string_bean" class="core_servlet.StringBean"></jsp:useBean>
	<ol>
		<li>Initial value from jsp:getProperty: <i><jsp:getProperty property="message" name="string_bean"/></i>
		<li>Initial value from jsp:Expression: <i><%=string_bean.getMessage() %></i>
		<jsp:setProperty property="message" name="string_bean" value="Hello world"/>
		<li>Value after setting property with jsp:setProperty: <i><jsp:getProperty property="message" name="string_bean"/> </i>
		<% string_bean.setMessage("Hello world again"); %>
		<li>Value after setting property with scriptlet: <i><%=string_bean.getMessage() %></i>
	</ol>
</body>
</html>