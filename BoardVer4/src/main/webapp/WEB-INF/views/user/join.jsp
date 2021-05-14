<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>
</head>
<body>
	<h2>JOIN</h2>
	
	<div><a href="/user/login">로그인</a></div>
	
	<c:if test="${param.msg eq 'noUser'}">
		<div style="color:red">아마 회원가입 해야할 것 같죠~? ^^</div>
	</c:if>
	
	<div>
		<form action="join" method="post">
			<div><input type="text" name="user_Id" placeholder="아이디"></div>
			<div><input type="password" name="user_Pw" placeholder="비밀번호"></div>
			<div><input type="password" name="confirmPw" placeholder="비밀번호 확인"></div>
			<div><input type="text" name="user_Name" placeholder="이름"></div>
			<div>성별 : 
				<label>남성<input type="radio" name="gender" value="0" checked></label>
				<label>여성<input type="radio" name="gender" value="1" ></label>
			</div>
			<div><input type="email" name="user_Email" placeholder="이메일"></div>
			<div><input type="submit" value="회원가입"></div>
		</form>
	</div>
	<br>
	<div style="background-color:pink; padding:1rem;"> 주의~!
	<p>♡ 아이디, 이름, 성별은 수정이 불가입니당~^^  이 점 유의하시며 작성해주세요~ ^^</p>
	<p>♡ 이메일은 아이디와 비밀번호 찾기에 이용됩니다~^^ </p>
	<p>♡ 로그인에 성공하셔야 이메일 변경이 가능하오니 이 점 유의해주세요~^^</p>
	<p>♡ (이메일, 비밀번호 변경 가능)</p>
	</div>
</body>
</html>