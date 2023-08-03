<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>membercheckSuccess</title>
</head>
<body>
	<h1>MembercheckSuccess Page</h1>

	<h2>
		<c:forEach items="${ memberok }" var="ok">
			${ ok.id }
			${ ok.name }
			${ ok.age } <hr />
		</c:forEach>
	</h2>
		<input type="button" value="로그인"  onclick="javascript:location.href='login.kosa'" />&nbsp;&nbsp;
		<input type="button" value="뒤로가기"  onclick="javascript:location.href='check.kosa'" />
</body>
</html>