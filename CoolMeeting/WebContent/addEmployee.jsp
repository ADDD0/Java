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
			<div class="content-nav">员工管理 > 添加员工</div>
			<form name="form" action="add.employee" method="post">
				<fieldset>
					<legend>员工信息</legend>
					<table class="formtable" style="width: 50%">
						<tr>
							<td>员工号：</td>
							<td><input type="text" name="employeeId" maxlength="20" /></td>
						</tr>
						<tr>
							<td>员工名：</td>
							<td><input type="text" name="employeeName" maxlength="20" /></td>
						</tr>
						<tr>
							<td>用户名：</td>
							<td><input type="text" name="username" maxlength="20" /></td>
						</tr>
						<tr>
							<td>密码：</td>
							<td>
								<input
									type="password"
									name="password"
									maxlength="20"
									placeholder="请输入6位以上的密码"
								/>
							</td>
						</tr>
						<tr>
							<td>联系电话：</td>
							<td><input type="text" name="phone" maxlength="20" /></td>
						</tr>
						<tr>
							<td>电子邮件：</td>
							<td><input type="text" name="email" maxlength="20" /></td>
						</tr>
						<tr>
							<td>所在部门：</td>
							<td>
								<select name="departmentId">
									<c:forEach items="${deptlist}" var="d">
										<option value="${d.departmentId}"
											>${d.departmentName}</option
										>
									</c:forEach>
								</select>
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
