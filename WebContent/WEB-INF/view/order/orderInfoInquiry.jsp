<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/orderInfoInquiry.css" rel="stylesheet" type="text/css">
<%@ page import="ckd.member.vo.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 결제</title>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%
	User user = (User)session.getAttribute("User");
%>
	<div class="wrapper">

		<jsp:include page="../main/header.jsp"></jsp:include>
		
		<form id="orderInfo_frm">
		
		<div class="order_head1">
			<h2>주문결제</h2>
		</div>

		<div class="orderInfoInquiry">
			<div class="order_content">
				<hr id="bhr">
				<div id="order_head2">
					<strong>주문자정보</strong>
				</div>
				<hr>
				<table>
					<tr>
						<th>이름</th>
						<td id="userName"><%= user.getName() %></td>
					</tr>
					<tr>
						<th>휴대폰번호</th>
						<td id="userPhone"><%= user.getPhone() %></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%= user.getEmail() %></td>
					</tr>
					<tr>
						<th>주소</th>
						<td id="userAddress"><%= user.getAddress() %></td>
					</tr>
				</table>

				<hr id="bhr">
				<div class="order_head2">
					<strong>배송정보</strong> <input type="checkbox" id="check_orderer" class="orderer_info" /><label
						for="check_orderer"><span></span>주문자 정보와 동일</label>
				</div>
				<hr>

				<table>
					<tr>
						<th>이름</th>
						<td><input type="text" id="buyer_name" value="" name="sName"/></td>
					</tr>
					<tr>
						<th>휴대폰번호</th>
						<td><input type="text" size="30" id="buyer_phone" value="" name="sPhone"/></td>
					</tr>
					<tr>
						<th>이메일</th>
						<td><%= user.getEmail() %></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" size="50" id="buyer_address" value="" name="sAddress"/></td>
					</tr>
				</table>

				<hr id="bhr">
				<div class="order_head2">
					<strong>주문상품</strong>
				</div>
				<hr>
				
				<table>
<!--jstl 태그로 각 주문건 별로 밀키트 정보(이름 수량 등)/ hr태그 생성하도록 나중에 만들자 -->
					<tr>
						<td width="100"><img
							src="${imgURL }" alt="http://ipsumimage.appspot.com/100x100" width="100" /></td>
						<td width="300">${mkName }</td>
						<td width="400">${mkNum }개</td>
						<td width="400" class="orderPrice">${total_price }원</td>
					</tr>
<!--  				<tr>
						<td width="100"><img
							src="http://ipsumimage.appspot.com/100x100" /></td>
						<td width="300">밀키트명1</td>
						<td width="400">1개</td>
						<td width="400" class="orderPrice">20000원</td>
					</tr> -->	
				</table>
<!-- 			<hr>
				<table>
					<tr>
						<td width="100"><img
							src="http://ipsumimage.appspot.com/100x100" /></td>
						<td width="300">재료명2</td>
						<td width="400">3개</td>
						<td width="400" class="orderPrice">30000원</td>
					</tr>
				</table>  -->	

				<hr id="bhr">
				<div class="order_head2">
					<strong>결제방법</strong>
				</div>
				<hr>

				<div class="tab">
					<button class="tablinks" onclick="payoption(event, 'Card'); return false;">신용카드</button>
					<button class="tablinks" onclick="payoption(event, 'Transfer'); return false;">무통장입금</button>
				</div>

				<div id="Card" class="tabcontent">
					<table>
						<tr>
							<th>카드사
							</th>
							<td><select name="card" id="card">
									<option value="" disabled selected>카드사를 선택해주세요</option>
									<option value="kbcard">국민카드</option>
									<option value="shcard">신한카드</option>
									<option value="hanacard">하나카드</option>
									<option value="samsungcard">삼성카드</option>
							</select></td>
						</tr>
						<tr>
							<th>할부개월
							</th>
							<td><select name="montly" id="monthly">
									<option value="single">일시불</option>
									<option value="2month">2개월</option>
									<option value="3month">3개월</option>
									<option value="4month">4개월</option>
									<option value="5month">5개월</option>
									<option value="6month">6개월</option>
							</select></td>
						</tr>
					</table>
				</div>

				<div id="Transfer" class="tabcontent">
					<p>
						국민은행 : 33-3424-23232-2424<br> 예금주 : 김김이<br> 입금마감일 : 05월
						20일<br>
					</p>
				</div>

			</div>
			<div class="order_side">
				<div class="sticky-bar">
					개인정보 판매자 제공 동의
					<br><br>
					<textarea rows="4" cols="30" readonly>고객님께서는 아래 내용에 대하여 동의를 거부하실 수 있으며, 거부시 상품 배송, CS가 제한됩니다.
					개인정보를 제공받는 자 : [청곡]
					개인정보를 제공받는 자의 개인정보 이용 목적 : 주문상품의 배송, 고객상담 및 불만처리
					제공하는 개인정보의 항목 : 아이디(ID), 성명, 주소, 연락처(안심번호 적용 시 연락처는 제외), 개인통관고유부호(선택시), 공동현관 출입번호(입력,저장선택시)
					※ 구매자와 수취인이 다른 경우에는 입력하신 수취인의 정보가 제공될 수 있습니다.
					개인정보를 제공받는 자의 개인정보 보유 및 이용기간 : 구매확정 후 3개월까지
					</textarea>
					<br><br> 
					개인정보 수집 및 이용 동의 
					<br><br>
					<textarea rows="4" cols="30" readonly>고객님께서는 아래 내용에 대하여 동의를 거부하실 수 있으며, 거부 시 상품배송, 구매 및 결제, 일부 포인트 적립이 제한됩니다.
					</textarea>
					<br><br>
					<div class="paybill">
					<table class="paybill">
					<tr>
						<th>주문 금액</th>
						<td class="paybill_right" id="sumPrice">50,000원</td>
					</tr>
					<tr>
						<th>상품 할인 금액</th>
						<td class="paybill_right">0원</td>
					</tr>
					<tr>
						<th>배송비</th>
						<td class="paybill_right">2500원</td>
					</tr>
					<tr>
						<th class="paybill_total">총 주문 금액</th>
						<td class="paybill_total_price" id="sumPriceShip">
							<strong>52,500원</strong>
						</td>
					</tr>
					</table>
					</div>
					<br>
					<button class="payBtn" onClick="orderRegister();">결제하기</button>
				</div>
			</div>
		</div>
		<input type="hidden" name="oTotal" value="100" id="oTotal">
		<input type="hidden" name="recipeCode" value="${recipeCode}" >
		<input type="hidden" name="mkNum" value="${mkNum}" >
		</form>
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>

	<script src="js/orderInfoInquiry.js"></script>
</body>
</html>