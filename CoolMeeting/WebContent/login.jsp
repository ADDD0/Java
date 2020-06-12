<%@ page language="java" contentType="text/html; charset=UTF-8"%> <%@taglib
prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<title>CoolMeeting会议管理系统</title>
		<link rel="stylesheet" href="styles/common.css" />
		<style>
			.msg {
				color: red;
			}
		</style>
	</head>
	<body>
		<div class="msg">${msg}</div>
		<form action="LoginServlet" method="post">
			<fieldset>
				<legend>登录信息</legend>
				<table class="formtable" style="width: 50%">
					<tr>
						<td>员工号:</td>
						<td><input type="text" name="employeeId" /></td>
					</tr>
					<tr>
						<td>密码:</td>
						<td><input type="password" name="password" /></td>
					</tr>
					<tr>
						<td colspan="2" class="command">
							<input type="submit" value="登录" class="clickbutton" /><input
								type="button"
								value="返回"
								class="clickbutton"
								onclick="window.history.back();"
							/>
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</body>
</html>
