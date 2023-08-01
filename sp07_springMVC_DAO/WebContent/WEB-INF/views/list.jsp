<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> list </title>
</head>
<body>
<h1> List Page </h1>

<c:forEach items="${ list }" var="list" >
${ list.deptno }
${ list.dname }
${ list.loc } <hr />
</c:forEach> <p>

<input type="button" value="지점저장" onclick="javascript:window.location.href='writeform.do'">
<input type="button" value="홈으로" onclick="javascript:window.location.href='hello.do'">

</body>
</html>