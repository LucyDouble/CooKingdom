<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#orderinfo {
	clear: both;
}
</style>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>
		<div id="orderinfo">
			<br> <br> <br> <br>
			<center>
				<h3>주문결제</h3>
			</center>
			<br> <br> <br> <br>
			<hr>
			<p>주문자정보</p>
			<hr>

		</div>
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</body>
</html>