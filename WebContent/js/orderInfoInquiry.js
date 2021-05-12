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
	var email = $("#userEmail").text();
	var address = $("#userAddress").text();
	
	if(chk) {
		$("#buyer_name").val(name); 
		$("#buyer_phone").val(phone); 
		$("#buyer_email").val(email); 
		$("#buyer_address").val(address); 
	}
	else {
		$("#buyer_name").val(''); 
		$("#buyer_phone").val(''); 
		$("#buyer_email").val(''); 
		$("#buyer_address").val(''); 
	}
});