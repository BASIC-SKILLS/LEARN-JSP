<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<!-- defer : 외부 파일이 가장 늦게 읽혀짐 -->
<!-- js와 css는 절대 경로로 적어야 한다. 
브라우저가 이 문장을 읽고 "localhost:8090/절대 경로" 이렇게 접속해서
js파일 또는 css파일을 다운 받아서 실행하기 때문이다. -->
<!-- js와 css는 보안과 상관없고 브라우저가 경로로 찾아서 실행하는 것이기 때문에
WEB-INF 밑으로 들어가면 안되고 WEBAPP 밑에 들어가야 한다. -->
<script defer src="/res/js/forAll.js"></script>
<!-- link href="" rel="stylesheet" 이 순서로 해야지 적용이 된다. -->
<link href="/res/css/forAll.css" rel="stylesheet">

</head>
<body>
	<h2>LIST</h2>
	<span  class="itsU">${loginUser.user_Name }(${loginUser.user_Id})</span>님 등장~!!! <br>
	 오늘도 즐거운 하루 보내세요~! ^^ <br>
	여기엔 ${loginUser.user_Name }님의 글이 ${yourArticleAtHere}개있어요~! ^^ <br>
	<c:if test="${yourArticleAtHere eq 0}">
		<span class="alam">${loginUser.user_Name }님! 글 좀 쓰셔요~! ^^</span>
	</c:if>
	
	<div><a href="/user/userInfo"><button>☆ 내 정보 ☆</button></a></div>


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
</body>
</html>