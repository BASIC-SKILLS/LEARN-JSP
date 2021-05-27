# 5months_JSP


🌟 <mark style='background-color: pink'>**내가 새로 구현한 기능 `EMAIL` `$.AJAX` `실시간 회원가입 유효성 체크` `alert, confirm창 SWEETALEART 라이브러리 사용`**</mark>

---

국기선생님


https://github.com/sbsteacher/2021BoardVer1.git

https://github.com/sbsteacher/2021BoardVer4.git

https://github.com/sbsteacher/2021BoardVer7.git

BoardVer4 && 7중요~!

---

**새로 배운 것들**
```
- sweetalert
- template 하는 법
- <nav>태그
- <jsp:include page="/WEB-INF/views/${page }.jsp"></jsp:include>
- onsubmit="return joinCheck();" 
  onsubmit="return false"일 때는 form이 submit해도 절대 action실행 안된다. 데이터가 안날라간다.
- document.querySelector('') : css에서 태그 선택하는 방법과 똑같다.
  
-var joinForm = document.querySelector('#joinForm');
 var idElem = joinForm.user_Id; 👉 id 또는 name의 값이 일치하는 것으로 접근한다. id 또는 name을 적으면 된다. 
  
- 라디오 버튼
  
- 정규식 검사 알고리즘
  var pw = pwElem.value;
	var pw2 = pw2Elem.value;
	var regExpPw = new RegExp("^[a-zA-z0-9!@#$%^&*]{4,12}$", "g");
	
	if (regExpPw.exec(pw) === null) {
		if (pw == '') {
			alert('비밀번호를 작성해주세요 >-<;;');
		} else if (pw2 == '') {
			alert('비밀번호 한 번 더 작성해주세요 >-<;;');
		} else {
			alert('비밀번호는 비밀번호는 4~12자의 영문대소문자, 숫자, 특수문자(!@#$%^&*)로만 입력해주세요 >-<;;');
		} 
		return false;
	} else if (pw !== pw2) {
		alert('비밀번호가 서로 일치하지 않아요 >-<;;');
		return false;
	}
	return false;
        
        
- include 할 jsp에 css와 js 태그를 넣으면 된다. 
  <link href="/res/css/join.css" rel="stylesheet">

  <h1>JOIN</h1>
  
  <script defer src="/res/js/join.js"></script>
        
        
- 자바스크립트 이벤트 바인딩 
  태그에 onclick 이런 거 안써도 된다. 추천하는 방법이 아니다. 
  idCheckElem.addEventListener(이벤트명(click, submit 등등) , 함수);  
  var idCheckElem = joinForm.idCheck;
  idCheckElem.addEventListener('click', function() {});
        
- JSON > 문자열 (구조가 있는) , 대량의 데이터를 보낼 때 가장 효율적이다. 사실 요청과 응답은 전부 스트링으로 가는데 구조가 이러면 json이고 저러면 xml이고 그런거임.
        
- DTO (parameter), Domain(select 결과물), Entity(DB) -> VO 는 세 개를 통틀어서 같이 사용한 것.
  https://gmlwjd9405.github.io/2018/12/25/difference-dao-dto-entity.html
  스프링 할 때 자세히 하자. jsp프로젝트는 vo를 쓰자. 

- java trim() 메소드
        
- java ajax response -> append를 쓰자 
        PrintWriter out = response.getWriter(); out.append("<h1>안녕하세요</h1>").append("<h1>반갑습니다</h1>").append("<h1>그렇습니다</h1>");
	
- 객체를 매개변수로 보냈을 때,
  그 객체를 매개변수로 받을 때, 그 객체의 멤버 필드로 받을 수 있다. {객체의 매개변수1, 객체의 매개변수2}
  
  modBtn.addEventListener('click', function() { openModModal(item); });
  function openModModal({icmt, cmt}) { 
  	console.log(icmt);
	console.log(cmt);
  }	
  
  매개변수 item 객체를 받는 데, 그 객체의 멤버필드를 빼서 받을 수 있다.
  {객체의 매개변수1, 객체의 매개변수2}
  
 - 사진을 업로드 하는데, 프사용, 확대했을 때용, 댓글 달 때 용으로 여러 용도의 크기의 사진을 저장한다면 용도마다 테이블을 늘려야 한다. 
 (근데 테이블 하나에 컬럼을 여러개 하면 된다 아니가????)
 profilImg VARCHAR(50) UNIQUE (NULL허용)
- 그리고 계속 보이는 이미지라면 세션에 넣어놓으면 좋다. 하지만 이미지 변경하면 세션의 이미도 업데이트 해줘야 한다. 그런 작업이 있어야 한다. 
  
```
