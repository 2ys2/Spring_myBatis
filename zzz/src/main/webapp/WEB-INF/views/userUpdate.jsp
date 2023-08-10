<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>회원정보 수정</title>
</head>
<body>
	<h1>회원정보 수정</h1>
	<form action="update" method="post">
		<table>
			<tr>
				<td>id:</td>
				<td><input type="text" placeholder="id입력" name="id" value="${user.id}" readonly></td>
			</tr>
			<tr>
				<td>name:</td>
				<td><input type="text" placeholder="이름입력" name="name" value="${user.name}"></td>
			</tr>
			<tr>
				<td>age:</td>
				<td><input type="text" placeholder="나이입력" name="age" value="${user.age}" /></td>
			</tr>
			<tr>
				<td>auth:</td>
				<td><select name="authority">
						<option value="ROLE_USER">일반사용자</option>
						<option value="ROLE_ADMIN">관리자</option>
				</select></td>
			</tr>
			<tr>
				<td>description:</td>
				<td><textarea name="description" placeholder="자기소개입력">${user.description}</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="회원정보수정" /></td>
			</tr>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		</table>
	</form>

</body>
</html>
