<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%!
		String theirName = "Songoku and Vegeta";
	%>
	<!-- include another file -->
	<%@ include file="header.jsp" %><br/><br/>	<!-- Biên dịch lúc run, nghĩa là mỗi lần chạy nó sẽ đc biên dịch lại -->
	<!-- Hoặc dùng cách khác -->
	<jsp:include page="header.jsp">
		<jsp:param value="<%=theirName %>" name="gokuName"/>		<!-- Truyền tham số cho thằng header.jsp dùng -->
	</jsp:include><br/><br/>	<!-- Biên dịch lúc runtime, nghĩa là chỉ biên dịch 1 lần, do đó mỗi lần chạy thằng này KHÔNG đc biên dịch lại -->
	<!-- Do đó jsp:include load lâu hơn @include vì nó phải biên dịch (?) -->
	
	Student name: <%=request.getParameter("stName") %><br/>
	Region: <%=request.getParameter("region") %><br/>
	
	Student name by EL: ${param.stName}<br/>
	Region by EL: ${param.region}<br/>
	
	Student name by EL and []: ${param["stName"]}<br/>
	Region by EL and []: ${param["region"]}<br/>
	
	<jsp:useBean id="stDragon" class="objects.Student" />
	<jsp:setProperty property="name" name="stDragon" param="region"/>
	Get property name (useBean) from param: <jsp:getProperty property="name" name="stDragon"/>
</body>
</html>