<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>join.jsp page</title>
</head>
<body>
<h2>회원가입</h2>
<form action="/insertUser" method="post">
<table>
	<tr>
		<td>아이디</td>
		<td><input name="username"></td>
	</tr>
	<tr>
		<td>비밀번호</td>
		<td><input type="password" name="password"></td>
	</tr>
	<tr>
		<td>사용권한</td>
		<td>
			<select name="authority">
				<option value="ROLE_USER">일반사용자</option>
				<option value="ROLE_MEMBER">중간관리자</option>
				<option value="ROLE_ADMIN">관리자</option>
			</select>
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">	
			<input type="submit" value="회원가입">
		</td>
	</tr>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</table>
</form>
</body>
</html>
