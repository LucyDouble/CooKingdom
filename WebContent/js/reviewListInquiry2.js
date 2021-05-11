/**
 * 
 */
window.onload = function(){
	var recipeCode = document.getElementById("recipeCode").value;
	$.ajax({
		url:"reviewListInquiry",
		type:"POST",
		data: { 
			recipeCode : recipeCode
		},
		success: function(data){	
			console.log("됐다!!!");	
		}
	});
}



	















  