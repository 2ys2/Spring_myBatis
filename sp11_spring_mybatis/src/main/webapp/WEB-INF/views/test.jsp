<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> test.jsp </title>

<style type="text/css">
table { width: 600px; }
th { background-color: orange;}
</style>

</head>
<body>
<h1>TEST</h1>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>내용</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
			<tr>
				<td>${ dto.num }</td>
				<td>${ dto.tab }</td>
				<td>${ dto.num }</td>
				<td>${ dto.name }</td>
				<td>${ dto.regdate }</td>
				<td>${ dto.hit }</td>
			</tr>
	</table>

</body>
</html>