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
			<div class="content-nav">部门管理 > 修改部门</div>
			<form
				name="form"
				action="set.department?departmentId=${dept.departmentId}"
				method="post"
			>
				<fieldset>
					<legend>部门信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>部门号：</td>
							<td>${dept.departmentId}</td>
						</tr>
						<tr>
							<td>部门名：</td>
							<td>
								<input
									type="text"
									name="departmentName"
									maxlength="20"
									value="${dept.departmentName}"
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
