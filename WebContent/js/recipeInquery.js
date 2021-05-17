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
	
	currentMail = document.getElementById("email").value;
	
	if (currentMail == "null" ) {
		alert("로그인이 필요합니다. 회원 가입 또는 로그인을 해주세요");
		location.href="loginUser";
		return false;
	} else {
		var frm = document.getElementById("recipe_frm");
		frm.action="./orderInfoInquiry";
		frm.method="get";
		frm.submit();
	}
	
};

//장바구니 버튼
function cart(email) {
	var cntBtnValue = document.getElementById("CountBtn_result").value;
	if(email == ""){ 
		alert("로그인이 필요합니다. 회원 가입 또는 로그인을 해주세요");
		var frm = document.getElementById("recipe_frm");
		frm.action="./loginUser";
		frm.method="get";
		frm.submit();
	} else if(email == "" | cntBtnValue == 0) {
		alert("1개 이상 상품을 선택해주세요.");
		var frm = document.getElementById("recipe_frm");
		frm.action="./recipeinquery";
		frm.method="get";
		frm.submit();
	} else{
		var frm = document.getElementById("recipe_frm");
		frm.action="./cartRegister";
		frm.method="get";
		frm.submit();
	}
}


//url 복사
function CopyUrlToClipboard(){
	const t = document.createElement("textarea");
	document.body.appendChild(t);
	
	t.value = window.document.location.href; // 현재 URL 을 세팅해 줍니다.
	
	t.select();  // 해당 값이 선택되도록 select() 합니다

	document.execCommand("copy"); // 클립보드에 복사합니다.
	document.body.removeChild(t);


	alert("URL이 클립보드에 복사되었습니다"); 
}

//좋아요
function like (){
	var heart = document.getElementById("heartOn");
	var Bheart = document.getElementById("heartOff");
	if(heart.style.display == "none"){
		heart.style.display = "inline-block";	
		Bheart.style.display = "none";	
	}else{
		heart.style.display = "none";	
		Bheart.style.display = "inline-block";	
	}
	
}