<%@page import="com.koreait.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String no = request.getParameter("no");
	BoardVo vo = (BoardVo) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Detail</title>
</head>
<body>
	<div><%=request.getParameter("no") %>.</div>
	<div>글 <%=no %>번의</div>
	<div>제목 : <%=vo.getTitle() %></div>
	<div>내용 : <%=vo.getCntnt() %></div>	
	
	<!-- post -->
	<form action = "/del" method="post">
		<input type="hidden" name="no" value="<%=no%>">
		<input type="submit" value="삭제">
	</form>
	
	<!-- get 
	<a href = "/del?no=<%=no%>"> <button>삭제</button></a>
	-->
</body>
</html>