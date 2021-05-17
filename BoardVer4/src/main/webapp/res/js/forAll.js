function moveBack() { location.href="/user/login"; }

function searchLogin(str,from,iboard) {
	location.href='/searchLogin?err='+str+'&from='+from+'&iboard='+iboard;
	}
	
	
function moveModify(iboard) {location.href='mod?iboard='+iboard };

function moveDel(iboard) {
	swal({
     text: "정말 삭제 하시겠습니까?",
     buttons: ["NO", "YES"],
	}).then((YES) => {
     if (YES) {
		location.href='del?iboard='+iboard;
     } 
	});
	}

function moveWrite() {location.href='write';}

function moveLogout() {
	
	swal({
     text: "로그아웃 하시겠습니까?",
     buttons: ["NO", "YES"],
	}).then((YES) => {
     if (YES) {
		location.href='/user/logout';
     } 
	});
	
	/*
	var confirmLogout;
	confirmLogout = confirm('정말 로그아웃 하시겠습니까?');
	if (confirmLogout) {
		location.href='/user/logout';
		return;
	} 
	history.back();
	*/
}

function moveDetail(iboard) {location.href='detail?iboard='+iboard;}

function moveJoin() { location.href = '/user/join?msg=noUser'; }

function updateInfo() {location.href='updateInfo';}

function leaveEver() {
	swal({
     text: "정말 회원 탈퇴 하시겠습니까?",
     buttons: ["NO", "YES"],
	}).then((YES) => {
     if (YES) {
		location.href='leaveEver';
     } 
	});
}
