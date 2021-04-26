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

<style>
	table, th, td {
		border : 1px solid black;
		border-collapse : collapse;
	}
</style>
</head>
<body>
	<h1> 리스트 </h1>
	
	<div><a href="/write">글쓰기</a></div>
	
	<div>
		<table>
			<tr>
				<th>no</th>
				<th>제목</th>
			</tr>
			<% for (int i = 0; i < list.size(); i++) {
			BoardVo vo = list.get(i);
			%>
			<tr>
				<td><%=i %></td>
				<!-- get방식으로 서버에 값 전달 할 때는 쿼리스트링 
					 post방식으로 서버에 값 전달 할 때는 form태그-->
				<td><a href="/detail?no=<%=i %>"><%=vo.getTitle() %></a></td>
			</tr>
			<%} %>
		</table>
	</div>
	
	
	
</body>
</html>