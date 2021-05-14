<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>
<style>
	a {color:purple; text-decoration:none; }
	.record { cursor: pointer; }
	.record:hover { text-decoration:pink wavy underline; text-underline-position: under; }
</style>
</head>
<body>
	<h2>LIST</h2>
	${loginUser.user_Name }(${loginUser.user_Id}) 등장~!!! <br>
	 오늘도 즐거운 하루 보내세요~! ^^ <br>
	${loginUser.user_Name }님은 총 ${loginUser.listCount}개의 글을 쓰셨어요~! ^^ <br>
	<c:if test="${loginUser.listCount eq 0}">
		${loginUser.user_Name }님! 글 좀 쓰셔요~! ^^
	</c:if>
	
	<div><a href="/user/userInfo">[내 정보]</a></div>


	<!-- write는 예약어라서 write()라고 쓰면 절대 function으로 이동이 안된다. -->
	<div><button onclick="moveWrite()">글쓰기</button></div>
	<div>
		<table>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자(ID)</th>
				<th>작성일</th>
			</tr>
			
			<c:forEach var="item" items="${list }">
				<tr class="record" onclick="moveDetail(${item.iboard })">
					<td>♡ ${item.iboard }.</td>
					<td>${item.title }</td>
					<td>${item.user_Name }(${item.user_Id })</td>
					<td>${item.regdt}</td>
				</tr>
			</c:forEach>
		
		</table>
	</div>
	<div style="color:grey">총 ${listCount }개의 글이 있습니다.</div>
	<div><button onclick="moveLogout()">로그아웃</button></div>
	<div><a href="/user/login">로그인 페이지로 갈 수 있으면 한번 가봐~^^</a></div>
</body>
<script>
	function moveWrite() {location.href='write';}
	function moveLogout() {location.href='/user/logout';}
	function moveDetail(iboard) {location.href='detail?iboard='+iboard;}
</script>
</html>