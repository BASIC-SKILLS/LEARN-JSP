var joinForm = document.querySelector('#joinForm');
var idElem = joinForm.user_Id;
var pwElem = joinForm.user_Pw;
var pw2Elem = joinForm.pw2;
var nmElem = joinForm.user_Name;

//아이디 중복체크
var idBtnElem = joinForm.idBtn;
idBtnElem.addEventListener('click', function() {
	ajaxId(idElem.value);
});

//Ajax msg
var msgIdElem = joinForm.querySelector('#msgId');

function ajaxId(id) {
	if (!idCheck(id)) {
		return;
	}
	fetch('/ajax/id?user_Id='+id)
	.then(function(res) {
		return res.json();
	})
	.then(function(myJson) {
		console.log(myJson);
		switch(myJson.result) {
			case 0: msgIdElem.innerText = '사용할 수 있는 아이디예요~^^'; break;
			case 1: msgIdElem.innerText = '이 아이디는 이미 사용중이예요 >-<;;'; break;
		}
	})
}

function idCheck(id) {
	var regExpId = new RegExp("^[a-z0-9]{4,8}$", "g");
	if (regExpId.exec(id) === null) {
		if (id == '') {
			alert('아이디를 작성해주세요 >-<;;');
		}
		 else  {
			alert('아이디는 4~8자의 영문소문자와 숫자로만 입력해주세요 >-<;;');
		}
		return false;
	}
	return true;
}

//submit : 이상이 있으면 return false;
function joinCheck() {
	
	if (!idCheck(idElem.value)) {
		return false;
	}
	
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
	
	
	var name = nmElem.value;
	var regExpNm = new RegExp("^[가-힣]{2,5}$", "g");
	if (regExpNm.exec(name) === null) {
		if (name == '') {
			alert('이름을 작성해주세요 >-<;;');
		}
		 else  {
			alert('이름은 2~5자의 한글로만 입력해주세요 >-<;;');
		}
		return false;
	}
	return true;
}

