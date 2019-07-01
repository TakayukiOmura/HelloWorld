<%@ page language="java" contentType="text/html; charset=UTF8"
	pageEncoding="UTF8"%>
<%
	// Servletからデータを受け取る
	request.setCharacterEncoding("UTF8");
	String servlet = (String) request.getAttribute("Servlet");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF8">
<title>遷移先のjsp</title>
</head>
<body>
	<!--Servletから取ってきたデータを表示-->
	<%=servlet%>
</body>
</html>