<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	 <h2>fmt:formatDate example</h2>
     <c:set var="now" value="<%=new java.util.Date()%>" />
     <p>
        Time (fmt:formatDate type="time"):
        <strong>
           <fmt:formatDate type="time" value="${now}" />
        </strong>
     </p>
     <p>
        Date (fmt:formatDate type="date"):
        <strong>
           <fmt:formatDate type="date" value="${now}" />
        </strong>
     </p>
     <p>
        Date, Time (fmt:formatDate type="both"):
        <strong>
           <fmt:formatDate type="both" value="${now}" />
        </strong>
     </p>
     <p>
        Date, Time Short (fmt:formatDate type="both" dateStyle="short"):
        <strong>
           <fmt:formatDate type="both" dateStyle="short" timeStyle="short" value="${now}" />
        </strong>
     </p>
     <p>
        Date, Time Medium (fmt:formatDate type="both" dateStyle="medium" timeStyle="medium"):
        <strong>
           <fmt:formatDate type="both" dateStyle="medium" timeStyle="medium" value="${now}" />
        </strong>
     </p>
     <p>
        Date, Time Long (fmt:formatDate type="both" dateStyle="long" timeStyle="long"):
        <strong>
           <fmt:formatDate type="both" dateStyle="long" timeStyle="long" value="${now}" />
        </strong>
     </p>
     <p>
        Date, Time (dd-MM-yyyy HH:mm:ss):
        <strong>
           <fmt:formatDate pattern="dd-MM-yyyy HH:mm:ss" value="${now}" />
        </strong>
     </p>
     
     <!-- Store in variable -->
     <fmt:formatDate pattern="dd-MM-yyyy HH:mm" value="${now}" var="nowString"/>
     
      <p>
        Now String (dd-MM-yyyy HH:mm):
        <strong>
           <c:out value="${nowString}" />
        </strong>
      </p>
</body>
</html>