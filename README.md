# 5months_JSP


๐ <mark style='background-color: pink'>**๋ด๊ฐ ์๋ก ๊ตฌํํ ๊ธฐ๋ฅ `EMAIL` `$.AJAX` `์ค์๊ฐ ํ์๊ฐ์ ์ ํจ์ฑ ์ฒดํฌ` `alert, confirm์ฐฝ SWEETALEART ๋ผ์ด๋ธ๋ฌ๋ฆฌ ์ฌ์ฉ`**</mark>

---

๊ตญ๊ธฐ์ ์๋


https://github.com/sbsteacher/2021BoardVer1.git

https://github.com/sbsteacher/2021BoardVer4.git

https://github.com/sbsteacher/2021BoardVer7.git

BoardVer4 && 7์ค์~!

---

**์๋ก ๋ฐฐ์ด ๊ฒ๋ค**
```
- sweetalert
- template ํ๋ ๋ฒ
- <nav>ํ๊ทธ
- <jsp:include page="/WEB-INF/views/${page }.jsp"></jsp:include>
- onsubmit="return joinCheck();" 
  onsubmit="return false"์ผ ๋๋ form์ด submitํด๋ ์ ๋ action์คํ ์๋๋ค. ๋ฐ์ดํฐ๊ฐ ์๋ ๋ผ๊ฐ๋ค.
- document.querySelector('') : css์์ ํ๊ทธ ์ ํํ๋ ๋ฐฉ๋ฒ๊ณผ ๋๊ฐ๋ค.
  
-var joinForm = document.querySelector('#joinForm');
 var idElem = joinForm.user_Id; ๐ id ๋๋ name์ ๊ฐ์ด ์ผ์นํ๋ ๊ฒ์ผ๋ก ์ ๊ทผํ๋ค. id ๋๋ name์ ์ ์ผ๋ฉด ๋๋ค. 
  
- ๋ผ๋์ค ๋ฒํผ
  
- ์ ๊ท์ ๊ฒ์ฌ ์๊ณ ๋ฆฌ์ฆ
  var pw = pwElem.value;
	var pw2 = pw2Elem.value;
	var regExpPw = new RegExp("^[a-zA-z0-9!@#$%^&*]{4,12}$", "g");
	
	if (regExpPw.exec(pw) === null) {
		if (pw == '') {
			alert('๋น๋ฐ๋ฒํธ๋ฅผ ์์ฑํด์ฃผ์ธ์ >-<;;');
		} else if (pw2 == '') {
			alert('๋น๋ฐ๋ฒํธ ํ ๋ฒ ๋ ์์ฑํด์ฃผ์ธ์ >-<;;');
		} else {
			alert('๋น๋ฐ๋ฒํธ๋ ๋น๋ฐ๋ฒํธ๋ 4~12์์ ์๋ฌธ๋์๋ฌธ์, ์ซ์, ํน์๋ฌธ์(!@#$%^&*)๋ก๋ง ์๋ ฅํด์ฃผ์ธ์ >-<;;');
		} 
		return false;
	} else if (pw !== pw2) {
		alert('๋น๋ฐ๋ฒํธ๊ฐ ์๋ก ์ผ์นํ์ง ์์์ >-<;;');
		return false;
	}
	return false;
        
        
- include ํ  jsp์ css์ js ํ๊ทธ๋ฅผ ๋ฃ์ผ๋ฉด ๋๋ค. 
  <link href="/res/css/join.css" rel="stylesheet">

  <h1>JOIN</h1>
  
  <script defer src="/res/js/join.js"></script>
        
        
- ์๋ฐ์คํฌ๋ฆฝํธ ์ด๋ฒคํธ ๋ฐ์ธ๋ฉ 
  ํ๊ทธ์ onclick ์ด๋ฐ ๊ฑฐ ์์จ๋ ๋๋ค. ์ถ์ฒํ๋ ๋ฐฉ๋ฒ์ด ์๋๋ค. 
  idCheckElem.addEventListener(์ด๋ฒคํธ๋ช(click, submit ๋ฑ๋ฑ) , ํจ์);  
  var idCheckElem = joinForm.idCheck;
  idCheckElem.addEventListener('click', function() {});
        
- JSON > ๋ฌธ์์ด (๊ตฌ์กฐ๊ฐ ์๋) , ๋๋์ ๋ฐ์ดํฐ๋ฅผ ๋ณด๋ผ ๋ ๊ฐ์ฅ ํจ์จ์ ์ด๋ค. ์ฌ์ค ์์ฒญ๊ณผ ์๋ต์ ์ ๋ถ ์คํธ๋ง์ผ๋ก ๊ฐ๋๋ฐ ๊ตฌ์กฐ๊ฐ ์ด๋ฌ๋ฉด json์ด๊ณ  ์ ๋ฌ๋ฉด xml์ด๊ณ  ๊ทธ๋ฐ๊ฑฐ์.
        
- DTO (parameter), Domain(select ๊ฒฐ๊ณผ๋ฌผ), Entity(DB) -> VO ๋ ์ธ ๊ฐ๋ฅผ ํตํ์ด์ ๊ฐ์ด ์ฌ์ฉํ ๊ฒ.
  https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html
  ์คํ๋ง ํ  ๋ ์์ธํ ํ์. jspํ๋ก์ ํธ๋ vo๋ฅผ ์ฐ์. 

- java trim() ๋ฉ์๋
        
- java ajax response -> append๋ฅผ ์ฐ์ 
        PrintWriter out = response.getWriter(); out.append("<h1>์๋ํ์ธ์</h1>").append("<h1>๋ฐ๊ฐ์ต๋๋ค</h1>").append("<h1>๊ทธ๋ ์ต๋๋ค</h1>");
	
- ๊ฐ์ฒด๋ฅผ ๋งค๊ฐ๋ณ์๋ก ๋ณด๋์ ๋,
  ๊ทธ ๊ฐ์ฒด๋ฅผ ๋งค๊ฐ๋ณ์๋ก ๋ฐ์ ๋, ๊ทธ ๊ฐ์ฒด์ ๋ฉค๋ฒ ํ๋๋ก ๋ฐ์ ์ ์๋ค. {๊ฐ์ฒด์ ๋งค๊ฐ๋ณ์1, ๊ฐ์ฒด์ ๋งค๊ฐ๋ณ์2}
  
  modBtn.addEventListener('click', function() { openModModal(item); });
  function openModModal({icmt, cmt}) { 
  	console.log(icmt);
	console.log(cmt);
  }	
  
  ๋งค๊ฐ๋ณ์ item ๊ฐ์ฒด๋ฅผ ๋ฐ๋ ๋ฐ, ๊ทธ ๊ฐ์ฒด์ ๋ฉค๋ฒํ๋๋ฅผ ๋นผ์ ๋ฐ์ ์ ์๋ค.
  {๊ฐ์ฒด์ ๋งค๊ฐ๋ณ์1, ๊ฐ์ฒด์ ๋งค๊ฐ๋ณ์2}
  
 - ์ฌ์ง์ ์๋ก๋ ํ๋๋ฐ, ํ์ฌ์ฉ, ํ๋ํ์ ๋์ฉ, ๋๊ธ ๋ฌ ๋ ์ฉ์ผ๋ก ์ฌ๋ฌ ์ฉ๋์ ํฌ๊ธฐ์ ์ฌ์ง์ ์ ์ฅํ๋ค๋ฉด ์ฉ๋๋ง๋ค ํ์ด๋ธ์ ๋๋ ค์ผ ํ๋ค. 
 (๊ทผ๋ฐ ํ์ด๋ธ ํ๋์ ์ปฌ๋ผ์ ์ฌ๋ฌ๊ฐ ํ๋ฉด ๋๋ค ์๋๊ฐ????)
 profilImg VARCHAR(50) UNIQUE (NULLํ์ฉ)
- ๊ทธ๋ฆฌ๊ณ  ๊ณ์ ๋ณด์ด๋ ์ด๋ฏธ์ง๋ผ๋ฉด ์ธ์์ ๋ฃ์ด๋์ผ๋ฉด ์ข๋ค. ํ์ง๋ง ์ด๋ฏธ์ง ๋ณ๊ฒฝํ๋ฉด ์ธ์์ ์ด๋ฏธ๋ ์๋ฐ์ดํธ ํด์ค์ผ ํ๋ค. ๊ทธ๋ฐ ์์์ด ์์ด์ผ ํ๋ค. 

-๋ผ์ด๋ธ๋ฌ๋ฆฌ๊ฐ ์๋ค๋ฉด ๋ผ์ด๋ธ๋ฌ๋ฆฌ๋ฅผ ์ต๋ํ ์ด์ฉํ๋ ๊ฒ์ด ์ข๋ค.
servlets.com/cos/
  
```
