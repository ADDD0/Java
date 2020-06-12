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
		<div class="page-content">
			<div class="content-nav">会议管理 > 添加会议</div>
			<form name="form" action="add.meeting" method="post">
				<fieldset>
					<legend>会议信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>会议号：</td>
							<td><input type="text" name="meetingId" maxlength="20" /></td>
						</tr>
						<tr>
							<td>会议名：</td>
							<td><input type="text" name="meetingName" maxlength="20" /></td>
						</tr>
						<tr>
							<td>会议室号：</td>
							<td>
								<select name="roomId">
									<c:forEach items="${roomlist}" var="r">
										<option value="${r.roomId}">${r.roomName}</option>
									</c:forEach>
								</select>
							</td>
						</tr>
						<tr>
							<td>与会人数：</td>
							<td>
								<input type="text" name="participantNumber" maxlength="20" />
							</td>
						</tr>
						<tr>
							<td>开始时间：</td>
							<td><input type="datetime-local" name="startTime" step="1" /></td>
						</tr>
						<tr>
							<td>结束时间：</td>
							<td><input type="datetime-local" name="endTime" step="1" /></td>
						</tr>
						<tr>
							<td>会议描述：</td>
							<td>
								<input type="text" name="meetingDescription" maxlength="20" />
							</td>
						</tr>
						<tr>
							<td colspan="6" class="command">
								<input type="submit" class="clickbutton" value="添加" /><input
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
