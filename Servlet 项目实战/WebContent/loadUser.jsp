<%@page import="java.text.SimpleDateFormat"%> <%@page
contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"
import="java.util.*,entity.*,java.text.*"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>loadUser</title>
		<meta
			http-equiv="Content-Type"
			content="text/html; charset=UTF-8"
			charset="utf-8"
		/>
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content">
				<div id="header">
					<div id="rightheader">
						<p>
							<% SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
							out.println(sdf.format(new Date())); %>
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
					<h1>修改用户信息：</h1>
					<% User user = (User) request.getAttribute("user"); %>
					<form action="modify.do?id=<%=user.getId() %>" method="post">
						<table
							cellpadding="0"
							cellspacing="0"
							border="0"
							class="form_table"
						>
							<tr>
								<td valign="middle" align="right">账号</td>
								<td valign="middle" align="left">
									<input
										type="text"
										class="inputgri"
										name="username"
										value="<%=user.getUsername() %>"
									/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">密码</td>
								<td valign="middle" align="left">
									<input
										type="password"
										class="inputgri"
										name="pwd"
										value="<%=user.getPwd() %>"
									/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">邮箱</td>
								<td valign="middle" align="left">
									<input
										type="text"
										class="inputgri"
										name="email"
										value="<%=user.getEmail() %>"
									/>
								</td>
							</tr>
						</table>

						<p>
							<input type="submit" class="button" value="提交" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">ABC@126.com</div>
			</div>
		</div>
	</body>
</html>
