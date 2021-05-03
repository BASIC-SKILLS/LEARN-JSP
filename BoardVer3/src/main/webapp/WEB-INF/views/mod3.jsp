<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MODIFY3</title>
</head>
<body>
	<h2>MODIFY3</h2>
	
	<form action="/mod3" method="post">
		<div><input type="hidden" name="iboard" value="${param.iboard }"></div>
		<div>제목 : <input type="text" name="title" value="${vo.title }"></div>
		<div>내용 : <textarea name="ctnt">${vo.ctnt }</textarea></div>
		<div>
			<input type="submit" value="수정">
			<input type="reset" value="초기화">
		</div>
	</form>
	
	<div><a href="/list3">리스트</a></div>
</body>
</html>