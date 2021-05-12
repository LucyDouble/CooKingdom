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
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>

		<form id="recipe_frm">
			<!-- [사용자email, 요리 대표이미지url, 밀키트명, 수량, 가격] form태그와 js이용해서 post로 전송  -->
			<input type="hidden" name="email" value="kimttobi@ttobi.com">
			<input type="hidden" name="imgURL"
				value="${recipeInquery.recipeUrl }"> <input type="hidden"
				name="mkName" value="${recipeInquery.recipeName }">
			<!-- name="mkNum" value="0"  98행에 있는거 읽어옴 -->
			<!-- name="total_price" value="0" 113행에 있는거 읽어옴-->


			<div id="recipeInquery">
				<header class="recipeInquery_header">
					<img src="${recipeInquery.recipeUrl }" alt="img">
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
								<li>${v.ingTypeName }: ${v.ingName } ${v.ingQty }</li>
							</c:forEach>
						</ul>
					</div>

					<div>
						<div>
							<span>
								<h2 style='margin-left: 10px;'>${recipeInquery.recipeName }</h2>
							</span>
						</div>
						<div class="CountBtn">
							<span>
								<button type="button" class="CountBtn_up"
									onclick='count("plus")'>
									<i class="fas fa-plus"></i>
								</button> <input type="text" value="0" readonly class="CountBtn_number"
								id="CountBtn_result" name="mkNum">
								<button type="button" class="CountBtn_down"
									onclick='count("minus")'>
									<i class="fas fa-minus"></i>
								</button>
							</span>
						</div>

						<div class="paybill">
							<table class="paybill">
								<tr>
									<th>밀키트 가격</th>
									<td class="paybill_right" id="mealkit_price">${recipeInquery.price }원</td>
								</tr>
								<tr>
									<th class="paybill_total">총 주문 금액</th>
									<td class="paybill_total_price"><input type="text"
										value="0" readonly id="total_price" name="total_price"></td>
								</tr>
							</table>
						</div>
						<br>
						<div>
							<button class="payBtn" id="order_btn" onClick="order();">바로
								결제</button>
							<button class="payBtn" id="cart_btn" onClick="cart();">장바구니
								담기</button>
						</div>
					</div>
				</main>
			</div>
			<br> <br>
			<hr>
			<br> <br>

			<c:forEach items="${cookingStepInquery }" var="v">
				<div class="recipeInquery_content">
					<img src="${v.cookingImage }" alt="img">
					<p>${v.cookingDesc }</p>
				</div>
			</c:forEach>

			<jsp:include page="../review/reviewListInquiry.jsp">
				<jsp:param name="recipeCode" value="${recipeInquery.recipeCode }" />
			</jsp:include>
		</form>

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
		  resultPrice.value = parseInt(mealkitPrice.innerText)*number;
	};
	
	function order() {
		var frm = document.getElementById("recipe_frm");
		frm.action="<%=request.getContextPath() %>/orderInfoInquiry";
		frm.method="post";
		frm.submit();
	};
	
	
	function cart() {
		var frm = document.getElementById("recipe_frm");
		frm.action="<%=request.getContextPath() %>/CartListInquiry";
		frm.method="post";
		frm.submit();
	}
	
	

	</script>
	<script src="https://kit.fontawesome.com/6a57affb8e.js"
		crossorigin="anonymous"></script>
</body>
</html>