<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATEINFO</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="/res/css/forAll.css" rel="stylesheet">
<script defer src="/res/js/forAll.js"></script>

</head>
<body>
	<h2>UPDATE INFO</h2>

	${loginUser.user_Name }(${loginUser.user_Id})님의 정보 수정~!
	<br>

	<c:if test="${param.msg eq 'allEmpty' }">
		<p style="color: red">
			이메일과 비밀번호 항목이 모두 비었습니다. <br> 최소 하나의 항목은 작성하셔야 수정이 됩니다. <br>
			5번 이상 모든 항목을 비우고 수정을 시도할 시 자동 로그아웃 됩니다. <br> 
			공백 오류 : ${param.emptyCount }
		</p>
	</c:if>

	<form
		action="updateInfo?emptyCount=${param.emptyCount }&&msg=${param.msg}"
		method="post">
		<div>
			회원번호 <span class="content">♡ ${loginUser.iUser }</span>
		</div>
		<div>
			아이디 <span class="content">${loginUser.user_Id }</span>
		</div>
		<div>
			이름 <span class="content">${loginUser.user_Name }</span>
		</div>
		<div>
			성별 <span class="content">${loginUser.gender eq 0 ? '남' : '여' }</span>
		</div>
		<div>
			가입일자 <span class="content">${loginUser.regdt }</span>
		</div>
		<div>
			<span class="star">★ 새로운 이메일</span> <input type="email"
				name="user_Email" >
		</div>
		<div>
			<span class="star">★ 새로운 비밀번호</span> <input type="password"
				name="user_Pw" >
		</div>
		<div>
			<span class="star">★ 비밀번호 확인</span> <input type="password"
				name="confirmPw">
		</div>
		<div>
			<span class="content">♡ ${loginUser.listCount }</span>개의 글을 쓰셨어요~^^
		</div>
		<div>
			<span class="content">♡ ${loginUser.delCount }</span>개의 글을 지웠어요~^^
		</div>
		<div>
			<span class="content">♡ ${loginUser.modCount }</span>번 글을 수정했어요~^^
		</div>
		<div>
			<button type="submit">내 정보 수정</button><button type="button" onclick="moveBack()">취소</button>
		</div>
	</form>

</body>
</html>