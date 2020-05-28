<%@page import="java.text.SimpleDateFormat"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="java.util.*,entity.*,java.text.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>listUsers</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"
	charset="utf-8">
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body>
	<div id="wrap">
		<div id="top_content">
			<div id="header">
				<div id="rightheader">
					<p>
						<%
							SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							out.println(sdf.format(new Date()));
						%>
						<br />
					</p>
				</div>
				<div id="topheader">
					<h1 id="title">
						<a href="#">main</a>
					</h1>
				</div>
				<div id="navigation"></div>
			</div>
			<div id="content">
				<p id="whereami"></p>
				<h1>欢迎!</h1>
				<table class="table">
					<tr class="table_header">
						<td>ID</td>
						<td>账号</td>
						<td>密码</td>
						<td>邮箱</td>
						<td>操作</td>
					</tr>
					<%
						List<User> users = (List) request.getAttribute("users");
						for (int i = 0; i < users.size(); i++) {
							User u = users.get(i);
					%>
					<tr class="row1">
						<td><%=u.getId()%></td>
						<td><%=u.getUsername()%></td>
						<td><%=u.getPwd()%></td>
						<td><%=u.getEmail()%></td>
						<td><a href="del.do?id=<%=u.getId()%>" onclick="return confirm('是否确认删除')">删除</a>&nbsp; <a
							href="load.do?id=<%=u.getId()%>" >修改</a>&nbsp;</td>
					</tr>
					<%
						}
					%>
				</table>
				<p>
					<input type="button" class="button" value="添加员工"
						onclick="location='addUser.jsp'" />
				</p>
			</div>
		</div>
		<div id="footer">
			<div id="footer_bg">ABC@126.com</div>
		</div>
	</div>
</body>
</html>
