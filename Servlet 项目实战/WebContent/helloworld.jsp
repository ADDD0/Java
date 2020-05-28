<%@page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="java.util.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
		<title>Insert title here</title>
	</head>
	<body style="font-size: 30px;">
		系统时间:<% out.println(new Date()); %>
		<br />现在时间:<%=new Date()%><br />
		<h1>输出10次hello world</h1>
		<% for (int i = 0; i < 10; ++i) { %> hello world
		<br />
		<% } %>
	</body>
</html>
