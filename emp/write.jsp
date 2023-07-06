<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>이젠 사원정보 등록</h1>
	<hr>
	<form action="/emp/write" method="POST">
		
		사번 : <input type = "text" name="empno"><br>
		이름 : <input type = "text" name="ename"><br>
		직무 : <input type = "text" name="job"><br>
		상사 : <input type = "text" name="mgr"><br>
		급여 : <input type = "text" name="sal"><br>
		<input type="submit" value="등록"	>	
	</form>
</body>
</html>