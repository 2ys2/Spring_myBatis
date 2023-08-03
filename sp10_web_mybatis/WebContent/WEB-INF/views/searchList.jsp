<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchList.jsp 검색해봅시다.</title>
</head>
<body>
	<h3>단일 검색하기</h3>
	<form action="board?cmd=search" method="post">
		<select name="column">
			<option value="title">제목</option>
			<option value="writer">작성자</option>
			<option value="content">내용</option>
		</select> <input type="text" name="keyvalue"> <input type="submit"value="검색">
	</form>

	<h3>다중 검색하기</h3>
	<form action="board?cmd=search2" method="post">
		제	목<input type="checkbox" name="title" value="title" checked>
		작성자 <input type="checkbox" name="writer" value="writer">
		내 용 <input type="checkbox" name="content" value="content">
		검색어 <input type="text" name="keyvalue"> <input type="submit" value="검색"> 
	</form>

<hr>
<table>
		<tr>
			<th>번호</th>
			<th>제목</th> 
			<th>작성자</th>
			<th>작성날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${ list }" var="list">
			<tr>
				<td>${ list.seq }</td>
				<td onclick="javascript:location.href='board?cmd=detail&seq=${ list.seq }'">${ list.title }</td>
				<td>${ list.writer }</td>
				<td>${ list.regdate }</td>
				<td>${ list.readcount }</td>
				<%-- <td><a href="board?cmd=delete&seq=${ list.seq }">삭제</a></td> --%>
			</tr>
		</c:forEach>
	</table>

</body>
</html>