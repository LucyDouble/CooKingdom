<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/managerModify.css?ver=1.2" rel="stylesheet" type="text/css">
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
		document.getElementById("msg6").style.display = "none";
		document.getElementById("msg7").style.display = "none";
		document.getElementById("msg8").style.display = "none";
		document.getElementById("msg9").style.display = "none";
		// 빈 칸 확인
		if (newEmail == "") {
			document.getElementById("msg8").style.display = "block";
			document.getElementById("newEmail").focus();
			return false;
		} else {
			document.getElementById("msg8").style.display = "none";
		}
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
		document.getElementById("msg6").style.display = "none";
		document.getElementById("msg7").style.display = "none";
		document.getElementById("msg8").style.display = "none";
		document.getElementById("msg9").style.display = "none";
		// 빈 칸 확인
		if (newName == "") {
			document.getElementById("msg8").style.display = "block";
			document.getElementById("newName").focus();
			return false;
		} else {
			document.getElementById("msg8").style.display = "none";
		}
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
		document.getElementById("msg6").style.display = "none";
		document.getElementById("msg7").style.display = "none";
		document.getElementById("msg8").style.display = "none";
		document.getElementById("msg9").style.display = "none";
		// 핸드폰 번호 양식
		var phone = document.getElementById("newPhone");
		var phoneForm = /^\d{3}-\d{3,4}-\d{4}$/; 
		if (!phoneForm.test(phone.value)) {
			document.getElementById("msg9").style.display = "block";
			return false;
		} else {
			document.getElementById("msg9").style.display = "none";
		}
		// 빈 칸 확인
		if (newPhone == "") {
			document.getElementById("msg8").style.display = "block";
			document.getElementById("newPhone").focus();
			return false;
		} else {
			document.getElementById("msg8").style.display = "none";
		}
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
		var rePwd = document.getElementById("rePwd").value;
		var pwdForm = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{8,16}$/;
		document.getElementById("msg1").style.display = "none";
		document.getElementById("msg2").style.display = "none";
		document.getElementById("msg3").style.display = "none";
		document.getElementById("msg4").style.display = "none";
		document.getElementById("msg5").style.display = "none";
		document.getElementById("msg6").style.display = "none";
		document.getElementById("msg7").style.display = "none";
		document.getElementById("msg8").style.display = "none";
		document.getElementById("msg9").style.display = "none";
		// 빈 칸 확인
		if (newPwd == "") {
			document.getElementById("msg8").style.display = "block";
			document.getElementById("newPwd").focus();
			return false;
		} else {
			document.getElementById("msg8").style.display = "none";
		}
		// 비밀번호 양식
		if (!pwdForm.test(newPwd)) {
			document.getElementById("msg7").style.display = "block";
			document.getElementById("newPwd").focus();
			return false;
		} else {
			document.getElementById("msg7").style.display = "none";
		}
		// 비밀번호 일치
		if (newPwd != rePwd) {
			document.getElementById("msg6").style.display = "block";
			document.getElementById("rePwd").focus();
			return false;
		} else {
			document.getElementById("msg6").style.display = "none";
		}
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
	// 회원 탈퇴
	function removeDirectorInfo() {
		var removeConfirm = confirm("회원탈퇴 하시겠습니까?");	
		if (removeConfirm == true) {
			document.form.submit();
		} else {
			return false;
		}
	}
</script>
<body>
<div class="wrapper">
	<div id="form">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h3 style="text-align: center;">책임자 정보수정</h3>
	<hr style="margin-bottom: 30px; width: 800px;">
	<form action="removeDirectorInfo" method="POST" onsubmit="return removeDirectorInfo();">
		<table style="border-collapse:collapse;">
			<tr id="tr">
				<td id="info">이메일</td>
				<td id="input"><input type="text" id="email" name="email" class="set" value="${Director.email }" readonly></td>
				<td id="input"></td>
				<td id="button"></td>				
			</tr>
			<tr id="tr">
				<td id="info">이름</td>
				<td id="input">${Director.name }</td>
				<td id="input"><input type="text" class="text" id="newName" name="newName"></td>
				<td id="button"><button type="button" id="btn" onclick="updateName();">이름 변경</button></td>			
			</tr>
			<tr id="tr">
				<td id="info">휴대폰 번호</td>
				<td id="input">${Director.phone }</td>
				<td id="input"><input type="text" class="text" id="newPhone" name="newPhone" placeholder="ex) 010-0000-0000"></td>
				<td id="button"><button type="button" id="btn" onclick="updatePhone();">휴대폰 번호 변경</button>				
			</tr>
			<tr id="tr">
				<td id="info">비밀번호</td>
				<td id="input"><input type="password" id="email" name="email" class="set" value="${Director.pwd }" readonly></td>
				<td id="input">
					<input type="password" class="text" id="newPwd" name="newPwd" placeholder="새 비밀번호"><br><br>
					<input type="password" class="text" id="rePwd" name="rePwd" placeholder="새 비밀번호 확인">
				</td>
				<td id="button"><button type="button" id="btn" onclick="updatePwd();">비밀번호 변경</button></td>
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
		<p id="msg6" style="color: red; display: none; margin-top: 0;">비밀번호가 일치하지 않습니다. 다시 입력해주세요.</p> 
		<p id="msg7" style="color: red; display: none; margin-top: 0;">8~15자까지 영문, 숫자, 특수문자를 포함해서 입력해주세요.</p> 
		<p id="msg8" style="color: red; display: none; margin-top: 0;">정보를 입력해주세요.</p>
		<p id="msg9" style="color: red; display: none; margin-top: 0;">핸드폰 번호 양식에 맞게 입력해주세요.</p>
		<input type="submit" value="회원탈퇴" id="out">
		<input type="button" value="나가기" id="out" onclick="location.href='index.jsp'">
	</form>
	</div>
	<jsp:include page="../main/footer.jsp"></jsp:include></body>
</div>
</body>
</html>