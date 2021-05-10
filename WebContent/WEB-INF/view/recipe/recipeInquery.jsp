<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/recipeInquery.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.paybill {
 	margin-top: 150px;
}
.payBtn {
	width: 120px;
}
</style>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>

		<div id="recipeInquery">
			<header class="recipeInquery_header">
				<img
					src="${recipeInquery.recipeUrl }"
					alt="img">
				<div>
					<span>${recipeInquery.recipeName }</span> <span>${recipeInquery.recipeInfo }</span>
				</div>
			</header>

			<nav class="recipeInquery_nav">
				<div>
					<ul>
						<li>${recipeInquery.recipeCag }</li>
						<li>${recipeInquery.typeCag }</li>
						<li>${recipeInquery.recipeQty }</li>
						<li>${recipeInquery.cookingTime }</li>
						<li>${recipeInquery.calorie }</li>
						<li>${recipeInquery.recipeLevel }</li>
					</ul>
					<ul>
						<li>url복사</li>
						<li><i class="far fa-heart"></i></li>
					</ul>
				</div>
			</nav>

			<main class="recipeInquery_main">
				<div>
					<ul>
                    <li><strong>필요 재료</strong></li>
                    <li>재료1</li>
					</ul>
				</div>

				<div>
					<div class="paybill">
						<table class="paybill">
							<tr>
								<th>주문 금액</th>
								<td class="paybill_right">50,000원</td>
							</tr>
							<tr>
								<th>상품 할인 금액</th>
								<td class="paybill_right">0원</td>
							</tr>
							<tr>
								<th>배송비</th>
								<td class="paybill_right">2,500원</td>
							</tr>
							<tr>
								<th class="paybill_total">총 주문 금액</th>
								<td class="paybill_total_price"><strong>52,500원</strong></td>
							</tr>
						</table>
					</div>
					<br>
	                <div>
	                    <button class="payBtn">바로 결제</button>
	                    <button class="payBtn">장바구니 담기</button>
	                </div>
				</div>
			</main>
		</div>
		<br>
		<br>
		<hr>
		
		



		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	 <script src="https://kit.fontawesome.com/6a57affb8e.js" crossorigin="anonymous"></script>
</body>
</html>