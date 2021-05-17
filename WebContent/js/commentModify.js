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
	
	if(commentContent == "" || commentContent == "null" ){
		alert("내용을 입력해주세요!");
		return;
	}
	
	$.ajax({
		url : "commentModify",
		type : "POST",
		data : {
			commentContent : commentContent,
			commentNo : num
		},
		success : function(){
		commentInput.value = "";
		$.ajax({
		url:"commentListInquiry",
		type:"POST",
		dataType : "json",
		async : false,
		data: { 
			recipeCode : recipeCode
		},
		success : function(data){
			
			commentInput.value = "";
	
			var commentList = data.commentList;
			var cv = "";
			
			$("#cmt").empty();
			
			if(commentList == null || data.cnt == 0){
				cv = "<p>첫번째 댓글을 작성해 보세요!</p>";
				$("#cmt").append(cv);
			}
			
			
			if (currentMail == "null" ) {
				cv = "<p>로그인 후 확인이 가능합니다.</p>";
				$("#cmt").append(cv);
			}
			
			$("#cmt").empty();
			
			
			if(currentMail != null && currentMail != "null"){
				$.each(commentList, function(i,list){
					cv += "<div class='comment_Inq' style='display:none;'>";
					cv += "<input type='hidden' name='commentNo' value='"+commentList[i].commentNo+"' />";
					cv += "<table><tr>";
					cv += "<td class='cwriter'>"+commentList[i].nickname+"</td>";
					cv += "<td class='csub' id='csub-"+commentList[i].commentNo+"'>"+commentList[i].commentContent+"</td>";
					cv += "<td class='cdate'>"+commentList[i].commentDate+"</td>";
					cv += "</tr></table>";
					if(currentMail == commentList[i].email){
					cv += "<div class='commentBtn'>";
					cv += "<button type='button' class='cbtn' id='mbtn-"+commentList[i].commentNo+"'>수정</button>";
					cv += "<button type='button' class='cbtn' id='cbtn-"+commentList[i].commentNo+"'>삭제</button>";
					cv += "</div>";
					}
					cv += "</div>";					
				});
				
			}
			
			$("#cmt").append(cv);
				
			$("#moreDiv").empty();
			var morebtn = "<a id='moreBtn'>더보기(more)</a>";
				
			if(currentMail != null && data.cnt > 5 && currentMail != 'null'){
				$("#moreDiv").append(morebtn);				
			} 
				$(".comment_Inq").slice(0,5).show();

	
			$("#comment_cnt").html("<h3>댓글 ("+data.cnt+" comments)</h3>");
			
		}
	});
		}
	});
});