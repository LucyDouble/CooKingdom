/**
 * 
 */

function goReview(){
	
	var commentContent = document.getElementById("commentInput").value;
	var email = document.getElementById("email").value;
	var recipeCode = document.getElementById("recipeCode").value;
	console.log("commentContent : "+commentContent);
	console.log("email : "+email);
	console.log("recipeCode : "+recipeCode);
	
	
	alert("댓글 등록 성공!");
	
	$.ajax({
		url: "commentRegister",
		type:"POST",
		data : {
			commentContent : commentContent,
			email : email,
			recipeCode : recipeCode
		},
		success : function(data){
			console.log("성공!");
			location.reload();
		},
		error : function(request, status, error){
			console.log("실패!");
		}
	});
}

var cGroup = "";

 $("body").on("click", "[id^=cbtn-]", function(event) { 
	var cId = this.id;
	var c = document.getElementById(cId);
	var cParent = c.parentNode;
	var cGroupInput = c.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;
	cGroup = cGroupInput.value;
	
});

function goReple(){
	var commentContent = document.getElementById("commentInput").value;
	var email = document.getElementById("email").value;
	var recipeCode = document.getElementById("recipeCode").value;
	var commentGroup = cGroup;
	
	$.ajax({
		url: "commentRegister",
		type:"POST",
		data : {
			commentContent : commentContent,
			email : email,
			recipeCode : recipeCode,
			commentGroup : commentGroup
		},
		success : function(data){
			console.log("성공!");
			location.reload();
		},
		error : function(request, status, error){
			console.log("실패!");
		}
	});
	
}
