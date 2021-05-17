<%@page import="ckd.member.vo.User"%>
<%@ page import="ckd.member.vo.Manager" %>
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
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%
    User user = (User)session.getAttribute("User");
	Manager manager = (Manager)session.getAttribute("Manager");
	Manager director = (Manager)session.getAttribute("Director"); 
%>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>

		<form id="recipe_frm">  <!-- [요리 대표이미지url, 밀키트명, 수량, 가격] form태그와 js이용해서 get방식으로 전송  -->
			<input type="hidden" name="recipeCode" value="${recipeInquery.recipeCode }">
			<input type="hidden" name="imgURL" value="${recipeInquery.recipeUrl }">
			<input type="hidden" name="mkName" value="${recipeInquery.recipeName }">
			
			<!-- name="mkNum" value="0"  98행에 있는거 읽어옴 -->
			<!-- name="total_price" value="0" 113행에 있는거 읽어옴-->
			
			<%
        	if (user == null && manager == null && director == null) {
        	String email = "";%>
        	<%} else if (user != null) {
        	String email = user.getEmail();%>
	        <%} else if (manager != null) {
	        String email = manager.getEmail();%>
	        <div class="modify_delete">
				<input id="recipe_removeBtn" type="button" value="삭제" onClick="window.location='<%=request.getContextPath() %>/reciperemove?recipeCode=${recipeInquery.recipeCode }'">
			</div>
	        <%} else if (director != null) {
	        String email = manager.getEmail();%>
	       	<div class="modify_delete">
				<input id="recipe_removeBtn" type="button" value="삭제" onClick="window.location='<%=request.getContextPath() %>/reciperemove?recipeCode=${recipeInquery.recipeCode }'">
			</div>
	        <%}%>
			


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
							<li>
								<a onclick="CopyUrlToClipboard()" id="urlBtn">url복사</a>						
							</li>
							<li><a onclick="like()"><i class="far fa-heart" id="heartOff"></i><i class="far fa-heart" id="heartOn"></i></a></li>
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
							<h2 style='margin-left:10px;'>${recipeInquery.recipeName }</h2>
						</span>
					</div>
					<div class="CountBtn">
	                    <span>
	                        <button type="button" class="CountBtn_up" onclick='count("minus")'>
	                            <i class="fas fa-minus"></i>
	                        </button>
	                        <input type="text" value="0" readonly class="CountBtn_number" id="CountBtn_result" name="mkNum">
	                        <button type="button" class="CountBtn_down" onclick='count("plus")'>
	                            <i class="fas fa-plus"></i>
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
								<td class="paybill_total_price">
									<div style="white-space:nowrap">
										<input type="text" value="0" readonly id="total_price" name="total_price" size="8" class="test" >
										<label for="total_price">원</label>
									</div>
								</td>
							</tr>
						</table>
					</div>
					<br>
	                <div>
	                    <button class="payBtn" id="order_btn" onClick="order('${email}');">바로 결제</button>
	                    <button class="payBtn" id="cart_btn" onClick="cart('${email}');">장바구니 담기</button>
	                </div>
				</div>
			</main>
		</div>
		<br>
		<br>
		<hr>
		<br>
		<br>
		
		
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
	

	<script src="js/recipeInquery.js"></script>
	<script src="https://kit.fontawesome.com/6a57affb8e.js" crossorigin="anonymous"></script>
</body>
</html>