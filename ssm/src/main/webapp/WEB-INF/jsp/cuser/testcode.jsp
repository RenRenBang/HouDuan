<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form action="getCheckCode" method="post">
		<input type="text" name="uphone" id="uphone"/>
		<input type="submit" name="提交" />
		
	</form>
	<form action="addCuser" method="post">
		<table>
			<tr>
				<td><input type="text" name="uphone"></td>
			</tr>
			<tr>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<td><input type="submit" value="tijiao"></td>
			</tr>
		</table>
	</form>
=============================================
	<form action="queryCorderListById">
		<table>
			<tr>
				<td><input type="text" name="uid"></td>
			</tr>
			<tr>
				<td><input type="submit" value="查询"></td>
			</tr>
		</table>
	</form>
</body>
</html>