<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>회원 상세정보</title>
</head>
<body>
	<h1>회원 상세정보</h1>
	<table>
		<tr>
			<td>id: </td>
			<td><span>${user.id}</span></td>
		</tr>
		<tr>
			<td>name: </td>
			<td><span>${user.name}</span></td>
		</tr>
		<tr>
			<td>age: </td>
			<td><span>${user.age}</span></td>
		</tr>
		<tr>
			<td>auth: </td>
			<td><span>${auth.auth }</span></td>
		</tr>
		<tr>
			<td>description: </td>
			<td><pre>${user.description}</pre></td>
		</tr>
	</table>
	<button onclick="location.href='updateForm?id=${user.id}'">회원정보 수정</button>
	<br>
	<button onclick="location.href='delete?id=${user.id}'">회원 탈퇴</button>
	<br>
	<form action="logout" method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
		<button>로그아웃</button>
	</form>

</body>
</html>
