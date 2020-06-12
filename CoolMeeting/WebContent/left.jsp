<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
		<title>CoolMeeting会议管理系统</title>
		<link rel="stylesheet" href="styles/common02.css" />
	</head>
	<body>
		<div class="page-sidebar">
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">部门管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem">
						<a href="list.department" target="main">查看部门</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="addDepartment.jsp" target="main">添加部门</a>
					</li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">员工管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem">
						<a href="list.employee" target="main">查看员工</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="addEmployee.jsp" target="main">添加员工</a>
					</li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议室管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem">
						<a href="list.room" target="main">查看会议室</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="addRoom.jsp" target="main">添加会议室</a>
					</li>
				</ul>
			</div>
			<div class="sidebar-menugroup">
				<div class="sidebar-grouptitle">会议管理</div>
				<ul class="sidebar-menu">
					<li class="sidebar-menuitem">
						<a href="list.meeting" target="main">查看会议</a>
					</li>
					<li class="sidebar-menuitem">
						<a href="addMeeting.jsp" target="main">预定会议</a>
					</li>
				</ul>
			</div>
		</div>
	</body>
</html>
