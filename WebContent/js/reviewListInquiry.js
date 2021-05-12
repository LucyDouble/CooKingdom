/**
 * 
 */
/* 리뷰와 댓글 탭에 관한 EVENT*/
var currentTab = document.getElementById("review");
currentTab.style.display="block";

/* 리뷰와 댓글 탭에 관한 function*/
function openCont(evt, cont) {
    var i, tabcontent, tablinks;
 
    var currentTab = document.getElementById("review");
    currentTab.style.display="block";

    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
  
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    document.getElementById(cont).style.display = "block";
    evt.currentTarget.className += " active";
}



/*리뷰 내용이 보이고 안보이고~ */

 $("body").on("click", "[id^=rsub-]", function(event) {    
    var vId = this.id;
	console.log("vId : "+ vId);
	var num = vId.split("rsub-")[1];
	console.log("num : "+ num);
	var content = "review_content-"+num;
	var contentSelector = "#"+content;
	//console.log("con : "+$("#"+content).css("display"));
	//var v = document.getElementById(vId);
	//var vParent = $(this).parent().parent().parent().next().next();
	//var pId = vParent.id;
	//var p = document.getElementById(pId);
	//var hit = $(v).next().next().next().next().next().next();
	//var rno = $(v).prev().prev().prev().prev().prev().prev();
	//var rnoText = $(rno).innerHTML;
	//var rnoVal = $(rno).innerText;
	//var hitTag = "#rev > div:nth-child("+num+") > table > tbody > tr > td.reviewTitle.rcnt > span";
	//var hit = document.getElementById("hitTag").text;
	//console.log("hitTag : "+hitTag);
	//console.log("hit : "+hit);
	
	
	if($(contentSelector).css("display") === "block"){
		$(contentSelector).css("display","none");
	}else {
		$(contentSelector).css("display","block");
		
		$.ajax({
			url:"reviewHitUpdate",
			type:"POST",
			data: { reviewNo : rnoText},
			success: function(data){				
				$(hit).text(data);
			}
	 });
		
}
	
 });	


	
	
	















  