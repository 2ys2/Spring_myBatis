<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <h1>회원목록</h1>
    <button onclick="location.href='loginForm'">로그인페이지</button>

    <table border="1">
      <tr>
        <th>id</th>
        <th>name</th>
        <th>age</th>
      </tr>
      <c:forEach items="${list}" var="user">
        <tr onclick="location.href='userdetail?id=${user.id}'">
          <td>${user.id}</td>
          <td>${user.name}</td>
          <td>${user.age}</td>
        </tr>
      </c:forEach>

    </table>
  </body>
</html>
