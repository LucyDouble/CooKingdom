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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
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
					<div>
						<span>
							<h2 style='margin-left:10px;'>${recipeInquery.recipeName }</h2>
						</span>
					</div>
					<div class="CountBtn">
	                    <span>
	                        <button type="button" class="CountBtn_up" onclick='count("plus")'>
	                            <i class="fas fa-plus"></i>
	                        </button>
	                        <input type="text" value="0" readonly class="CountBtn_number" id="CountBtn_result">
	                        <button type="button" class="CountBtn_down" onclick='count("minus")'>
	                            <i class="fas fa-minus"></i>
	                        </button>
	                    </span>
                	</div>
				
					<div class="paybill">
						<table class="paybill">
							<tr>
								<th>밀키트 가격</th>
								<td class="paybill_right" id="mealkit_price">10000원</td>
							</tr>
							<tr>
								<th class="paybill_total">총 주문 금액</th>
								<td class="paybill_total_price"><strong id="total_price">0원</strong></td>
							</tr>
						</table>
					</div>
					<br>
	                <div>
	                    <button class="payBtn" id="order_btn" onClick="location.href='<%=request.getContextPath() %>/orderInfoInquiry?email=kimttobi@ttobi.com'">바로 결제</button>
	                    <button class="payBtn" id="cart_btn" onClick="location.href='<%=request.getContextPath() %>/CartListInquiry'">장바구니 담기</button>
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
			<c:forEach items="${cookingStepInquery }" var="v">		
	        	<img src="${v.CookingImage }" alt="img">
	        	<p>${v.CookingDesc }</p>
			</c:forEach>
    	</div>
		<jsp:include page="../review/reviewListInquiry.jsp">
			<jsp:param name="recipeCode" value="${recipeInquery.recipeCode }" />
		</jsp:include>

		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	<script>
	function count(type)  {
		  // 결과를 표시할 element
		  const resultElement = document.getElementById('CountBtn_result');
		  const mealkitPrice = document.getElementById('mealkit_price');
		  const resultPrice = document.getElementById('total_price');
		  
		  // 현재 화면에 표시된 값
		  let number = resultElement.value;
		  
		  // 더하기/빼기
		  if(type === 'plus') {
		    number = parseInt(number) + 1;
		  }else if(type === 'minus')  {
			  if(resultElement.value> 0 ) {
				    number = parseInt(number) - 1;
			  }
		  }
		  
		  // 결과 출력
		  resultElement.value = number;
		  resultPrice.innerText = parseInt(mealkitPrice.innerText)*number + "원";
		  
		}
	</script>
	 <script src="https://kit.fontawesome.com/6a57affb8e.js" crossorigin="anonymous"></script>
</body>
</html>