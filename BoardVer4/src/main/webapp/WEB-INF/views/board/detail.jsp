<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="/res/css/forAll.css" rel="stylesheet">
<script defer src="/res/js/forAll.js"></script>

</head>
<body>
<h2>DETAIL</h2>
<div><span class="itsU">${vo.user_Name }(${vo.user_Id })</span>님의 ${yourListCount }개의 글 중 ${yourCount }번째 글</div>
<div class="content">♡ ${vo.iboard }.</div>
제목  <div class="content">${vo.title }</div>
내용  <div class="content">${vo.ctnt} </div>
작성일자  <div class="content">${vo.regdt }</div>

<c:if test="${vo.iuser eq loginUser.iUser && param.err eq null }">
	<button onclick="searchLogin('checkPw','detail',${vo.iboard })">글 수정</button>
	<button onclick="searchLogin('checkPw','detail',${vo.iboard })">글 삭제</button>
</c:if>

<c:if test="${vo.iuser eq loginUser.iUser && param.err eq 'done'}">
	<button onclick="moveModify(${vo.iboard })">글 수정</button>
	<button onclick="moveDel(${vo.iboard })">글 삭제</button>
</c:if>

<div>
	<form action="regCmt" method="post">
		<input type="hidden" name="iboard" value="${vo.iboard }">
		<div>
			<textarea name="cmt" placeholder="댓글" ></textarea>
			<button type="submit">등록</button>
		</div>
	</form>
</div>

<div><a href="list">게시판으로 가기</a></div>
	
</body>
</html>