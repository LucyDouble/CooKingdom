<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/managerSignup.css?ver=1.2" rel="stylesheet"
	type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	function checkValue() {
		document.getElementById("msg4").style.display = "none";
		document.getElementById("msg5").style.display = "none";
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
		var pwdForm = /^(?=.*[a-zA-Z])(?=.*[^a-zA-Z0-9])(?=.*[0-9]).{8,16}$/;
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
	}
	// 중복 이메일 확인
	function checkEmail() {
		document.getElementById("msg1").style.display = "none";
		document.getElementById("msg2").style.display = "none";
		document.getElementById("msg3").style.display = "none";
		var email = document.getElementById("email").value;
		$.ajax({
			type : "POST",
			url : "checkDirectorInfo",
			data : {
				email : email
			},
			success : function(data) {
				if (data == "") {
					console.log("중복 없음!");
					document.getElementById("msg4").style.display = "none";
					document.getElementById("msg5").style.display = "block";
				} else {
					console.log("중복 있음!");
					document.getElementById("msg5").style.display = "none";
					document.getElementById("msg4").style.display = "block";
				}
			},
			error : function(error) {
				console.log("에러 발생!");
			}
		});
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
	<form action="<%=request.getContextPath()%>/inquiryDirector"
		method="POST" style="text-align: center;"
		onsubmit="return checkValue();">
		<div id="index">
			<p id="info">이메일</p>
			<input type="text" class="input" name="email" id="email"> 
			<input type="button" id="check" value="중복확인" onclick="checkEmail();">
		</div>
		<br>
		<div id="index">
			<p id="info">이름</p>
			<input type="text" class="input" name="name">
		</div>
		<br>
		<div id="index">
			<p id="info">비밀번호</p>
			<input type="password" class="input" name="pwd" id="pwd" placeholder="8~15자까지 영문, 숫자, 특수문자를 포함해서 입력해주세요.">
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
			<p id="info">시리얼 넘버</p>
			<input type="text" class="input" name="serial">
		</div>
		<br>
		<p id="msg1" style="color: red; display: none; margin-top: 0;">모든
			항목을 채워주세요.</p>
		<p id="msg2" style="color: red; display: none; margin-top: 0;">비밀번호
			양식에 맞게 입력해주세요.</p>
		<p id="msg3" style="color: red; display: none; margin-top: 0;">비밀번호가
			일치하지 않습니다. 다시 입력해주세요.</p>
		<p id="msg4" style="color: red; display: none; margin-top: 0;">중복되는
			이메일이 있습니다.</p>
		<p id="msg5" style="color: blue; display: none; margin-top: 0;">사용
			가능한 이메일 입니다.</p>
		<div style="text-align: center;">
			<input type="submit" value="회원가입" id="btn">
		</div>
	</form>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>