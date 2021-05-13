
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
}

document.getElementById("defaultOpen").click();
