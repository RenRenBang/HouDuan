<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
欢迎×××用户，登录成功！！
<h3>登录后跳转的页面</h3>
	<form action="queryCorderBy" method="get">
	
		<table>
			<tr>
				<td><input type="text" name="type" ></td>
			</tr>
			<tr>
				<td><input type="text" name="trade" ></td>
			</tr>
			<tr>
				<td><input type="text" name="title" ></td>
			</tr>
			<tr>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>