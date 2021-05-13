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
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<div class="wrapper">

	<jsp:include page="../main/header.jsp"></jsp:include>
	
	<div class="order_head1">
			<h2>주문내역</h2>
	</div>
	
	<div class="orderListInquiry">
		<div class="orderListInquiry_period">
			<button class="periodBtn" onclick="searchPage('today', this)" id="defaultOpen">오늘</button>
			<button class="periodBtn" onclick="searchPage('week', this)">1주일</button>
			<button class="periodBtn" onclick="searchPage('month', this)">1개월</button>
			<button class="periodBtn" onclick="searchPage('half', this)">6개월</button>
			<button class="periodBtn" onclick="searchPage('whole', this)">전체</button>
		</div>
		
		<hr>
		
		<div id="today" class="orderListInquiry_box">
			<div class="eachbox">
				<p> 오늘 주문건    |   주문번호 : 202101425-01234567
				<div>
					<table>
						<tr>
							<td><p><b>배송준비</b></p></td>
							<td width="750"></td>
							<td rowspan="2">
								<ul>
									<li><button class="inboxBtn1">배송정보수정</button></li>
									<li><button class="inboxBtn2">결제 취소</button></li>
									<li><button class="inboxBtn2">리뷰 작성하기</button></li>
								</ul>
							</td>
						</tr>
						<tr height ="100">
							<td><img src="http://ipsumimage.appspot.com/100x100" /></td>
							<td>
								<ul>
									<li class="product">&nbsp;</li>
									<li class="product">밀키트명1</li>
									<li class="product">10,000원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1개</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td style="text-align: right"><strong>&xvee;</strong></td>
						</tr>
					</table>
				</div>
			</div>
			<div class="eachbox">
				<p> 오늘 2번째 주문건    |   주문번호 : 202101425-01234567
				<div>
					<table>
						<tr>
							<td><p><b>배송준비</b></p></td>
							<td width="750"></td>
							<td rowspan="2">
								<ul>
									<li><button class="inboxBtn1">배송정보수정</button></li>
									<li><button class="inboxBtn2">결제 취소</button></li>
									<li><button class="inboxBtn2">리뷰 작성하기</button></li>
								</ul>
							</td>
						</tr>
						<tr height ="100">
							<td><img src="http://ipsumimage.appspot.com/100x100" /></td>
							<td>
								<ul>
									<li class="product">&nbsp;</li>
									<li class="product">밀키트명2</li>
									<li class="product">20,000원&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;3개</li>
								</ul>
							</td>
						</tr>
						<tr>
							<td></td>
							<td></td>
							<td style="text-align: right"><strong>&xwedge;</strong></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		<div id="week" class="orderListInquiry_box">
			<p> 일주일 주문건    |   주문번호 : 202101425-01234567
			<div>
				<p>배송준비</p>
			</div>
		</div>
		
		<div id="month" class="orderListInquiry_box">
			<p> 한달 주문건    |   주문번호 : 202101425-01234567
			<div>
				<p>배송준비</p>
			</div>
		</div>
		
		<div id="half" class="orderListInquiry_box">
			<p> 6개월 주문건    |   주문번호 : 202101425-01234567
			<div>
				<p>배송준비</p>
			</div>
		</div>
		
		<div id="whole" class="orderListInquiry_box">
			<p> 전체 주문건    |   주문번호 : 202101425-01234567
			<div>
				<p>배송준비</p>
			</div>
		</div>
	</div>
	
	<jsp:include page="../main/footer.jsp"></jsp:include>
	
</div>
<script src="js/orderListInquiry.js"></script>
</body>
</html>