<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/userSignup.css?ver=1" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
v
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	function checkValue() {
		// 모든 항목 채우기
		var checkAll = document.getElementsByClassName("input");
		for (var i = 0; i < checkAll.length; i++) {
			if (checkAll[i].value == "") {
				document.getElementById("msg1").style.display = "block";
				checkAll[i].focus();
				return false;
			} else {
				document.getElementById("msg1").style.display = "none";
			}
		}
		// 비밀번호 양식
		var pwd = document.getElementById("pwd");
		var pwdForm = /^[A-Za-z0-9!@#$%^&*()_+-=]{8,15}$/;
		if (!pwdForm.test(pwd.value)) {
			document.getElementById("msg2").style.display = "block";
			pwd.focus();
			return false;
		} else {
			document.getElementById("msg2").style.display = "none";
		}
		// 비밀번호, 비밀번호 확인 일치
		var rePwd = document.getElementById("rePwd");
		if (pwd.value != rePwd.value) {
			document.getElementById("msg3").style.display = "block";
			rePwd.focus();
			return false;
		} else {
			document.getElementById("msg3").style.display = "none";
		}
		// 중복 이메일 확인
		
		userManagementService uService = new userManagementService();
		int result = uService.checkId(user);
		if (result != 0) {
			document.getElementById("msg4").style.display = "block";
		} else if (result == 1) {
			document.getElementById("msg4").style.display = "none";
		}
		
	}
</script>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h5 style="text-align: center;">회원가입</h5>
	<hr style="margin-bottom: 30px;">
	<form action="<%=request.getContextPath()%>/inquiryUser" method="POST"
		style="text-align: center;" onsubmit="return checkValue();">
		<div id="index">
			<p id="info">이메일</p>
			<input type="text" class="input" name="email">
		</div>
		<br>
		<div id="index">
			<p id="info">이름</p>
			<input type="text" class="input" name="name">
		</div>
		<br>
		<div id="index">
			<p id="info">닉네임</p>
			<input type="text" class="input" name="nickName">
		</div>
		<br>
		<div id="index">
			<p id="info">생년월일</p>
			<input type="text" class="input" name="birth">
		</div>
		<br>
		<div id="index">
			<p id="info">비밀번호</p>
			<input type="password" class="input" name="pwd" id="pwd">
		</div>
		<br>
		<div id="index">
			<p id="info">비밀번호 확인</p>
			<input type="password" class="input" name="rePwd" id="rePwd">
		</div>
		<br>
		<div id="index">
			<p id="info">휴대폰 번호</p>
			<input type="text" class="input" name="phone">
		</div>
		<br>
		<div id="index">
			<p id="info">주소</p>
			<input type="text" class="input" name="address">
		</div>
		<br>
		<p id="msg1" style="color: red; display: none; margin-top: 0;">모든 항목을 채워주세요.</p>
		<p id="msg2" style="color: red; display: none; margin-top: 0;">비밀번호 양식에 맞게 입력해주세요.</p>
		<p id="msg3" style="color: red; display: none; margin-top: 0;">비밀번호가 일치하지 않습니다. 다시 입력해주세요.</p>		
		<p id="msg4" style="color: red; display: none; margin-top: 0;">중복되는 이메일이 있습니다.</p>		
		<div style="text-align: center;">
			<input type="submit" value="회원가입" id="btn">
		</div>
	</form>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>