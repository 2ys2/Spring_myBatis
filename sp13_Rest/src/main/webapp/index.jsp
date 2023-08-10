<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> </title>
</head>
<body>

<!-- 1. -->
<a href="getText"> 1.문자열 반환</a><hr />

<!-- 2. -->
<a href="getObject"> 2.Object Return</a><hr />

<!-- 3. -->
<a href="getList"> 3.List Object Return</a><hr />

<!-- 4. -->
<a href="sample/it/100"> 4.쿼리스트링 처리</a><hr />

<!-- 5. -->
	<form action="sample/data" method="post">
		<input type="text" name="name" placeholder="name">
		<input type="text" name="age" placeholder="age">
		<input type="text" name="message" placeholder="message">
		<input type="submit" value="POST 전송">
	</form>
</body>
</html>