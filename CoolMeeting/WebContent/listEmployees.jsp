<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>CoolMeeting会议管理系统</title>
		<link rel="stylesheet" href="styles/common.css" />
	</head>
	<body>
		<form action="query.employee" method="post">
			姓名:<input type="text" name="queryName" />
			<input type="submit" value="查询" /><br />
		</form>
		<table class="listtable" border="1">
			<tr class="listheader">
				<th>账号</th>
				<th>姓名</th>
				<th>别名</th>
				<th>电话</th>
				<th>邮箱</th>
				<th>部门</th>
				<th>权限</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
			<c:forEach items="${emps}" var="e">
				<tr>
					<td>${e.employeeId}</td>
					<td>${e.employeeName}</td>
					<td>${e.username}</td>
					<td>${e.phone}</td>
					<td>${e.email}</td>
					<td>${e.departmentId}</td>
					<td
						><c:if test="${e.role==1}">
							管理员
						</c:if>
						<c:if test="${e.role==2}">
							普通用户
						</c:if></td
					>
					<td
						><c:if test="${user.role==1}">
							<a href="del.employee?employeeId=${e.employeeId}">删除</a>
						</c:if></td
					>
					<td><a href="load.employee?employeeId=${e.employeeId}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
