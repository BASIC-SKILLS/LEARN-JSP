<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- WEB-INF 파일 안에 있어서 독자적으로 run되지 않는다. -->
<title>Write</title>
</head>
<body>
	<h1> 글쓰기 </h1>
	
	<form action="/write" method="post">
		<div> 제목 : <input type="text" name="title"> </div>
		<br><br>
		<div> 내용 : <textarea name="cntnt" rows="10" cols="10"></textarea></div>
		<div> <input type="submit" value="글쓰기"> </div>
		<!-- reset 시키는 법 -->
		<div><input type="reset" value="초기화"></div>
	</form>
</body>
</html>