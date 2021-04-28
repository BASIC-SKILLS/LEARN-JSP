<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% String str = "String"; %>

<% //내장객체에 같은 key값으로 setAttribute를 하면 순서대로 내려가면서 찾아본다. 
	String name = "홍길동";
	pageContext.setAttribute("name", "A");
	request.setAttribute("name", "B");
	session.setAttribute("name", "C");
	application.setAttribute("name", "D");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>
</head>
<body>
	<h2>DETAIL</h2>
	<div> 글 번호 : ${param.no }</div>
	<div> 제목 : ${data.title }</div>
	<div> 내용 : ${data.ctnt }</div>
	<a href="/mod?no=${param.no }"><button>수정</button></a>
	<a href="/del?no=${param.no }"><button>삭제</button></a>
	
	
	<br><br><br><br><br><br><br><br>
	
	<!-- EL식은 setAttribute한 것만 쓸 수 있다. -->
	<div> String str = <%=str %> </div>
	<div> 내장객체 str : ${str } </div>
	<div>${age } ${owner }</div>
	
	<!-- EL식에 param을 적는 순간, 내장객체에서 쓰는 것이 아니라 쿼리스트링에서 쓴다  -->
	<div> 쿼리 스트링 : ${param.no } </div> 
	
	<div> 내장객체들에 저장된 name들 중 무엇이 출력될까 : ${name } </div>
	
	<!-- EL식에서 가져올 값이 없는 경우는 에러가 나지 않고 그냥 빈칸을 출력한다. -->
</body>
</html>