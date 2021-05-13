<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/userModify.css?ver=1.2" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
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
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h5 style="text-align: center;">사용자 정보수정</h5>
	<hr style="margin-bottom: 30px; width: 500px;">
	<form action="<%=request.getContextPath() %>/modifyUserInfo" method="POST" onsubmit="return checkInfo();">
		<table style="background-color: #ccc;">
			<tr>
			<td id="info">사용자 정보</td>
			<td id="user">현재 정보</td>
			<td id="user">수정 정보</td>
			</tr>
			<tr>
				<td id="info">이메일</td>
				<td id="input"><input type="text" name="email" id="email"></td>
				<td id="input"><input type="text" name="newEmail"></td>
			</tr>
			<tr>
				<td id="info">이름</td>
				<td id="input"></td>
				<td id="input"><input type="text" name="name"></td>
			</tr>
			<tr>
				<td id="info">닉네임</td>
				<td id="input"></td>
				<td id="input"><input type="text" name="nickName"></td>
			</tr>
			<tr>
				<td id="info">생년월일</td>
				<td id="input"></td>
				<td id="input"><input type="text" name="birth"></td>
			</tr>
			<tr>
				<td id="info">휴대폰 번호</td>
				<td id="input"></td>
				<td id="input"><input type="text" name="phone"></td>
			</tr>
			<tr>
				<td id="info">비밀번호 변경</td>
				<td id="input"><input type="password" name="pwd" id="pwd"></td>
				<td id="input">
					<input type="password" name="newPwd"><br><br>
					<input type="password" name="rePwd">
				</td>
			</tr>
			<tr>
				<td id="info">주소</td>
				<td id="input"></td>
				<td id="input"><input type="text" name="address"></td>
			</tr>	
		</table><br>
		<p id="msg1" style="color: red; display: none; margin-top: 0;">이메일을 입력해주세요.</p> 
		<p id="msg2" style="color: red; display: none; margin-top: 0;">비밀번호를 입력해주세요.</p> 
		<input type="submit" value="정보수정" id="btn"> 
		<input type="button" value="회원탈퇴" id="btn">
	</form>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>