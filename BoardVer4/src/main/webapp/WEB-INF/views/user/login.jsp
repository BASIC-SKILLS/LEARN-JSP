<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>

<style>
	.errMsg { color : red; }
</style>
</head>
<body>
	<h2>LOGIN</h2>
	<p class="errMsg">
		<c:choose>
		    <c:when test="${param.errMsg eq 'id'}">
		        아이디가 엄써용 힝 ㅠㅠ
		    </c:when>
		    <c:when test="${param.errMsg eq 'pw'}">
		        비밀번호를 틀려써용 힝 ㅠㅠ
		    </c:when>
		    <c:when test="${param.errMsg eq 'error'}">
		        비밀번호를 틀려써용 힝 ㅠㅠ
		    </c:when>
		    <c:when test="${param.errMsg eq 'again'}">
		        비밀번호를 5번 이상 틀렸습니다. 다시 로그인 해주세요.
		    </c:when>
		</c:choose>
	</p>
	<p class="errMsg">에러 : ${param.err }</p>
	<p class="errMsg">아이디 틀림 : ${param.errId }</p>
	<p class="errMsg">비밀번호 틀림 : ${param.errPw }</p>
	
	<div>
		<form action="/user/login?err=${param.err }&errId=${param.errId }&errPw=${param.errPw }" method="post">
			<div><input type="text" name="user_Id" placeholder="아이디"></div>
			<div><input type="password" name="user_Pw" placeholder="비밀번호"></div>
			<div><input type="submit" value="로그인"></div>
		</form>
		
		<div><a href="join">회원가입</a></div>
		<button onclick="searchLogin('=searchId')">아이디 찾기</button>
		<button onclick="searchLogin('=searchPw')">비밀번호 찾기</button>
		<div><a href="/board/list">게시판 페이지로 갈 수 있으면 한번 가봐~^^</a></div>
	</div>
	
	<script>
		function searchLogin(str) {location.href='/searchLogin?err'+str;}
	</script>
</body>
</html>