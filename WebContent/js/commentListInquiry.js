/**
 * 
 */

$(document).load(function(){
	var recipeCode = document.getElementById("recipeCode").value; 
	
	$.ajax({
	
		url : "commentListInquiry",
		type : "POST",
		data : {
			recipeCode : recipeCode
		},
		success : function(){
			console.log("댓글전송 성공");
		}
		
	});
	
})