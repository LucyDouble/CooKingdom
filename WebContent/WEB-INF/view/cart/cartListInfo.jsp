<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/cartListInquiry.css" rel="stylesheet" type="text/css">

<%@ page import="ckd.member.vo.User"%>
<%@ page import="ckd.cart.vo.Cart"%>
<%@ page import="ckd.cart.service.CartService"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
				<c:forEach items="${list}" var="cl">
					<tr>
						<td><input type="checkbox" id="check_cart" class="" /></td>
						<!-- 이미지  -->
						<td width="100"><img src="${cl.mealkitUrl}" width="100" /></td>
						<!-- 밀키트명  -->
						<td width="300">${cl.mealkit_name}</td>
						<!--  수량 -->
						<td width="400">${cl.mealkitQty}개</td>
						<!--  총 긍액 -->
						<td width="400" class="orderPrice">${cl.mealkit_price}원</td>
						<!--  삭제 -->
						<td><input type="button" class="btn" value="[장바구니에서 삭제]"
							>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</body>
</html>