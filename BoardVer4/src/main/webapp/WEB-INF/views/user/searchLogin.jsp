<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEARCHLOGIN</title>

<style>
a {
	color: purple;
	text-decoration: none;
}

.record {
	cursor: pointer;
}

.record:hover {
	text-decoration: pink wavy underline;
	text-underline-position: under;
}

.msg {
	color: red
}
</style>
</head>
<body>
	<h2>SEARCH LOGIN</h2>
	<p>
		<c:choose>
			<c:when test="${param.err eq 'checkPw'}">
				<h3>CHECK PASSWORD</h3>
				<h3>비밀번호를 확인해주세요</h3>
				<c:if test="${param.errMsg eq 'checkPw'}">
					<div></div>
					<div class="msg">비밀번호를 ${param.errCount}번 틀렸습니다. 다시 시도해주세요.</div>
					<div class="msg">5번 이상 틀리면 다시 로그인 해야 합니다.</div>
				</c:if>

				<form
					action="/user/checkPw?from=${param.from }&iboard=${param.iboard}&errCount=${param.errCount}"
					method="post">
					<div>
						<input type="password" name="user_Pw" placeholder="비밀번호 입력">
					</div>
					<div>
						<input type="submit" value="확인">
					</div>
				</form>
			</c:when>
			<c:when test="${param.err eq 'searchId'}">
				<h3>SEARCH ID</h3>
				<h3>아이디 찾기</h3>

				<form action="searchLogin?search=id" method="post">
					<div>
						<input type="text" name="user_Name" placeholder="이름">
					</div>
					<div>
						성별 : <label>남성<input type="radio" name="gender" value="0" checked></label> 
							<label>여성<input type="radio" name="gender" value="1"></label>
					</div>
					<div>
						<input type="text" name="user_Email" placeholder="이메일">
					</div>
					<div>
						<input type="submit" value="확인">
					</div>
				</form>
			</c:when>
			<c:when test="${param.err eq 'searchPw' || param.errPw eq '5'}">
		    	비밀번호 찾기 
		    </c:when>
			<c:when test="${param.errId eq '5' || param.err eq '5'}">
				<img
					src="https://i.pinimg.com/originals/af/a2/0a/afa20a60bf15e99b30a1f09cbedad6c7.jpg"
					onload="moveJoin()">
			</c:when>
		</c:choose>
	</p>
</body>

<script>
	function moveJoin() {
		location.href = 'join?msg=noId';
	}
</script>
</html>