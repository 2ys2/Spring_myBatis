<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>로그인</title>
  </head>
  <body>
    <h1>로그인 페이지</h1>
    <form action="${pageContext.request.contextPath}/login" method="post">
      <table>
        <tr>
          <td>id: </td>
          <td><input type="text" name="username"/></td>
        </tr>
        <tr>
          <td>password: </td>
          <td><input type="password" name="password"/></td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <tr>
          <td colspan="2"><button>로그인</button></td>
        </tr>
      </table>
    </form>
    <button onclick="location.href='signUpForm'">회원가입</button>
    <button onclick="location.href='getList'">회원목록</button>


  </body>
</html>
