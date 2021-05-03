<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LIST3</title>

<style type="text/css">
	.record { cursor : pointer; }
	.record:hover { color: pink;  }
	

</style>
</head>
<body>
	<h2>LIST3</h2>
	
	<div><a href="/write3">글쓰기</a></div>
	
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
				<th>작성일</th>
			</tr>
			
			
				<c:forEach var="item" items="${list }">
				<tr class="record" onclick="moveToDetail(${item.iboard });" >
					<td>${item.iboard }</td>
					<td>${item.title }</td>
					<td>${item.regdt }</td>
				</tr>
				</c:forEach>
				
			
		</table>
	</div>
	
	<script>
		function moveToDetail(iboard) {
			// 이렇게 하면 행 전체를 a태그 준 것과 같은 효과
			// 그리고 소스의 중복을 완전히 없애준다. 
			console.log('list3.jsp iboard : %d', iboard);
			location.href = '/detail3?iboard='+iboard;
		}
	</script>
</body>
</html>