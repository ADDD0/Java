<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8" />
		<title>CoolMeeting会议管理系统</title>
		<link rel="stylesheet" href="styles/common.css" />
	</head>
	<body>
		<div class="page-content">
			<div class="content-nav">会议室管理 > 添加会议室</div>
			<form name="form" action="add.room" method="post">
				<fieldset>
					<legend>会议室信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>会议室号：</td>
							<td><input type="text" name="roomId" maxlength="20" /></td>
						</tr>
						<tr>
							<td>会议房间号：</td>
							<td><input type="text" name="roomNumber" maxlength="20" /></td>
						</tr>
						<tr>
							<td>会议室名：</td>
							<td><input type="text" name="roomName" maxlength="20" /></td>
						</tr>

						<tr>
							<td>会议室容量：</td>
							<td><input type="text" name="capacity" maxlength="20" /></td>
						</tr>
						<tr>
							<td>会议室描述：</td>
							<td>
								<input type="text" name="roomDescription" maxlength="20" />
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
