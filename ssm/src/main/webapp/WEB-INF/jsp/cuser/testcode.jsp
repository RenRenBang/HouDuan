<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
===============发送验证码==========
	<form action="getCheckCode" method="post">
		手机号：<input type="text" name="uphone" id="uphone"/>
		<input type="submit" name="提交" />
		
	</form>
	=============添加用户，测试验证表单中的验证码======
	<form action="addCuser" method="post">
		<table>
			<tr>
				<td>手机号：<input type="text" name="uphone"></td>
			</tr>
			<tr>
				<td>用户收到的短信验证码：<input type="text" name="code"></td>
			</tr>
			<tr>
				<td>身份证号码<input type="text" name="idNumber"></td>
			</tr>
			<tr>
				<td>真实姓名<input type="text" name="name"></td>
			</tr>
			<tr>
				<td>昵称<input type="text" name="nickname"></td>
			</tr>
			<tr>
				<td>密码<input type="password" name="password"></td>
			</tr>
			<tr>
				<td>个人介绍<input type="text" name="profile"></td>
			</tr>
			<tr>
				<td><input type="submit" value="注册"></td>
			</tr>
		</table>
	</form>
====================查询用户发布的订单=========================
	<form action="queryCorderListById">
		<table>
			<tr>
				<td>uid:<input type="text" name="uid"></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>
</body>
</html>