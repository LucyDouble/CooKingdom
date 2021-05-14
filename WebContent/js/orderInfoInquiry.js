function defaultBtn() {
	var tabcontent = document.getElementsByClassName("tabcontent");
	var tablinks = document.getElementsByClassName("tablinks");
	tabcontent[0].style.display = "block";
	tablinks[0].style.display = "block";
	tablinks[0].className += " active";
};

defaultBtn();

function payoption(evt, payName) {
  	var i, tabcontent, tablinks;
  	tabcontent = document.getElementsByClassName("tabcontent");
  	
  	for (i = 0; i < tabcontent.length; i++) {
    	tabcontent[i].style.display = "none";
  	}
  	
  	tablinks = document.getElementsByClassName("tablinks");
  	
  	for (i = 0; i < tablinks.length; i++) {
    	tablinks[i].className = tablinks[i].className.replace(" active", "");
  	}
  	
  	document.getElementById(payName).style.display = "block";
  	
  	evt.currentTarget.className += " active";
};

// 배송정보 주문자 동일 체크박스
$("#check_orderer").click(function(){
	var chk = $(this).is(":checked");//.attr('checked');
	var name = $("#userName").text();
	var phone = $("#userPhone").text();
	var address = $("#userAddress").text();
	
	if(chk) {
		$("#buyer_name").val(name); 
		$("#buyer_phone").val(phone); 
		$("#buyer_address").val(address); 
	}
	else {
		$("#buyer_name").val(''); 
		$("#buyer_phone").val(''); 
		$("#buyer_address").val(''); 
	}
});

function sumPrice() {
	var i, orderPrice, sum, sumPrice, sumPriceShip, oTotal;
	orderPrice = document.getElementsByClassName("orderPrice");
	sum = 0;
	sumPrice = document.getElementById("sumPrice");
	sumPriceShip = document.getElementById("sumPriceShip");
	oTotal = document.getElementById("oTotal");
	
	for(i=0;i<orderPrice.length;i++ ) {
		sum += parseInt(orderPrice[i].innerText);
	}
	
	sumPrice.innerText = sum+'원';
	sumPriceShip.innerText = (sum+2500)+'원';
	oTotal.value = sum+2500;
};

sumPrice();


function orderRegister() {
	var frm = document.getElementById("orderInfo_frm");
	frm.action="./orderInfoRegister";
	frm.method="post";
	frm.submit();
};


