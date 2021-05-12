<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/orderListInquiry.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문내역</title>
</head>
<body>
<div class="wrapper">

	<jsp:include page="../main/header.jsp"></jsp:include>
	
	<div class="order_head1">
			<h2>주문내역</h2>
	</div>
	
	<div class="orderListInquiry">
		<div class="orderListInquiry_period">
			<button class="periodBtn">오늘</button>
			<button class="periodBtn">1주일</button>
			<button class="periodBtn">1개월</button>
			<button class="periodBtn">6개월</button>
			<button class="periodBtn">전체</button>
		</div>
		<hr>
		<div class="orderListInquiry_box">
			<p>2021.04.25주문    |   주문번호 : 202101425-01234567
			<div>
				<p>배송준비</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="../main/footer.jsp"></jsp:include>
	
</div>
</body>
</html>