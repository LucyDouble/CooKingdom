
function searchPage(period, elmnt) {
	var i, pBtn, oBox;
	oBox = document.getElementsByClassName("orderListInquiry_box");
	for(i=0; i<oBox.length; i++) {
		oBox[i].style.display = "none";
	}
	
	pBtn = document.getElementsByClassName("periodBtn");
	for(i=0; i<pBtn.length; i++) {
		pBtn[i].style.backgroundColor = "";
		pBtn[i].style.color = "";
	}
	
	
	
	document.getElementById(period).style.display = "block";
	
	
	elmnt.style.backgroundColor = "#6E8C03";
	elmnt.style.color = "white";
	
//	sessionStorage.setItem("period", period ); 
	$.ajax({
		url: "orderListInquiryPeriod",
		type: "POST",
		dataType : "json",
		async : false,
		data : {
			period : period
		},
		success : function(data) {
			
			var orderList = data.orderList;
			console.log("orderList : " + orderList);
			console.log("orderList[0].orderDate : " + orderList[0].orderDate);
			
			var order = " ";
			$("#"+period+"").html(order);
			
			$.each(orderList, function(i, list){
				
				order = "<div class='eachbox'>";
				order += "<p>"+orderList[i].orderDate+"&nbsp;|&nbsp;주문번호 : " + orderList[i].orderCode +"</p>";
				order += "<div><table><tr><td><p><b>배송준비</b></p></td><td width='750'></td><td rowspan='2'><ul><li><button class='inboxBtn1'>배송정보수정</button></li><li><button class='inboxBtn2'>결제취소</button></li><li><button class='inboxBtn2' onclick='goReview()'>리뷰작성하기</button></li></ul></td></tr><tr height='100'>";
				order += "<td><img src='"+orderList[i].recipeUrl+"' width='100' /></td>"; //밀키트 이미지 나중에 추가
				order += "<td><ul><li class='product'>&nbsp;</li>";
				order += "<li class='product'>"+orderList[i].recipeName+"</li>"; // 밀키트 명 추가
				order += "<li class='product'>"+orderList[i].totalPrice +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+orderList[i].mealkitQty+"개</li>";
				order += "</ul></td></tr><tr><td></td><td></td><td style='text-align: right;'><strong style='cursor: pointer;'>&xvee;</strong></td></tr></table></div></div>";
				
				$("#"+period+"").append(order);
				
			});
			

			
		},
		error : function(e){
			alert(e.responseText);
		}
	});

	
};

document.getElementById("defaultOpen").click();



function goReview() {
	location.href="registerReview?recipeCode=3";

};