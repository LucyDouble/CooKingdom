<%@page import="ckd.userInfo.service.userManagementService"%>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/userSignup.css?ver=1.9" rel="stylesheet" type="text/css">
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
		function checkValue() {
			document.getElementById("msg4").style.display = "none";
			document.getElementById("msg5").style.display = "none";
			document.getElementById("msg6").style.display = "none";
			document.getElementById("msg7").style.display = "none";
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
			// 핸드폰 번호 양식
			var phone = document.getElementById("phone");
			var phoneForm = /^\d{3}-\d{3,4}-\d{4}$/; 
			if (!phoneForm.test(phone.value)) {
				document.getElementById("msg8").style.display = "block";
				return false;
			} else {
				document.getElementById("msg8").style.display = "none";
			}
		}
		// 중복 이메일 확인
		function checkEmail() {
			document.getElementById("msg1").style.display = "none";
			document.getElementById("msg2").style.display = "none";
			document.getElementById("msg3").style.display = "none";
			document.getElementById("msg6").style.display = "none";
			document.getElementById("msg7").style.display = "none";
			var email = document.getElementById("email").value;
			$.ajax({
				type : "POST",
				url : "checkUserInfo",
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
		// 중복 닉네임 확인
		function checkNickName() {
			document.getElementById("msg1").style.display = "none";
			document.getElementById("msg2").style.display = "none";
			document.getElementById("msg3").style.display = "none";
			document.getElementById("msg4").style.display = "none";
			document.getElementById("msg5").style.display = "none";
			var nickName = document.getElementById("nickName").value;
			$.ajax({
				type : "POST",
				url : "checkUserInfo.re",
				data : {
					nickName : nickName
				},
				success : function(data) {
					console.log("진입");
					if (data == "") {
						console.log("중복 없음!");
						document.getElementById("msg6").style.display = "none";
						document.getElementById("msg7").style.display = "block";						
					} else {
						console.log("중복 있음!");
						document.getElementById("msg7").style.display = "none";
						document.getElementById("msg6").style.display = "block";
					}
				},
				error : function(error) {
					console.log("에러 발생!");
				}
			})
		}
	</script>
<body>
<div class="wrapper">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h3 style="text-align: center;">회원가입</h3>
	<hr style="margin-bottom: 30px;">
	<form action="<%=request.getContextPath()%>/inquiryUser" method="POST"
		style="text-align: center;" onsubmit="return checkValue();">
		<div id="index">
			<p id="info">이메일</p>
			<input type="email" class="input" name="email" id="email"> 
			<input type="button" id="check" value="중복확인" onclick="checkEmail();">
		</div>
		<br>
		<div id="index">
			<p id="info">이름</p>
			<input type="text" class="input" name="name">
		</div>
		<br>
		<div id="index">
			<p id="info">닉네임</p>
			<input type="text" class="input" name="nickName" id="nickName">
			<input type="button" id="check" value="중복확인 " onclick="checkNickName();">
		</div>
		<br>
		<div id="index">
			<p id="info">생년월일</p>
			<input type="text" class="input" name="birth" placeholder="ex) 19961209">
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
			<input type="text" class="input" name="phone" id="phone" placeholder="ex) 010-0000-0000">
		</div>
		<br>
		<div id="index">
			<p id="info">주소</p>
			<input type="text" class="input" name="address">
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
		<p id="msg6" style="color: red; display: none; margin-top: 0;">중복되는
			닉네임이 있습니다.</p>
		<p id="msg7" style="color: blue; display: none; margin-top: 0;">사용
			가능한 닉네임 입니다.</p>
		<p id="msg8" style="color: red; display: none; margin-top: 0;">핸드폰 번호
			양식에 맞게 입력해주세요.</p>
		<div style="text-align: center;">
			<input type="submit" value="회원가입" id="btn">
		</div>
	</form>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</div>
</body>
</html>