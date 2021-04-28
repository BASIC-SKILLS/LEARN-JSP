<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LISTS</title>
</head>
<body>
	<h2>LISTS</h2>
	
	<a href="/write">글쓰기</a>
	
	<!-- begin(시작값)에서 end(종료값)까지 출력된다. step(양수만 가능, 기본값 1)만큼 커지면서-->
	<!-- var은 Context.setAttribute의 key값 -->
	<c:forEach var="i" begin="1" end="5">
		<div>${i }</div>
		<!-- EL식으로 i를 출력했다면 어딘가에 "i"라는 이름으로 setAttribute 되었다는 의미 -->
		<!-- PageContext는 jsp가 실행될 때 만들어진다. -->
		<!-- 즉, PageContext.setAttribute("i", value) 이렇게 되는 것이다. -->
		<!-- value값에는 i의 값이 바뀔 때마다 기존의 값이 지워지고 새로우 값으로 변경된다. -->
	</c:forEach>
	
	<br><br>
	
	<c:forEach var="i" begin="0" end="10" step="3">
		<div>${i }</div>
	</c:forEach>
	
	<br><br>
	
	<!-- items : sequence가 있는 객체를 이용할 때 쓴다. 즉 주소값이 오는 곳이다.
		 var에는 items안에 들어있는 주소값들이 하나씩 하나씩 들어간다.
		 varStatus : for문 돌 때 상대값을 찍어준다.
		 varStatus.count : items의 인덱스가 차례 차례 들어간다. (1부터 시작)
		 varStatus.index : count와 같지만 0부터 시작한다.
	 -->
	
	
	<div>현재 글의 갯수 : ${list.size() }</div>
	<table>
		<tr>
			<td>no</td>
			<td>제목</td>
			<td>내용</td>
		</tr>
	
	<!-- 
		List<BoardVo> list = request.getAttribute("list");
		pageContext.setAttribute("item", list.get(0));
	 -->
		<c:forEach var="item" items="${list }" varStatus="status"> 
		<tr>
			<td>${status.index }</td>
			<td><a href="/detail?no=${status.index }">${item.title}</a> </td>
			<td>${item.ctnt }</td>
		</tr>
		</c:forEach>
	</table>
	
</body>
</html>