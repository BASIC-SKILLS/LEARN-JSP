<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WRITE</title>
</head>
<body>
	<h2>WRITE</h2>
	
	<form action="/write" method="post">
		<div>제목 : <input type="text" name="title"></div>
		<div>내용 : <textarea cols="10" rows="10" name="ctnt"></textarea></div>
	
		<div><input type="submit" value="저장">  <input type="reset" value="초기화"></div>
	</form>
</body>
</html>