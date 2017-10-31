<%@page import="javafx.scene.shape.Circle"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Hello World!<br/>
	<%
	out.println("IP address của bạn là " + request.getRemoteAddr());
	%>
	<jsp:scriptlet>
		out.println("IP address của bạn là " + request.getRemoteAddr());
	</jsp:scriptlet>
	
	<jsp:scriptlet>
		out.println("Thẻ tag này giống như thẻ mở ngoặc nhọn và dấu %");
	</jsp:scriptlet>>
	
	<%! int i = 0; %> 
	<%! int a, b, c; %> 
	<%! Circle circle = new Circle(); %>
	
	<p>
	   Today's date: <%= (new java.util.Date()).toLocaleString()%>
	</p>
	
	<%-- This comment will not be visible in the page source --%> 
	
	<%! int day = 3; %>
	<% if (day == 1 | day == 7) { %>
      <p> Today is weekend</p>
	<% } else { %>
	      <p> Today is not weekend</p>
	<% } %>
	
	<% 
		switch(day) {
		case 0:
		   out.println("It\'s Sunday.");
		   break;
		case 1:
		   out.println("It\'s Monday.");
		   break;
		case 2:
		   out.println("It\'s Tuesday.");
		   break;
		case 3:
		   out.println("It\'s Wednesday.");
		   break;
		case 4:
		   out.println("It\'s Thursday.");
		   break;
		case 5:
		   out.println("It\'s Friday.");
		   break;
		default:
		   out.println("It's Saturday.");
		}
	%><br/>
	
	<%! int fontSize; %> 
	<%for ( fontSize = 1; fontSize <= 7; fontSize++){ %>
	   <font face="Consolas" color="green" size="<%= fontSize %>">
	    JSP Tutorial
	   </font><br />
	<%}%>
	
	<%
	fontSize=1;
	while ( fontSize <= 7){ %>
	   <font color="green" size="<%= fontSize %>">
	    JSP Tutorial
	   </font><br />
		<%fontSize++;%>
	<%}%>
</body>
</html>