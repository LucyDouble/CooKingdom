/**
 * 
 */


function goReview(){
	var commentContent = document.getElementById("commentInput").value;
	var email = document.getElementById("email").value;
	var recipeCode = document.getElementById("recipeCode").value;
	var commentsize = 400;
	var contentSize = 0;
	contentSize = commentContent.length;
	
	if(commentsize <contentSize ){
		alert("글자수를 초과했습니다. 1000자 이내로 입력해주세요");
		commentContent = "";
		return false;
	}
	console.log("contentSize : "+ contentSize);
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
			$.ajax({
		url:"commentListInquiry",
		type:"POST",
		dataType : "json",
		async : false,
		data: { 
			recipeCode : recipeCode
		},
		success : function(data){
			
	
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
				
				
			
			
				
				$(".comment_Inq").slice(0,5).show();

				
				$("#moreDiv").empty();
				
				var morebtn = "<a id='moreBtn'>더보기(more)</a>";
				if(currentMail != null && data.cnt > 5 && currentMail != 'null'){
					$("#moreDiv").append(morebtn);				
				} 

	
			$("#comment_cnt").html("<h3>댓글 ("+data.cnt+" comments)</h3>");
			
		}
	});
		},
		error : function(request, status, error){
			alert("댓글등록실패!");
			console.log("실패!");
		}
	});
	
}
