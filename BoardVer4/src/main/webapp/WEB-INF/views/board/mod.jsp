<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MOD</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="/res/css/forAll.css" rel="stylesheet">
<script defer src="/res/js/forAll.js"></script>

</head>
<body>
	<h2>MODIFY</h2>
	
	<span class="itsU">${loginUser.user_Name }(${loginUser.user_Id })</span>님의 <br>
	<span class="content">${yourListCount }</span>개의 글 중 <span class="content">${yourCount }</span>번째 글을 <span class="content">수정</span>하는 중이예요~! ^^
	
	<div class="content">♡ ${vo.iboard }.</div>
	
	<form action="mod?iboard=${vo.iboard }" method="post">
		제목<div><input type="text" name="title" value="${vo.title }" ></div>
		내용 <textarea name="ctnt">${vo.ctnt}</textarea>
		<div><button type="submit">글 수정</button></div>
		<div><button type="reset">리셋</button></div>
	</form>
	
	<div><a href="list"><button>게시판으로 가기</button></a></div>
</body>
</html>