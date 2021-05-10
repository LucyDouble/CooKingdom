<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
	.recipeInquery_content {
  padding: 0 60px 0 60px;
  display: flex;
  justify-content: center;
}

.recipeInquery_content img {
  margin-bottom: 90px;
  width: 500px;
  height: 500px;
}

.recipeInquery_content p {
  margin: 0;
  padding: 0 0 0 70px;
  width: 900px;
  font-size: 25px;
  line-height: 70px;
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
                    <c:forEach items="${ingredientInquery }" var="v">
                    <li>${v.ingTypeName } : ${v.ingName }  ${v.ingQty }</li>
                    </c:forEach>
					</ul>
				</div>

				<div>
					<div class="CountBtn">
	                    <span>
	                        <button type="button" class="CountBtn_up">
	                            <i class="fas fa-plus"></i>
	                        </button>
	                        <input type="text" value="0" readonly class="CountBtn_number">
	                        <button type="button" class="CountBtn_down">
	                            <i class="fas fa-minus"></i>
	                        </button>
	                    </span>
                	</div>
				
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
		<br>
		<br>
		
		<div class="recipeInquery_content">
        	<img src="https://recipe1.ezmember.co.kr/cache/recipe/2016/07/11/ca42a85ed24dbb39add026e355ffd63b1.jpg" alt="">
        	<p>170도 기름에 잠깐 1차 튀겨줄거에요, 새우는 금방 익으니까 오래 튀길 필요는 없어요. 튀김옷을 한방울 넣었을때 하나 둘 셋.. 정도에 떠오르면 적당한 거에요.^^ 요렇게 살짝만 튀겨요... 튀김가루로 튀길때랑은 전혀 다른 느낌이 나거든요... 저는 전분가루로 튀긴 걸 참 좋아해요.</p>
    	</div>


		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	 <script src="https://kit.fontawesome.com/6a57affb8e.js" crossorigin="anonymous"></script>
</body>
</html>