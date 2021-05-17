<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SEARCHLOGIN</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="/res/css/forAll.css" rel="stylesheet">
<script defer src="/res/js/forAll.js"></script>

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
					action="/checkPw?from=${param.from }&iboard=${param.iboard}&errCount=${param.errCount}"
					method="post">
					<div>
						<input type="password" name="user_Pw" placeholder="비밀번호 입력">
					</div>
					
						<div><button type="submit">확인</button>
						<button type="button" onclick="history.back()">취소</button></div>
					
				</form>
			</c:when>
			<c:when test="${param.err eq 'searchId'}">
				<h3>SEARCH ID</h3>
				<h3>아이디 찾기</h3>

				<c:if test="${param.msg eq 'smtEmpty' }">
					<p class="msg">
						빈 항목이 하나라도 있으면 아이디를 찾을 수 없습니다. <br>
						빈 항목이 있는 채로 5번 이상 아이디찾기를 시도하시면 <br>
						회원가입창으로 자동 이동됩니다. <br>
						공백 오류 : ${param.emptyCount }
					</p>
				</c:if>
				
				<c:if test="${param.msg eq 'noId' }">
					<p class="msg">
						입력하신 정보의 사용자가 없습니다. <br>
						5번 이상 사용자가 없는 경우 <br>
						회원가입창으로 자동 이동됩니다. <br>
						정보 오류 : ${param.noIdCount }
					</p>
				</c:if>

				<form action="/searchId?emptyCount=${param.emptyCount }&noIdCount=${param.noIdCount }" method="post">
					<div>
						이름 : <input type="text" name="user_Name">
					</div>
					<div>
						성별 : <label>남성<input type="radio" name="gender" value="0"
							checked></label> <label>여성<input type="radio"
							name="gender" value="1"></label>
					</div>
					<div>
						이메일 : <input type="text" name="user_Email">
					</div>
					<div><button type="submit">확인</button>
					<button type="button" onclick="moveBack()">취소</button></div>
				</form>
			</c:when>
			<c:when test="${param.err eq 'searchPw' || param.errPw eq '5'}">
		    	<h3>SEARCH PW</h3>
				<h3>비밀번호 찾기</h3>
				
				<c:if test="${param.msg eq 'smtEmpty' }">
					<p class="msg">
						빈 항목이 하나라도 있으면 비밀번호를 찾을 수 없습니다. <br>
						빈 항목이 있는 채로 5번 이상 비밀번호찾기를 시도하시면 <br>
						회원가입창으로 자동 이동됩니다. <br>
						공백 오류 : ${param.emptyCount }
					</p>
				</c:if>
				
				<c:if test="${param.msg eq 'noPw' }">
					<p class="msg">
						입력하신 정보의 사용자가 없습니다. <br>
						5번 이상 사용자가 없는 경우 <br>
						회원가입창으로 자동 이동됩니다. <br>
						정보 오류 : ${param.noPwCount }
					</p>
				</c:if>

				<form action="/searchPw?emptyCount=${param.emptyCount }&noPwCount=${param.noPwCount }" method="post">
					<div>
						아이디 : <input type="text" name="user_Id">
					</div>
					<div>
						이름 : <input type="text" name="user_Name">
					</div>
					<div>
						성별 : <label>남성<input type="radio" name="gender" value="0"
							checked></label> <label>여성<input type="radio"
							name="gender" value="1"></label>
					</div>
					<div>
						이메일 : <input type="text" name="user_Email">
					</div>
					<div><button type="submit">확인</button>
					<button type="button" onclick="moveBack()">취소</button></div>
				</form>
		    </c:when>
			<c:when test="${param.errId eq '5' || param.err eq '5'}">
				<img
					src="https://i.pinimg.com/originals/af/a2/0a/afa20a60bf15e99b30a1f09cbedad6c7.jpg"
					onload="moveJoin()">
			</c:when>
		</c:choose>
	</p>
</body>

</html>