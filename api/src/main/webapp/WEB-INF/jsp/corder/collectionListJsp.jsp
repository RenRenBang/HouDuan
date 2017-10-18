<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
=========添加收藏===
<form action="addCollections" method="post">
	<table>
		<tr>
			<td>oid:<input type="text" name="oid"></td>
		</tr>
		<tr>
			<td>uid:<input type="text" name="uid"></td>
		</tr>
		<tr>
			<td><input type="submit" value="shoucahng"></td>
		</tr>
	</table>
</form>
=============删除收藏==================
<form action="deleteCollections" method="get">
	<table>
		<tr>
			<td>cid:<input type="text" name="cid"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="shanchu"></td>
		</tr>
	</table>
</form>
=================根据用户id查找收藏的订单==================
<form action="findCollectionByUid" method="post">
	<table>
		<tr>
			<td>uid:<input type="text" name="uid"></td>
		</tr>
		
		<tr>
			<td><input type="submit" value="chaxun "></td>
		</tr>
	</table>
</form>
</body>
</html>