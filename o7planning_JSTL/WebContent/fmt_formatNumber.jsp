<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fmt:formatNumber example</title>
</head>
<body>
	<h2>fmt:formatNumber example</h2>
     <c:set var="accountBalance" value="12345.6789" />
     <h3>accountBalance=<c:out value="${accountBalance}"/></h3>
     
     The Account Balance can be displayed using various ways:
     
     <p>
        formatNumber (type='currency'):
        <strong>
           <fmt:formatNumber value="${accountBalance}" type="currency"/>
        </strong>
     </p>
     <p>
        formatNumber (type='number', maxIntegerDigits= '3'):
        <strong>
           <fmt:formatNumber type="number" maxIntegerDigits="3" value="${accountBalance}" />
        </strong>
     </p>
     <p>
        formatNumber (type='number', maxFractionDigits= '3'):
        <strong>
           <fmt:formatNumber type="number" maxFractionDigits="3" value="${accountBalance}" />
        </strong>
     </p>
     <p>
        formatNumber (type='number', groupingUsed= 'false'):
        <strong>
           <fmt:formatNumber type="number" groupingUsed="false" value="${accountBalance}" />
        </strong>
     </p>
     <p>
        formatNumber (type='percent', maxIntegerDigits= '3'):
        <strong>
           <fmt:formatNumber type="percent" maxIntegerDigits="3" value="${accountBalance}" />
        </strong>
     </p>
     <p>
        formatNumber (type='percent', maxIntegerDigits= '10'):
        <strong>
           <fmt:formatNumber type="percent" minFractionDigits="10" value="${accountBalance}" />
        </strong>
     </p>
     <p>
        formatNumber (type='number', pattern= '###.###E0'):
        <strong>
           <fmt:formatNumber type="number" pattern="###.###E0" value="${accountBalance}" />
        </strong>
     </p>
     <p>        
        Account Balance in USA (fmt:setLocale value='en_US'):
        <br/>
        formatNumber (type='currency'):          
        <fmt:setLocale value="en_US"/>
        <strong>
           <fmt:formatNumber value="${accountBalance}" type="currency"/>
        </strong>
     <p>
        Account Balance in Canada (fmt:setLocale value='fr_CA'):
        <br/>
        formatNumber (type='currency'):
        <fmt:setLocale value="fr_CA"/>
        <strong>
           <fmt:formatNumber value="${accountBalance}" type="currency"/>
        </strong>
</body>
</html>