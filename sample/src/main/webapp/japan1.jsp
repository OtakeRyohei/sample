<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ポストデータ</title>
</head>
<body>
	<form method="POST" action="JapanServlet">
		あなたの名前は？
		<input type="text" name="name" size="10"/>
		<input type="submit" value="送信"/>
	</form>
</body>
</html>