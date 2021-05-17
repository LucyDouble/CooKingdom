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
<script>
	function notYet() {
		alert("준비중입니다!");
	}

	function totalSum() {
		var sum = 0;
		var count = $("td[id=totalsum]").length;
		if (count == 0) {
			var noCart = "<div id='nocartDiv'>";
			noCart += "<span id='noCart'>" + "장바구니가 비었습니다.";
			noCart += "</span></div>";
			$("#cartListInfo").append(noCart);
		}
		
		for (var i = 0; i < count; i++) {
			sum += parseInt($("td[id=totalsum]")[i].textContent);
		}
		var sump = "<span id='sumPrice'>" + sum;
		sump += "<span id='won'>원</span></span>";
		$(".tpTitle").append(sump);
	}
</script>
</head>

<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>
		<div id="cartTitle">
			<h1>장바구니</h1>
		</div>
		<div class="checkAll">
			<!-- <input type="checkbox" id="check_orderer" class="orderer_info" /> <label
					for="check_orderer"><span></span>전체 선택</label>
				<button onclick="" class="removeCheck">선택 삭제</button> -->
			<table>
				<tr>
					<td width="120" class="cartOption">이미지</td>
					<td width="300" class="cartOption">상품명</td>
					<td width="400" class="cartOption">수량</td>
					<td width="400" class="cartOptionPrice">가격</td>
				</tr>
			</table>
		</div>
		<div id="cartListInfo">
			<table>
				<c:forEach items="${list}" var="cl">
					<tr>
						<!-- <td width="50"><input type="checkbox" id="check_orderer"
							/><img class="checkCart"></td> -->
						<!-- 이미지  -->
						<td width="120"><img src="${cl.mealkitUrl}" width="120"
							height="120" /></td>
						<!-- 밀키트명  -->
						<td width="300">${cl.mealkit_name}</td>
						<!--  수량 -->
						<td width="400">${cl.mealkitQty}개</td>
						<!--  총 긍액 -->
						<td width="400" class="orderPrice" id="totalsum">${cl.totalPrice}원</td>
						<!--  삭제 -->
						<td><button class="rvCart" onclick="notYet()">X</button>
					</tr>
					<tr>
						<td height="30"></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div class="ttPirce">
			<span class="tpTitle">총 금액</span>
			<script>
				totalSum();
			</script>
		</div>
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</body>
</html>