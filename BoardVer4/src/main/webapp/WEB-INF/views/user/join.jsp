<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JOIN</title>

<link href="/res/css/forAll.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>

<style>
input:focus {
	outline: none;
}

input:focus {
	color: black;
	border: purple solid 0.25px;
	border-radius: 0.25rem;
}

textarea {
	color: slateGray;
	border: slateGray solid 0.25px;
	border-radius: 0.25rem;
}

textarea:focus {
	outline: none;
}

textarea:focus {
	color: black;
	border: purple solid 0.25px;
	border-radius: 0.25rem;
}

.bodywrapper {
	display: flex;
	flex-direction: row;
}

.wrapper {
	display: flex;
	flex-direction: row;
	border: purple solid 0.25px;
	border-radius: 0.25rem;
	margin-right: 4rem;
}

.part1 {
	padding-left: 0.5rem;
	padding-right: 1rem;
}

.part2 {
	flex-grow: 1;
	background-color: lavender;
	color: purple;
	padding: 1rem;
}

.part3 {
	flex-grow: 3;
}
</style>


<script>
	function showIDCss(idCss, alarmCss, alarmHtml) {
		$('#user_Id').css("background-color", idCss);

		$('#alarmID').css("color", alarmCss);
		$('#alarmID').html(alarmHtml);
	}

	function firstIDMsg() {
		var id = $('#user_Id').val();
		if (id == "") {
			showIDCss("pink", "red", "아이디를 입력해주세요 >-<;");
		}
		$('#joinSubmit').prop("disabled", true);
		$('#joinSubmit').css("background-color", "grey");
		return;
	}

	function confirmId() {
		var id = $('#user_Id').val();
		var regExpId = new RegExp("^[a-z0-9]{4,8}$", "g");

		$.ajax({
			url : "/ajax/confirmId",
			type : "post",
			dataType : "json",
			data : {
				user_id : id
			},
			success : function(data) {
				if (data.result == '1') {
					showIDCss("pink", "red", "이미 사용되고 있는 아이디예요 >-<;");
					return;
				} else if (data.result == '0') {
					if (id == "") {
						showIDCss("pink", "red", "아이디를 입력해주세요 >-<;");
						return;
					} else if (regExpId.exec(id) === null) {
						showIDCss("pink", "red",
								"아이디는 4~8자의 영문소문자와 숫자로만 입력해주세요 >-<;");
						return;
					} else {
						showIDCss("lime", "green", "사용할 수 있는 아이디예요~^v^♡");
						}
					}
				}
			}
		});
	}

	function showPWCss(pwCss, cfPwCss, alarmCss, alarmHtml) {
		$('#user_Pw').css("background-color", pwCss);
		$('#confirmPw').css("background-color", cfPwCss);
		$('#alarmPW').css("color", alarmCss);
		$('#alarmPW').html(alarmHtml);
	}

	function firstPWMsg() {
		var pw = $('#user_Pw').val();
		if (pw == "") {
			showPWCss("pink", "", "red", "비밀번호를 입력해주세요 >-<;");
		}  
		$('#joinSubmit').prop("disabled", true);
		$('#joinSubmit').css("background-color", "grey");
	}
	
	function firstCFPWMsg() {
		var cfPw = $('#confirmPw').val();
		if (cfPw == "") {
			showPWCss("", "pink", "red", "비밀번호를 한번 더 입력해주세요 >-<;");
		}  
		$('#joinSubmit').prop("disabled", true);
		$('#joinSubmit').css("background-color", "grey");
	}

	function confirmPW() {
		var pw = $('#user_Pw').val();
		var regExpPw = new RegExp("^[a-zA-z0-9!@#$%^&*]{4,12}$", "g");

		if (pw == "") {
			showPWCss("pink", "", "red", "비밀번호를 입력해주세요 >-<;");
			return;
		} else if (regExpPw.exec(pw) === null) {
			showPWCss("pink", "", "red", "비밀번호는 4~12자의 영문대소문자, 숫자, 특수문자(!@#$%^&*)로만 입력해주세요 >-<;");
			return;
		} else {
			confirmALLPW();
		}
	}
	
	function confirmCFPW() {
		var cfPw = $('#confirmPw').val();
		var regExpPw = new RegExp("^[a-zA-z0-9!@#$%^&*]{4,12}$", "g");

		if (cfPw == "") {
			showPWCss("", "pink", "red", "비밀번호를 한번 더 입력해주세요 >-<;");
			return;
		} else if (regExpPw.exec(cfPw) === null) {
			showPWCss("", "pink", "red", "비밀번호 확인 또한 4~12자의 영문대소문자, 숫자, 특수문자(!@#$%^&*)로만 입력해주세요 >-<;");
			return;
		} else {
			confirmALLPW();
		}
	}
	
	function confirmALLPW() {
		var pw = $('#user_Pw').val();
		var cfPw = $('#confirmPw').val();
		if (pw != cfPw) {
			showPWCss("", "pink", "red", "비밀번호가 일치하지 않아요 >-<;");
			return;
		} else if (pw == cfPw) {
			showPWCss("lime", "lime", "green", "비밀번호가 일치 합니다~^^;");
		}
	}
	
	function showNMCss(nmCss, alarmCss, alarmHtml) {
		$('#user_Name').css("background-color", nmCss);

		$('#alarmNM').css("color", alarmCss);
		$('#alarmNM').html(alarmHtml);
	}

	function firstNMMsg() {
		var id = $('#user_Name').val();
		if (id == "") {
			showIDCss("pink", "red", "아이디를 입력해주세요 >-<;");
		}
		$('#joinSubmit').prop("disabled", true);
		$('#joinSubmit').css("background-color", "grey");
		return;
	}
	
	function firstNMMsg() {
		var nm = $('#user_Name').val();
		
	}
</script>

</head>
<body>
	<h2>JOIN</h2>

	<div class="bodywrapper">
		<div class="wrapper">
			<div class="part1">
				<div>
					<a href="/user/login"><button>로그인</button></a>
				</div>

				<c:if test="${param.msg eq 'noUser'}">
					<div class="msg">아마 회원가입 해야할 것 같죠~? ^^</div>
				</c:if>

				<form action="join" method="post">
					<div>
						<input type="text" name="user_Id" placeholder="아이디" id="user_Id"
							oninput="confirmId()" onclick="firstIDMsg()">
					</div>
					<div id="alarmID"></div>

					<div>
						<input type="password" name="user_Pw" placeholder="비밀번호"
							id="user_Pw" oninput="confirmPW()" onclick="firstPWMsg()">
					</div>
					<div id="alarmPW"></div>
					<div>
						<input type="password" name="confirmPw" placeholder="비밀번호 확인"
							id="confirmPw" oninput="confirmCFPW()" onclick="firstCFPWMsg()">
					</div>

					<div>
						<input type="text" name="user_Name" placeholder="이름"
							id="user_Name" oninput="nameCheck()" onclick="firstNMMsg()">
					</div>
					<div id="alarmNM"></div>
					
					<div>
						성별 : <label>남성<input type="radio" name="gender" value="0"
							checked></label> <label>여성<input type="radio"
							name="gender" value="1"></label>
					</div>
					<div>
						<input type="email" name="user_Email" placeholder="이메일"
							id="user_Email" oninput="confirmEmail()">
					</div>
					<div id="alarmEMAIL1"></div>
					<div id="alarmEMAIL2"></div>
					<button style="margin-right: 0.25rem" type="reset"
						onclick="doReset()">초기화</button>
					<button type="submit" id="joinSubmit" disabled="disabled">회원가입</button>
				</form>

			</div>

			<div class="part2">
				<div>
					주의~!
					<p>♡ 아이디, 이름, 성별은 수정이 불가입니당~^^ 이 점 유의하시며 작성해주세요~ ^^</p>
					<p>♡ 이메일은 아이디와 비밀번호 찾기에 이용됩니다~^^</p>
					<p>♡ 로그인에 성공하셔야 이메일 변경이 가능하오니 이 점 유의해주세요~^^</p>
					<p>♡ (이메일, 비밀번호 변경 가능)</p>
				</div>
			</div>
		</div>
		<div class="part3"></div>
	</div>
	<!-- JQuery의 prop함수는 
$("선택자").prop("속성");
$("선택자").prop("속성", "속성값");
$("선택자").prop({"속성":"속성값", "속성":"속성값", .... });

.prop() 메서드는 선택한 요소의 속성 값을 가져옵니다.
.prop() 메서드는 선택한 요소의 속성 값을 변경합니다.
.prop() 메서드는 선택한 요소의 여러개 속성 값을 변경합니다.
 -->
</body>
</html>