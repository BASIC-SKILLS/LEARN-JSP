<%@page import="com.koreait.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	List<BoardVo> list = (List<BoardVo>) request.getAttribute("dataList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- WEB-INF 파일 안에 있어서 독자적으로 run되지 않는다. -->
<title>List</title>
</head>
<body>
	<h1> 리스트 </h1>
	
	<div><a href="/write">글쓰기</a></div>
	
	<% for (int i = 0; i < list.size(); i++) {
		BoardVo vo = list.get(i);
	%>
		<div><%=i+1 %> . <%=vo.getTitle() %> </div>
		<div><%=vo.getCntnt() %> </div>
	<%} %>
	
	
</body>
</html>