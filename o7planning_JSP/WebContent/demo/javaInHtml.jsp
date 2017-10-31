<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.Random,java.text.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Java In HTML</title>
</head>
<body>
	<%
      Random random = new Random();
 
      // Trả về ngẫu nhiên từ 0 - 9.
      int randomInt = random.nextInt(10);
  
 
      if (randomInt == 0) {
	  %>
	  
	  <h1>Random value =<%=randomInt%></h1>
	  
	  <%
	      } else if (randomInt == 1) {
	  %>
	  
	  <h2>Random value =<%=randomInt%></h2>
	 
	  <%
	      } else {
	  %>
	   <h3>Random value =<%=randomInt%></h3>
	  <%
	      }
	  %>
 	  
	  <jsp:scriptlet>
	  	out.println("request.getRequestURI() = " + request.getRequestURI());
	  </jsp:scriptlet>
	  <br/>
	  <jsp:scriptlet>
	  	out.println("request.getRequestURL() = " + request.getRequestURL());
	  </jsp:scriptlet>
	  
  	  <br><a href="<%= request.getRequestURI() %>">Try Again</a>
</body>
</html>