<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DETAIL</title>

<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<link href="/res/css/forAll.css" rel="stylesheet">
<script defer src="/res/js/forAll.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" integrity="sha512-iBBXm8fW90+nuLcSKlbmrPcLa0OT92xO1BIsZ+ywDWZCvqsWgccV3gFoRBv0z+8dLJgyAHIhR35VZc2oM/gI1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
<script src="https://code.jquery.com/jquery-3.5.1.js"
	integrity="sha256-QWo7LDvxbWT2tbbQ97B53yJnYU3WhH/C8ycbRAkjPDc="
	crossorigin="anonymous"></script>
	
<style>
.giveHeart {padding:0.25rem; margin:0.25rem; background-color:white; border: 0;}
.giveHeart:hover {color:purple; background-color:lavender; border: purple solid 0.25px; border-radius:0.25rem;}
</style>
<script>

function firstHeart() {
	var inputed = $('#iboard').val();
	 $.ajax({
			url : "/ajax/giveHeart"
			, type : "get"
			, dataType : "json"
			, data : {
				iboard : inputed
			}
			, success : function(data) {
				if (data.result=='1') {
					$('#giveHeart').css("color", "red");
					$('#giveHeart').html('<i class="fas fa-heartbeat"></i>');
					return;
				} else if (data.result=='0') {
					$('#giveHeart').css("color", "green");
					$('#giveHeart').html('<i class="fas fa-hand-holding-heart" id="myHeart" style="color:green" ></i>');
					return;
				}
			} 
			, error : function() {
				alert('서버 통신 실패');
			}
	 });
}


function giveHeart() {
	var inputed = $('#iboard').val();
	 $.ajax({
			url : "/ajax/giveHeart"
			, type : "post"
			, dataType : "json"
			, data : {
				iboard : inputed
			}
			, success : function(data) {
				if (data.result=='1') {
					$('#giveHeart').css("color", "red");
					$('#giveHeart').html('<i class="fas fa-heartbeat"></i>');
					return;
				} else if (data.result=='2') {
					$('#giveHeart').css("color", "green");
					$('#giveHeart').html('<i class="fas fa-hand-holding-heart" id="myHeart" style="color:green" ></i>');
					return;
				}
			} 
			, error : function() {
				alert('서버 통신 실패');
			}
	 });
}

</script>

</head>
<body onload="firstHeart()">
<h2>DETAIL</h2>
<div><span class="itsU">${vo.user_Name }(${vo.user_Id })</span>님의 ${yourListCount }개의 글 중 ${yourCount }번째 글</div>
<span class="content" >♡ ${vo.iboard }.</span>
<button onclick="giveHeart()" id="giveHeart" class="giveHeart"></button>
<input type="hidden" id="iboard" value="${vo.iboard }"> <br>
제목  <div class="content">${vo.title }</div>
내용  <div class="content">${vo.ctnt} </div>
작성일자  <div class="content">${vo.regdt }</div>

<c:if test="${vo.iuser eq loginUser.iUser && param.err eq null }">
	<button onclick="searchLogin('checkPw','detail',${vo.iboard })">글 수정</button>
	<button onclick="searchLogin('checkPw','detail',${vo.iboard })">글 삭제</button>
</c:if>

<c:if test="${vo.iuser eq loginUser.iUser && param.err eq 'done'}">
	<button onclick="moveModify(${vo.iboard })">글 수정</button>
	<button onclick="moveDel(${vo.iboard })">글 삭제</button>
</c:if>

<div>
	<form action="regCmt" method="post">
		<input type="hidden" name="iboard" value="${vo.iboard }">
		<div>
			<textarea name="cmt" placeholder="댓글" ></textarea>
			<button type="submit">등록</button>
		</div>
	</form>
</div>

<div><a class="record" href="list">게시판으로 가기</a></div>
	
</body>
</html>