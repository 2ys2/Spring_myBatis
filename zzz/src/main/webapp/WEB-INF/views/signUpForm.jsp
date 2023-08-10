<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>회원가입</title>
</head>
<body>
	<h1>회원가입 페이지</h1>
	<form action="signup" method="post">
		<table>
			<tr>
				<td>id:</td>
				<td><input type="text" placeholder="id입력" name="id"></td>
			</tr>
			<tr>
				<td>password:</td>
				<td><input type="password" placeholder="비밀번호입력" name="password">
				</td>
			</tr>
			<tr>
				<td>name:</td>
				<td><input type="text" placeholder="이름입력" name="name">
				</td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" placeholder="나이입력" name="age" /></td>
			</tr>
			<tr>
				<td>사용권한</td>
				<td><select name="authority">
						<option value="ROLE_USER">일반사용자</option>
						<option value="ROLE_ADMIN">관리자</option>
				</select></td>
			</tr>
			<tr>
				<td>description:</td>
				<td><textarea name="description" placeholder="자기소개입력"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원가입" /></td>
			</tr>
		</table>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
	</form>
</body>
</html>
