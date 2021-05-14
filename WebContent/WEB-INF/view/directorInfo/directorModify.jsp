<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/managerModify.css?ver=1.0" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	//이메일 수정
	function updateEmail() {
		var flag = true;
		var email = document.getElementById("email").value;
		var newEmail = document.getElementById("newEmail").value;
		document.getElementById("msg1").style.display = "none";
		document.getElementById("msg2").style.display = "none";
		document.getElementById("msg3").style.display = "none";
		document.getElementById("msg4").style.display = "none";
		document.getElementById("msg5").style.display = "none";
		$.ajax({
			type : "POST",
			url : "modifyDirectorInfo",
			data : {
				email : email,
				newEmail : newEmail
			},
			dataType : "json",
			async : false,
			success : function(data) {
				console.log("success 진입");
				console.log(data);
				console.log(data.result);
				if (data.result == "fail") {
					console.log("관리자 정보 수정 실패");
					document.getElementById("msg1").style.display = "block";
					flag = false;
				} else {
					console.log("관리자 이메일 수정 성공");
					document.getElementById("msg2").style.display = "block";
					flag = true;
				}
			},
			error : function(error) {
				console.log("에러 발생!");
			}
		});
		console.log(flag);
		return flag;
	}
	// 이름 수정
	function updateName() {
		var flag = true;
		var email = document.getElementById("email").value;
		var newName = document.getElementById("newName").value;
		document.getElementById("msg1").style.display = "none";
		document.getElementById("msg2").style.display = "none";
		document.getElementById("msg3").style.display = "none";
		document.getElementById("msg4").style.display = "none";
		document.getElementById("msg5").style.display = "none";
		$.ajax({
			type : "POST",
			url : "modifyDirectorInfo",
			data : {
				email : email,
				newName : newName
			},
			dataType : "json",
			async : false,
			success : function(data) {
				console.log("success 진입");
				console.log(data);
				console.log(data.result);
				if (data.result == "fail") {
					console.log("관리자 정보 수정 실패");
					document.getElementById("msg1").style.display = "block";
					flag = false;
				} else {
					console.log("관리자 이름 수정 성공");
					document.getElementById("msg3").style.display = "block";
					flag = true;
				} 
			},
			error : function (error) {
				console.log("에러 발생!");
			}
		});
		console.log(flag);
		return flag;
	}
	// 핸드폰 번호 수정
	function updatePhone() {
		var flag = true;
		var email = document.getElementById("email").value;
		var newPhone = document.getElementById("newPhone").value;
		document.getElementById("msg1").style.display = "none";
		document.getElementById("msg2").style.display = "none";
		document.getElementById("msg3").style.display = "none";
		document.getElementById("msg4").style.display = "none";
		document.getElementById("msg5").style.display = "none";
		$.ajax({
			type : "POST",
			url : "modifyDirectorInfo",
			data : {
				email : email,
				newPhone : newPhone
			},
			dataType : "json",
			async : false,
			success : function(data) {
				console.log("success 진입");
				console.log(data);
				console.log(data.result);
				if (data.result == "fail") {
					console.log("관리자 정보 수정 실패");
					document.getElementById("msg1").style.display = "block";
					flag = false;
				} else {
					console.log("관리자 핸드폰 번호 수정 성공");
					document.getElementById("msg4").style.display = "block";
					flag = true;
				} 
			},
			error : function (error) {
				console.log("에러 발생!");
			}
		});
		console.log(flag);
		return flag;
	}
	// 비밀번호 수정
	function updatePwd() {
		var flag = true;
		var email = document.getElementById("email").value;
		var newPwd = document.getElementById("newPwd").value;
		document.getElementById("msg1").style.display = "none";
		document.getElementById("msg2").style.display = "none";
		document.getElementById("msg3").style.display = "none";
		document.getElementById("msg4").style.display = "none";
		document.getElementById("msg5").style.display = "none";
		$.ajax({
			type : "POST",
			url : "modifyDirectorInfo",
			data : {
				email : email,
				newPwd : newPwd
			},
			dataType : "json",
			async : false,
			success : function(data) {
				console.log("success 진입");
				console.log(data);
				console.log(data.result);
				if (data.result == "fail") {
					console.log("관리자 정보 수정 실패");
					document.getElementById("msg1").style.display = "block";
					flag = false;
				} else {
					console.log("관리자 비밀번호 수정 성공");
					document.getElementById("msg5").style.display = "block";
					flag = true;
				} 
			},
			error : function (error) {
				console.log("에러 발생!");
			}
		});
		console.log(flag);
		return flag;
	}
</script>
<body>
		<div id="form">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h5 style="text-align: center;">책임자 정보수정</h5>
	<hr style="margin-bottom: 30px; width: 500px;">
		<table style="border-collapse:collapse;">
			<tr id="tr">
				<td id="info">이메일</td>
				<td id="input"><input type="text" id="email" name="email" value="${Director.email }" readonly></td>
				<td id="input"><input type="text" class="text" id="newEmail" name="newEmail"></td>
				<td id="button"><button id="btn" onclick="updateEmail();">이메일 변경</button></td>				
			</tr>
			<tr id="tr">
				<td id="info">이름</td>
				<td id="input">${Director.name }</td>
				<td id="input"><input type="text" class="text" id="newName" name="newName"></td>
				<td id="button"><button id="btn" onclick="updateName();">이름 변경</button></td>			
			</tr>
			<tr id="tr">
				<td id="info">휴대폰 번호</td>
				<td id="input">${Director.phone }</td>
				<td id="input"><input type="text" class="text" id="newPhone" name="newPhone"></td>
				<td id="button"><button id="btn" onclick="updatePhone();">휴대폰 번호 변경</button>				
			</tr>
			<tr id="tr">
				<td id="info">비밀번호</td>
				<td id="input">${Director.pwd }</td>
				<td id="input"><input type="text" class="text" id="newPwd" name="newPwd"></td>
				<td id="button"><button id="btn" onclick="updatePwd();">비밀번호 변경</button></td>
			</tr>
			<tr id="tr">
				<td id="info">시리얼 번호</td>
				<td id="input">${Director.serial }</td>
				<td id="input"></td>
				<td id="button"></td>				
			</tr>	
		</table><br>
		<p id="msg1" style="color: red; display: none; margin-top: 0;">정보 수정을 실패했습니다.</p> 
		<p id="msg2" style="color: blue; display: none; margin-top: 0;">이메일 수정을 성공했습니다.</p> 
		<p id="msg3" style="color: blue; display: none; margin-top: 0;">이름 수정을 성공했습니다.</p> 
		<p id="msg4" style="color: blue; display: none; margin-top: 0;">휴대폰 번호 수정을 성공했습니다.</p> 
		<p id="msg5" style="color: blue; display: none; margin-top: 0;">비밀번호 수정을 성공했습니다.</p> 
		<input type="button" value="나가기" id="out">
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include></body>
</body>
</html>