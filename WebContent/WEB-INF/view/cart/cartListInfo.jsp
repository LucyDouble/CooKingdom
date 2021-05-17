<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/cartListInquiry.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
</head>

<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>
		<div id="cartTitle">
			<h1>장바구니</h1>
		</div>
		<div class="checkAll">
			<input type="checkbox" id="check_orderer" class="orderer_info" /> <label
				for="check_orderer"><span></span>전체 선택</label>
			<button onclick="" class="removeCheck">선택 삭제</button>
		</div>
		<div id="cartListInfo">
			<table>
				<tr>
					<td><input type="checkbox" id="check_cart" class="" /></td>
					<td width="100"><img src="${imgURL}" width="100" /></td>
					<td width="300">${mkName }</td>
					<td width="400">${mkNum }개</td>
					<td width="400" class="orderPrice">${total_price }원</td>
				</tr>
			</table>
		</div>
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</body>
</html>