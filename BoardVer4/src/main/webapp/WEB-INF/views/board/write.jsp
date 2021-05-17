<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>WRITE</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="/res/css/forAll.css" rel="stylesheet">
<script defer src="/res/js/forAll.js"></script>

</head>
<body>
	<h2>WRITE</h2>
	<span class="itsU">${loginUser.user_Name }(${loginUser.user_Id})</span>님, 오늘은 어떤 글을 적으실 건가요? ^^ <br>
	${loginUser.user_Name }님은 총 ${loginUser.listCount}개의 글을 쓰셔서 <br>
	지금 쓰는 글은 ${loginUser.listCount + 1}번째 글이랍니다~ ^^
	
	<form action="write" method="post">
		<div><input type="text" name="title" placeholder="제목"></div>
		<textarea name="ctnt" placeholder="내용"></textarea>
		<div><button type="submit">글 등록</button></div>
		<div><button type="reset">리셋</button></div>
	</form>
	
	<div><a href="list"><button>게시판으로 가기</button></a></div>
</body>
</html>