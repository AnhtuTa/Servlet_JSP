<%@page import="fpt.Student"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/xml; charset=utf-8"
    pageEncoding="utf-8"%>
<StudentList2>
	<%
		ArrayList<Student> stList = Student.getStdListDemo();
		for(Student st : stList) {
	%>
			<Student ID="<%=st.getId()%>" name="<%=st.getName() %>" />
	<%
		}
	%>
</StudentList2>

<%-- ko thể gộp 2 code của file này và file MineType_xml vì nó sẽ báo lỗi --%>
<%-- Chú ý: comment trong xml trong này --%>