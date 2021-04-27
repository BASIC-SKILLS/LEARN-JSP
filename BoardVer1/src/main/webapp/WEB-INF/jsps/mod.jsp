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
<!-- WEB-INF 파일 안에 있어서 독자적으로 run되지 않는다. -->
<title>MODIFY</title>
</head>
<body>
	<h1> 글수정 </h1>
	
	<form action="/mod" method="post">
		<input type="hidden" name="no" value="<%=no %>">
		<div> 제목 : <input type="text" name="title" value="<%=vo.getTitle()%>"> </div>
		<br><br>
		<div> 내용 : <textarea name="cntnt" rows="10" cols="10"><%=vo.getCntnt()%></textarea></div>
		
		<div> <input type="submit" value="글수정"> </div>
		<div><input type="reset" value="초기화"></div>
	</form>
</body>
</html>