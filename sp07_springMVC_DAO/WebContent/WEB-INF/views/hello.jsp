<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> hello </title>
</head>
<body>
<h1>Hello Page</h1>
인사합니다. : 
<h3> ${ greeting } </h3>

<input type="button" value="목록보기" onclick="javascript:window.location.href='list.do'">
<input type="button" value="지점저장" onclick="javascript:window.location.href='writeform.do'">

</body>
</html>