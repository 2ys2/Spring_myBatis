<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list.jsp List Page</title>
</head>
<body>
	<h1>List Page</h1>
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
				<td><a href="board?cmd=delete&seq=${ list.seq }">삭제</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<input type="button" value="글쓰기" onclick="javascript:location.href='board?cmd=writeForm'" >
	<input type="button" value="검색하기" onclick="javascript:location.href='board?cmd=searchForm'" >

	<!-- <a href="javascript:location.href='board?cmd=writeForm'">글쓰기</a> -->
	<!-- <a href="views/writeForm.jsp'">글쓰기</a> -->
                                                                        
</body>
</html>