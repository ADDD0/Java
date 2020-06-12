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
				<th>会议室号</th>
				<th>会议房间号</th>
				<th>会议室名</th>
				<th>会议室容量</th>
				<th>会议室状态</th>
				<th>会议室描述</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
			<c:forEach items="${rooms}" var="r">
				<tr>
					<td>${r.roomId}</td>
					<td>${r.roomNumber}</td>
					<td>${r.roomName}</td>
					<td>${r.capacity}</td>
					<td
						><c:if test="${r.roomStatus==0}">
							空闲
						</c:if>
						<c:if test="${r.roomStatus==1}">
							使用中
						</c:if></td
					>
					<td>${r.roomDescription}</td>
					<td
						><c:if test="${user.role==1}">
							<a href="del.room?roomId=${r.roomId}">删除</a>
						</c:if></td
					>
					<td><a href="load.room?roomId=${r.roomId}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
