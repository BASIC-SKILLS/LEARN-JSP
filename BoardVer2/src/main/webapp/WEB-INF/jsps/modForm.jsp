<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODFORM</title>
</head>
<body>
	<h2>MODFORM</h2>
	
	<form action="/mod?no=${param.no }" method="post">
		<div>글번호 : ${param.no }</div>
		<div>제목 : <input type="text" name="title" value="${article.title}"></div>
		<div>내용 : <textarea name="ctnt" cols="10" rows="10" >${article.ctnt}</textarea></div>
		
		<div><input type="submit" value="수정"></div>
		<div><input type="reset" value="초기화"></div>
	</form>
</body>
</html>