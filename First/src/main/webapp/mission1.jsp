<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mission1</title>
</head>
<body>

 <%
 for (int i=1; i<11; i++) {
	 out.print("<div>");
	 out.print(i);
	 out.print("</div>");
 }
 %>
 
<br>
<br> 
<hr>
<br>
<br> 

<% for (int i=1; i<11; i++) {%>
<div><%=i %></div>
<%} %>

<br>
<br> 
<hr>
<br>
<br> 

<button onclick="location.href='index.jsp'">안녕하쎄용~</button>
</body>
</html>