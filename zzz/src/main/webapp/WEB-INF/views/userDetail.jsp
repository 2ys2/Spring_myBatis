<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<html>
<head>
<title>유저 상세정보</title>
</head>
<body>
	<h1>유저 상세정보</h1>
	<table>
		<tr>
			<td>id:</td>
			<td><span>${user.id}</span></td>
		</tr>
		<tr>
			<td>name:</td>
			<td><span>${user.name}</span></td>
		</tr>
		<tr>
			<td>age:</td>
			<td><span>${user.age}</span></td>
		</tr>
		<tr>
			<td>description:</td>
			<td><pre>${user.description}</pre></td>
		</tr>
	</table>

</body>
</html>
