<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/login.css?ver=1.0" rel="stylesheet" type="text/css">
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
		var email = document.getElementById("email");
		if (email.value == "") {
			document.getElementById("msg1").style.display = "block";
			alert("아이디를 입력하세요.");
		} else {
			document.getElementById("msg1").style.display = "none";
		}
		$.ajax({
			url: "loginUser",
			type: "POST",
			data: {
				email: $("#email").val(),
				pwd: $("#pwd").val()
			},
			dataType: "JSON",
			success: function(data) {
				console.log(data);
				console.log(data.result);
				console.log(data.email);
				if (data.result == "ok"){
					console.log("로그인 성공!!");
				} else {
					console.log("로그인 실패!!");
				}
			}
		})
	}
</script>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h5 style="text-align: center;">회원이신가요?</h5>
	<hr style="margin-bottom: 30px;">
	<form action="<%=request.getContextPath() %>/cookingDom" method="POST" 
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
		<div style="text-align: center;">
			<input type="submit" value="로그인" id="btn">
		</div>
	</form>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>