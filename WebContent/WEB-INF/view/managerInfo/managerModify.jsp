<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h5 style="text-align: center;">관리자 정보수정</h5>
	<hr style="margin-bottom: 30px; width: 500px;">
	<form action="#" method="POST">
		<table style="background-color: #ccc;">
			<tr>
				<td id="info">아이디</td>
				<td id="input"><input type="text"></td>
			</tr>
			<tr>
				<td id="info">이름</td>
				<td id="input"><input type="text"></td>
			</tr>
			<tr>
				<td id="info">휴대폰 번호</td>
				<td id="input"><input type="text"></td>
			</tr>
			<tr>
				<td id="info">비밀번호 변경</td>
				<td id="input"><input type="password"><br> <input
					type="password"><br> <input type="password"></td>
			</tr>
			<tr>
				<td id="info">시리얼 넘버(수정 불가)</td>
				<td id="input"><input type="text"></td>
			</tr>
		</table>
		<br> <input type="submit" value="정보수정" id="btn"> <input
			type="button" value="회원탈퇴" id="btn">
		</table>
	</form>
</body>
</html>