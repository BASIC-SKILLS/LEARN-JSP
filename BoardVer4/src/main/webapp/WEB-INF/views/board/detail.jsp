<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
<style>
	body {line-height:2rem;}
	.content {text-decoration:green wavy underline; text-underline-position: under; padding:1rem;}
</style>
</head>
<body>
<h2>DETAIL</h2>
<div>${vo.user_Name }(${vo.user_Id })님의 ${yourListCount }개의 글 중 ${yourCount }번째 글</div>
<div class="content">♡ ${vo.iboard }.</div>
제목  <div class="content">${vo.title }</div>
내용  <div class="content">${vo.ctnt} </div>
작성일자  <div class="content">${vo.regdt }</div>

<c:if test="${vo.iuser eq loginUser.iUser && param.err eq null }">
	<button onclick="searchLogin(${vo.iboard })">글 수정</button>
	<button onclick="searchLogin(${vo.iboard })">글 삭제</button>
</c:if>

<c:if test="${vo.iuser eq loginUser.iUser && param.err eq 'done'}">
	<button onclick="moveModify()">글 수정</button>
	<button onclick="moveDel()">글 삭제</button>
</c:if>

<div><a href="list">게시판으로 가기</a></div>

<script>
	function searchLogin(iboard) {location.href='/searchLogin?err=checkPw&from=detail&iboard='+iboard;}
	function moveModify() {location.href='mod?iboard='+${vo.iboard };}
	function moveDel() {location.href='del?iboard='+${vo.iboard };}
</script>
</body>
</html>