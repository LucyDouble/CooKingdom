<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/userModify.css?ver=2.3" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<%@ page import="ckd.member.vo.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
	function checkInfo() {
		// 이메일 채우기
		console.log ("시작");
		var email = document.getElementById("email");
		if (email.value == "") {
			document.getElementById("msg1").style.display = "block";
			return false;
		} else {
			document.getElementById("msg1").style.display = "none";

		}
		// 비밀번호 채우기
		var pwd = document.getElementById("pwd");
		if (pwd.value == "") {
			document.getElementById("msg2").style.display = "block";
			return false;
		} else {
			document.getElementById("msg2").style.display = "none";
		} 
	}
</script>
<body>
	<div id="form">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h5 style="text-align: center;">사용자 정보수정</h5>
	<hr style="margin-bottom: 30px; width: 500px;">
		<table style="border-collapse:collapse; border: 1px solid #ccc">
			<tr id="tr">
				<td id="info">이메일</td>
				<td id="input"><input type="text" id="email" value="${User.email }" readonly></td>
				<td id="button"><button>이메일 변경</button></td>				
			</tr>
			<tr id="tr">
				<td id="info">이름</td>
				<td id="input">${User.name }</td>
				<td id="button"><button>이름 변경</button></td>			
			</tr>
			<tr id="tr">
				<td id="info">닉네임</td>
				<td id="input">${User.nickName }</td>
				<td id="button"><button>닉네임 변경</button></td>				
			</tr>
			<tr id="tr">
				<td id="info">생년월일</td>
				<td id="input">${User.birth }</td>	
				<td id="button"></td>			
			</tr>
			<tr id="tr">
				<td id="info">휴대폰 번호</td>
				<td id="input">${User.phone }</td>
				<td id="button"><button>휴대폰 번호 변경</button>				
			</tr>
			<tr id="tr">
				<td id="info">비밀번호 변경</td>
				<td id="input">${User.pwd }</td>
				<td id="button"><button>비밀번호 변경</button></td>
			</tr>
			<tr id="tr">
				<td id="info">주소</td>
				<td id="input">${User.address }</td>
				<td id="button"><button>주소 변경</button></td>				
			</tr>	
		</table><br>
		<p id="msg1" style="color: red; display: none; margin-top: 0;">이메일을 입력해주세요.</p> 
		<p id="msg2" style="color: red; display: none; margin-top: 0;">비밀번호를 입력해주세요.</p> 
		<input type="button" value="나가기" id="btn">
		</div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>