<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:element name="data">
		<h3>Please view source this page!</h3>
		
		<jsp:useBean id="emp" class="jsp_action_element_attribute_body.Employee">
			<jsp:setProperty property="empNo" name="emp" value="4509"/>
			<jsp:setProperty property="empName" name="emp" value="Monkey D. Luffy"/>
		</jsp:useBean>
	</jsp:element>
	
	<jsp:element name="employee">
		<jsp:attribute name="empNo" trim="true">
			<jsp:getProperty property="empNo" name="emp" />
		</jsp:attribute>
		
		<jsp:body>
			<jsp:getProperty property="empName" name="emp" />
		</jsp:body>
	</jsp:element>
</body>
</html>