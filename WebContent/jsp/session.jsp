<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
String name1 = (String)session.getAttribute("name1");
Integer name2 = (Integer)session.getAttribute("name2");

%>
</head>
<body>
<h1>session</h1>
name1 = <%=name1 %>
<br>
<form action="http://localhost:8080/Test/SessinGetServlet" >
	</form>
name2 = <%=name2 %>
</body>
</html>