<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>USERINFO</title>
<style>
	body {line-height:2rem;}
	.content {text-decoration:green wavy underline; text-underline-position: under; padding:1rem;}
</style>
</head>
<body>
	<h2>USER INFO</h2>
	<c:if test="${param.msg eq 'noEmail'}">
		<div style="color:red">새 이메일을 입력하지 않으셔서 비밀번호만 변경되었습니다.</div>
	</c:if>
	${loginUser.user_Name }(${loginUser.user_Id})님의 정보~!
	<div>회원번호 <span class="content">♡ ${loginUser.iUser }</span></div>
	<div>아이디 <span class="content">${loginUser.user_Id }</span></div>
	<div>이름 <span class="content">${loginUser.user_Name }</span></div>
	<div>성별 <span class="content">${loginUser.gender eq 0 ? '남' : '여' }</span></div>
	<div>가입일자 <span class="content">${loginUser.regdt }</span></div>
	<c:if test="${param.msg eq 'noPw'}">
		<div style="color:red">새 비밀번호를 입력하지 않으셔서 이메일만 변경되었습니다.</div>
	</c:if>
	<div>이메일 <span class="content">${loginUser.user_Email }</span></div>
	<div><span class="content">♡ ${loginUser.listCount }</span>개의 글을 쓰셨어요~^^</div>
	<div><span class="content">♡ ${loginUser.delCount }</span>개의 글을 지웠어요~^^</div>
	<div><span class="content">♡ ${loginUser.modCount }</span>번 글을 수정했어요~^^</div>
	
	
	<c:if test="${param.err ne 'done' }">
		<button onclick="searchLogin('checkPw&from=userInfo')">내정보 변경</button>
		<button onclick="searchLogin('checkPw&from=userInfo')">회원탈퇴</button>
	</c:if>

	<c:if test="${param.err eq 'done'}">
		<button onclick="updateInfo()">내정보 변경</button>
		<button onclick="leaveEver()">회원탈퇴</button>
	</c:if>
	
	
	
	<div><a href="/board/list">게시판으로 가기</a></div>
	
	<script>
		function searchLogin(str, iboard) {location.href='/searchLogin?err='+str;}
		function updateInfo() {location.href='updateInfo';}
		function leaveEver() {
			var confirmLeave;
			confirmLeave = confirm('정말 회원탈퇴 하시겠습니까?');
			if (confirmLeave) {
				location.href='leaveEver';
				return;
			} 
			history.back();
		}
	</script>
</body>
</html>