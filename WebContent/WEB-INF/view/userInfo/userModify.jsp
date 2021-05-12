<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/userModify.css?ver=1.0" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br>
	<br>
	<br>
	<h5 style="text-align: center;">사용자 정보수정</h5>
	<hr style="margin-bottom: 30px; width: 500px;">
	<form action="<%=request.getContextPath() %>/modifyUserInfo" method="POST">
		<table style="background-color: #ccc;">
			<tr>
				<td id="info">이메일</td>
				<td id="input"></td>
				<td id="input"><input type="text" name="email"></td>
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
				<td id="input"></td>
				<td id="input">
					
					<input type="password" name="pwd"><br><br>
					
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
		<input type="submit" value="정보수정" id="btn"> 
		<input type="button" value="회원탈퇴" id="btn">
	</form>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</body>
</html>