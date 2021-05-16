/**
 * 
 */


function goReview(){
	var commentContent = document.getElementById("commentInput").value;
	var email = document.getElementById("email").value;
	var recipeCode = document.getElementById("recipeCode").value;

	if(commentContent == "" || commentContent == "null" ){
		alert("내용을 입력해주세요!");
		return;
	}
	
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
