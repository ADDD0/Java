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
				<th>会议号</th>
				<th>会议名</th>
				<th>会议室号</th>
				<th>与会人数</th>
				<th>开始时间</th>
				<th>结束时间</th>
				<th>预定时间</th>
				<th>取消时间</th>
				<th>会议描述</th>
				<th>会议状态</th>
				<th>删除</th>
				<th>修改</th>
			</tr>
			<c:forEach items="${meetings}" var="m">
				<tr>
					<td>${m.meetingId}</td>
					<td>${m.meetingName}</td>
					<td>${m.roomId}</td>
					<td>${m.participantNumber}</td>
					<td>${m.startTime}</td>
					<td>${m.endTime}</td>
					<td>${m.reservationTime}</td>
					<td>${m.cancellationTime}</td>
					<td>${m.meetingDescription}</td>
					<td
						><c:if test="${m.meetingStatus==0}">
							未进行
						</c:if>
						<c:if test="${m.meetingStatus==1}">
							进行中
						</c:if></td
					>
					<td
						><c:if test="${user.role==1}">
							<a href="del.meeting?meetingId=${m.meetingId}">删除</a>
						</c:if></td
					>
					<td><a href="load.meeting?meetingId=${m.meetingId}">修改</a></td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>
