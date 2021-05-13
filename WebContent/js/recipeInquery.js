/**
 * 
 */

//화살표 증감 함수
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

//구매하기 버튼
function order() {
	alert('로그인이 되어있지 않으면 오류!');
	getOrder();
};

function getOrder() {
	var frm = document.getElementById("recipe_frm");
	frm.action="./orderInfoInquiry";
	frm.method="get";
	frm.submit();
}



//장바구니 버튼
function cart(email) {
	if(email == ""){ 
		alert("로그인이 필요합니다. 회원 가입 또는 로그인을 해주세요");
		var frm = document.getElementById("recipe_frm");
		frm.action="./loginUser";
		frm.method="get";
		frm.submit();
	} else {
		var frm = document.getElementById("recipe_frm");
		frm.action="./CartInfoRegister";
		frm.method="get";
		frm.submit();
	}
}
