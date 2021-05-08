/**
 * 
 */
/* 리뷰와 댓글 탭에 관한 EVENT*/
/*document.getElementById("rsubjs").onclick = function(){
    
    if(document.getElementById("review_content").style.display != "block"){
        document.getElementById("review_content").style.display = "block";
    }else{
        document.getElementById("review_content").style.display = "none";
    }
}
*/
var currentTab = document.getElementById("review");
currentTab.style.display="block";

/* 리뷰와 댓글 탭에 관한 function*/
function openCont(evt, cont) {
    // Declare all variables
    var i, tabcontent, tablinks;
 
    var currentTab = document.getElementById("review");
    currentTab.style.display="block";
    // Get all elements with class="tabcontent" and hide them
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
  
    // Get all elements with class="tablinks" and remove the class "active"
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
  
    // Show the current tab, and add an "active" class to the button that opened the tab  
    document.getElementById(cont).style.display = "block";
    evt.currentTarget.className += " active";
}

/*리뷰 내용이 보이고 안보이고~ */

 $("body").on("click", "[id^=rsub-]", function(event) {    
    var vId = this.id;
	var v = document.getElementById(vId);
	var vParent = v.parentNode.parentNode.parentNode.nextSibling.nextSibling;
	var pId = vParent.id;
	var p = document.getElementById(pId);
	var hit = v.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling.nextSibling;
	var rno = v.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;
	var rnoText = $(rno).text();
	console.log(rnoText);
	var rnoVal = $(rno).val();
	if(p.style.display === "block"){
		p.style.display = "none";
	}else {
		p.style.display = "block";
		
		$.ajax({
			url:"reviewHitUpdate",
			type:"POST",
			data: { reviewNo : rnoText},
			success: function(data){				
				$(hit).text(data);
			},
		});
		
	}
	
 });	
	
	
	
	















  