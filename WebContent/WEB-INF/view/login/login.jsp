<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/login.css?ver=1.1" rel="stylesheet" type="text/css">
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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>
<script type="text/javascript">
	function login() {
		var email = document.getElementById("email").value;
		var pwd = document.getElementById("pwd").value;
		var flag = true;
		console.log(email.value);
		if (email == "") {
			console.log("아이디 입력되지 않음");
			document.getElementById("msg2").style.display = "none";
			document.getElementById("msg1").style.display = "block";
			return false;
		} else {
			console.log("아이디 입력되었음");
			document.getElementById("msg1").style.display = "none";
		}
		console.log("ajax 준비");
		$.ajax({
			type : "POST",
			url : "checkPwd",
			data : {
				email : email,
				pwd : pwd
			},
			dataType : "json",
			async: false,
			success : function(data) {
				console.log("success 진입");
				console.log(data);
				console.log(data.result);
				if (data.result == "fail") {
					console.log("유저 비밀번호 불일치");
					document.getElementById("msg1").style.display = "none";
					document.getElementById("msg2").style.display = "block";
					flag = false;
					console.log(flag);
				} else {
					console.log("유저 비밀번호 일치")
					document.getElementById("msg1").style.display = "none";
					document.getElementById("msg2").style.display = "none";
					flag = true;
					console.log(flag)
				}
			},
			error : function(error) {
				console.log("에러 발생!")
			}
		});
		console.log(flag);
		return flag;
	}
</script>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h5 style="text-align: center;">회원이신가요?</h5>
	<hr style="margin-bottom: 30px;">
	<form action="loginUser" method="POST" 
	style="text-align: center;" onsubmit="return login();">
		<div id="index">
			<p id="info">이메일</p>
			<input type="text" class="input" name="email" id="email">
		</div>
		<br>
		<div id="index">
			<p id="info">비밀번호</p>
			<input type="password" class="input" name="pwd" id="pwd">
		</div>
		<br>
		<div id="tag">
			<a href="inquiryDirector">책임자, </a>
			<a href="inquiryManager"> 관리자이신가요?</a><br>
		</div>
		<p id="msg1" style="color: red; display: none; margin-top: 0;">입력된 이메일이 없습니다.</p>
		<p id="msg2" style="color: red; display: none; margin-top: 0;">아이디 또는 비밀번호가 틀렸습니다.</p>
		<div style="text-align: center;">
			<input type="submit" value="로그인" id="btn">
		</div>
	</form>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>