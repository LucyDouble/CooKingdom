/**
 * 
 */
var cGroup = "";
var cDepth = 0;
 $("body").on("click", "[id^=cbtn-]", function(event) { 
	var cId = this.id;
	var c = document.getElementById(cId);
	var cParent = c.parentNode;
	var cGroupInput = cParent.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;
	cGroup = cGroupInput.value;
	//var cDepthInput = cParent.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling.previousSibling;
	cDepth = 1;
	console.log("들어왔음");
});

function goReview(){
	var commentContent = document.getElementById("commentInput").value;
	var email = document.getElementById("email").value;
	var recipeCode = document.getElementById("recipeCode").value;
	var commentGroup = cGroup;
	console.log(commentGroup);
	console.log(cDepth);
	 
	$.ajax({
		url: "commentRegister",
		type:"POST",
		data : {
			commentContent : commentContent,
			email : email,
			recipeCode : recipeCode,
			commentGroup : commentGroup,
			commentDepth : cDepth
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
