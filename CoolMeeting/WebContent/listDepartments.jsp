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
		<table class="listtable" border="1">
			<tr class="listheader">
				<th>部门号</th>
				<th>部门名</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
			<c:forEach items="${depts}" var="d">
				<tr>
					<td>${d.departmentId}</td>
					<td>${d.departmentName}</td>
					<td
						><c:if test="${user.role==1}">
							<a href="del.department?departmentId=${d.departmentId}">删除</a>
						</c:if></td
					>
					<td
						><a href="load.department?departmentId=${d.departmentId}"
							>修改</a
						></td
					>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
