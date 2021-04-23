<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립틀릿</title>
</head>
<body>

 이제는 더 이상 쓰이지 않는 스크립틀릿 입니다.

<br>
<br> 
<hr>
<br>
<br>
 
 <%
 	int a = 10;
 	int b = 20;
 	int c = a + b;
 	
 	out.print("<div>");
 	out.print(c+2);
 	out.print("</div>");
 %>
 
<br>
<br> 
<hr>
<br>
<br>
 
 <div><%=c+1 %></div>
 
 	<br>
	<br> 
	<hr>
	<br>
	<br> 
	
	<button onclick="location.href='index.jsp'">안녕하쎄용~</button>
 
</body>
</html>