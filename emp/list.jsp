<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <h1>이젠 사원정보 목록</h1>
 <hr>
 <table border="1">
 	<tr>
 	<th>사번</th>
 	<th>이름</th>
 	<th>직무</th>
 	<th>상사</th>
 	<th>급여</th>
 	</tr>
		<c:forEach items="${ eList }" var="member"> 	
 	<tr>
 		<td><a href="/emp/remove?empno=${ member.empno }">${ member.empno }</a></td>
 		<td>${ member.ename }</td>
 		<td>${ member.job }</td>
 		<td><a href="/emp/read?empno=${ member.mgr }">${ member.mgr }</a></td>
 		<td>${ member.sal }</td>
 	</tr>
 		</c:forEach>
 </table>
 <script>
        // JavaScript 코드
        <% if (request.getAttribute("script") != null) { %>
            <%= request.getAttribute("script") %>
        <% } %>
    </script>
</body>
</html>