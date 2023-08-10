<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>login.jsp page</title>

<script type="text/javascript">
	function join(){
		location.href="/join";
	}
</script>

</head>
<body>
<h1>로그인 페이지</h1>
<h2><c:out value="${error}"/></h2>
<h2><c:out value="${logout}"/></h2>
<form action="/login" method="post">
<table>
	<tr>
		<td>아이디</td>
		<td><input type="text" name="username"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="password">
			<input name="_spring_security_remember_me" 	type="checkbox">자동 로그인</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<input type="submit" value="로그인">
			<input type="button" value="회원가입" onclick="join()">
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</td>
	</tr>
</table>
</form>
</body>
</html>