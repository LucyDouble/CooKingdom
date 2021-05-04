<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/orderInfoInquiry.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<div class="wrapper">
		<div id="order">
			<jsp:include page="../main/header.jsp"></jsp:include>

			<div id="order_head1">
				<h2>주문결제</h2>
			</div>
			<hr id="bhr">
			<div id="order_head2">
				<strong>주문자정보</strong>
			</div>
			<hr>
			<table>
				<tr>
					<th>이름</th>
					<td>김또비</td>
				</tr>
				<tr>
					<th>휴대폰번호</th>
					<td>010-1234-5678</td>
				</tr>
				<tr>
					<th>이메일</th>
					<td>kimttobi@ttobi.com</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>서울특별시 중구 남대문로 120 대일빌딩 2F, 3F</td>
				</tr>
			</table>

			<hr id="bhr">
			<div id="order_head2">
				<strong>배송정보</strong> <input type="checkbox" id="check_orderer" /><label
					for="check_orderer"><span></span>주문자 정보와 동일</label>
			</div>
			<hr>

			<table>
				<tr>
					<th>이름</th>
					<td><input type="text" /></td>
				</tr>
				<tr>
					<th>휴대폰번호</th>
					<td><input type="text" size="30" /></td>
				</tr>
				<tr>
					<th>이메일</th>
					<td><input type="text" size="30" /></td>
				</tr>
				<tr>
					<th>주소</th>
					<td><input type="text" size="50" /></td>
				</tr>
			</table>

			<hr id="bhr">
			<div id="order_head2">
				<strong>주문상품</strong>
			</div>
			<hr>
			
			<table>
				<tr>
					<td>상품사진</td>
					<td>재료명1</td>
					<td>2개</td>
					<td>10,000원</td>
					
				</tr>
			
			</table>
			

			<jsp:include page="../main/footer.jsp"></jsp:include>
		</div>
	</div>
</body>
</html>