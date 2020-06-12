<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page import="utils.TimeUtils, bean.Meeting"%> <%
Meeting meeting = (Meeting) request.getAttribute("meeting"); String startTime =
TimeUtils.toWebTimestamp(meeting.getStartTime().toString()); String endTime =
TimeUtils.toWebTimestamp(meeting.getEndTime().toString()); String
reservationTime =
TimeUtils.toWebTimestamp(meeting.getReservationTime().toString()); String
cancellationTime; if (meeting.getCancellationTime() == null) { cancellationTime
= TimeUtils.toWebTimestamp(null); } else { cancellationTime =
TimeUtils.toWebTimestamp(meeting.getCancellationTime().toString()); }
request.setAttribute("startTime", startTime); request.setAttribute("endTime",
endTime); request.setAttribute("reservationTime", reservationTime);
request.setAttribute("cancellationTime", cancellationTime); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>CoolMeeting会议管理系统</title>
		<link rel="stylesheet" href="styles/common.css" />
	</head>
	<body>
		<div class="page-content">
			<div class="content-nav">会议管理 > 修改会议</div>
			<form
				name="form"
				action="set.meeting?meetingId=${meeting.meetingId}"
				method="post"
			>
				<fieldset>
					<legend>会议信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>会议号：</td>
							<td>${meeting.meetingId}</td>
						</tr>
						<tr>
							<td>会议名：</td>
							<td>
								<input
									type="text"
									name="meetingName"
									maxlength="20"
									value="${meeting.meetingName}"
								/>
							</td>
						</tr>
						<tr>
							<td>会议室号：</td>
							<td>
								<input
									type="text"
									name="roomId"
									maxlength="20"
									value="${meeting.roomId}"
								/>
							</td>
						</tr>
						<tr>
							<td>与会人数：</td>
							<td>
								<input
									type="text"
									name="participantNumber"
									maxlength="20"
									value="${meeting.participantNumber}"
								/>
							</td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td>
								<input
									type="datetime-local"
									name="startTime"
									step="1"
									value="${startTime}"
								/>
							</td>
						</tr>
						<tr>
							<td>结束时间：</td>
							<td>
								<input
									type="datetime-local"
									name="endTime"
									step="1"
									value="${endTime}"
								/>
							</td>
						</tr>
						<tr>
							<td>预定时间：</td>
							<td>
								<input
									type="datetime-local"
									name="reservationTime"
									step="1"
									value="${reservationTime}"
									readonly
								/>
							</td>
						</tr>
						<tr>
							<td>取消时间：</td>
							<td>
								<input
									type="datetime-local"
									name="cancellationTime"
									step="1"
									value="${cancellationTime}"
									readonly
								/>
							</td>
						</tr>
						<tr>
							<td>会议描述：</td>
							<td>
								<input
									type="text"
									name="meetingDescription"
									maxlength="20"
									value="${meeting.meetingDescription}"
								/>
							</td>
						</tr>
						<tr>
							<td>会议状态：</td>
							<td>
								<input
									type="text"
									name="meetingStatus"
									maxlength="20"
									value="${meeting.meetingStatus}"
								/>
							</td>
						</tr>
						<tr>
							<td colspan="6" class="command">
								<input type="submit" class="clickbutton" value="修改" /><input
									type="reset"
									class="clickbutton"
									value="重置"
								/>
							</td>
						</tr>
					</table>
				</fieldset>
			</form>
		</div>
		<div class="page-footer">
			<hr />
			更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a
			><img src="images/footer.png" alt="CoolMeeting" />
		</div>
	</body>
</html>
