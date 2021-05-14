<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MOD</title>
<style>
	body {line-height:2rem;}
	.content {text-decoration:green wavy underline; text-underline-position: under; padding:1rem;}
</style>
</head>
<body>
	<h2>MODIFY</h2>
	<span class="content">${loginUser.user_Name }(${loginUser.user_Id })</span>님의 <br>
	<span class="content">${yourListCount }</span>개의 글 중 <span class="content">${yourCount }</span>번째 글을 <span class="content">수정</span>하는 중이예요~! ^^
	
	<div class="content">♡ ${vo.iboard }.</div>
	
	<form action="mod?iboard=${vo.iboard }" method="post">
		제목<div><input type="text" name="title" value="${vo.title }"></div>
		내용 <textarea name="ctnt">${vo.ctnt}</textarea>
		<div><input type="submit" value="글수정"></div>
		<div><input type="reset" value="리셋"></div>
	</form>
	
	<div><a href="list">게시판으로 가기</a></div>
</body>
</html>