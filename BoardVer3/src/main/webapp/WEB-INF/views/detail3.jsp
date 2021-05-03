<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL3</title>
</head>
<body>
	<h2>DETAIL3</h2>
	
	<div>글 번호 : ${param.iboard }</div>
	<div>제목 : ${vo.title }</div>
	<div>내용 : ${vo.ctnt }</div>
	<div>작성일 : ${vo.regdt }</div>
	
	<a href="/del3?iboard=${param.iboard }">삭제</a>
	<a href="/mod3?iboard=${param.iboard }">수정</a>
	
	<div><a href="/list3">리스트</a></div>
</body>
</html>