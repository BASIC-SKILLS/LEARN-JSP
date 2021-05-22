<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LOGIN</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="/res/css/forAll.css" rel="stylesheet">
<script defer src="/res/js/forAll.js"></script>

</head>
<body>
	<h2>LOGIN</h2>
	<p class="msg">
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
	<p >에러 : <span class="msg">${param.err }</span></p>
	<p >아이디 틀림 : <span class="msg">${param.errId }</span></p>
	<p >비밀번호 틀림 : <span class="msg">${param.errPw }</span></p>
	
	<div>
		<form action="/user/login?err=${param.err }&errId=${param.errId }&errPw=${param.errPw }" method="post">
			<div><input type="text" name="user_Id" placeholder="아이디" ></div>
			<div><input type="password" name="user_Pw" placeholder="비밀번호" ></div>
			<div><button type="submit">로그인</button></div>
		</form>
		
		<div><a href="join"><button>회원가입</button></a></div>
		<button onclick="searchLogin('searchId')">아이디 찾기</button>
		<button onclick="searchLogin('searchPw')">비밀번호 찾기</button>
	</div>
	
</body>
</html>