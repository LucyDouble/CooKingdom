/**
 * 
 */
var num = "";
$("body").on("click","[id^=mbtn-]", function(){
	document.getElementById("commentSubmit").style.display = "none";
	document.getElementById("commentModify").style.display = "inline-block";

	var vId = this.id;
	num = vId.split("mbtn-")[1];
	var content = "csub-"+num;
	var contentSelector = "#"+content;
	var commentContent = $(contentSelector).text();
	
	var commentInput = document.getElementById("commentInput");
	
	commentInput.value = commentContent;

});

$("#commentModify").click(function(){
	var commentInput = document.getElementById("commentInput");
	var commentContent = commentInput.value;
	console.log("commentContent : "+commentContent);
	
	$.ajax({
		url : "commentModify",
		type : "POST",
		data : {
			commentContent : commentContent,
			commentNo : num
		},
		success : function(){
			location.reload();
		}
	});
});