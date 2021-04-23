<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바스크립트</title>
</head>
<body>
	<div>
		<input type="number" id="num1"> <!-- type이 number이라도 값이 int형이 아니다. String형이다. --> 
		<input type="text" id="num2">
		<button onclick="sum()">더하기</button>
		<button onclick="minus()">빼기</button>
	</div>
	
	<div>
		<input type="text" id="result">
	</div>
	
	<br>
	<br> 
	<hr>
	<br>
	<br> 
	
	<button onclick="location.href='index.jsp'">안녕하쎄용~</button>
	
	
	
	<script>
		//html에서는 정수개념없고, 텍스트 개념밖에 없다. 
		//그래서 html에서 값을 가져오면 무조건 String type이다. 
		
		var num1Elem = document.getElementById('num1');
		var num2Elem = document.querySelector('#num2'); //querySelector 를 더 추천
		var resultElem = document.querySelector('#result');
		
		function sum() { 
			var num1 = num1Elem.value;
			console.log('num1 : %s', num1);
			
			var num2 = num2Elem.value;
			console.log('num2 : %s', num2);
			
			resultElem.value = parseInt(num1) + Number(num2);
		}
		
		function minus() { 
			var num1 = num1Elem.value;
			console.log('num1 : %s', num1);
			
			var num2 = num2Elem.value;
			console.log('num2 : %s', num2);
			
			resultElem.value = parseInt(num1) - Number(num2);
		}
	</script>
</body>
</html>