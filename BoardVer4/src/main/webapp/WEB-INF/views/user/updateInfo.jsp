<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATEINFO</title>

<style>
	body {line-height:2rem;}
	.content {text-decoration:green wavy underline; text-underline-position: under; padding:1rem;}
	.star {text-decoration:green wavy underline; text-underline-position: under; background-color:black; color:yellow;}
</style>
</head>
<body>
	<h2>UPDATE INFO</h2>
	
	${loginUser.user_Name }(${loginUser.user_Id})님의 정보~!
	<form action="updateInfo" method="post">
		<div>회원번호 <span class="content">♡ ${loginUser.iUser }</span></div>
		<div>아이디 <span class="content">${loginUser.user_Id }</span></div>
		<div>이름 <span class="content">${loginUser.user_Name }</span></div>
		<div>성별 <span class="content">${loginUser.gender eq 0 ? '남' : '여' }</span></div>
		<div>가입일자 <span class="content">${loginUser.regdt }</span></div>
		<div><span class="star">★ 새로운 이메일</span> <input type="email" name="user_Email"></div>
		<div><span class="star">★ 새로운 비밀번호</span> <input type="password" name="user_Pw"></div>
		<div><span class="star">★ 비밀번호 확인</span> <input type="password" name="confirmPw"></div>
		<div><span class="content">♡ ${loginUser.listCount }</span>개의 글을 쓰셨어요~^^</div>
		<div><span class="content">♡ ${loginUser.delCount }</span>개의 글을 지웠어요~^^</div>
		<div><span class="content">♡ ${loginUser.modCount }</span>번 글을 수정했어요~^^</div>
		<div><input type="submit" value="내 정보 수정"></div>
	</form>
</body>
</html>