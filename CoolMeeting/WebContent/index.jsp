<%@ page language="java" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<title>CoolMeeting会议管理系统</title>
</head>
<frameset rows="150,*" cols="*" framespacing="0" frameborder="no"
	border="0">
	<frame src="top.jsp" name="topFrame" scrolling="No" noresize="noresize"
		id="topFrame" marginwidth="0" marginheight="0" frameborder="0" />
	<frameset cols="260,*" id="frame">
		<frame src="left.jsp" name="leftFrame" noresize="noresize"
			marginwidth="110px" marginheight="0" frameborder="0" scrolling="auto"
			target="main" />
		<frame src="listEmployees.jsp" name="main" marginwidth="50px"
			marginheight="40px" frameborder="0" scrolling="auto" target="_self" />
	</frameset>
</frameset>
</html>
