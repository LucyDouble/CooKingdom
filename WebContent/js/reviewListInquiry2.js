/**
 * 
 */
var recipeCode = ""
var currentMail = "";
window.onload = function(){
	recipeCode = document.getElementById("recipeCode").value;
	currentMail = document.getElementById("email").value;
	/****************  리뷰     ******************/
	$.ajax({
		url:"reviewListInquiry",
		type:"POST",
		dataType : "json",
		data: { 
			recipeCode : recipeCode
		},
		success: reviewDisplay
	});
	
	
	/****************  댓글     ******************/
	$.ajax({
		url:"commentListInquiry",
		type:"POST",
		dataType : "json",
		data: { 
			recipeCode : recipeCode
		},
		success : function(data){
			console.log("댓글이다!!!");
			var commentList = data.commentList;
			console.log(commentList);
			var contextPath = getContextPath();
			var cv = "";
			
			$.each(commentList, function(i,list){
					cv += "<div class='comment_Inq'>";
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
					$("#cmt").append(cv);
					
			
			
	
			$("#comment_cnt").html("<h3>댓글 ("+data.cnt+" comments)</h3>");
		}
	});
}


function getContextPath() {
    hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}
function pageGo(page){
	console.log("pageGo:"+ page);
	$.ajax({
		url:"reviewListInquiry",
		type:"post",
		dataType : "json",
		data : {
			currentPage : page,
			recipeCode : recipeCode 
		},
		success : reviewDisplay
	});
}

function reviewDisplay(data){
		
	var reviewList = data.reviewList;
	console.log("reviewList : "+reviewList);

	var contextPath = getContextPath();
	var rv = "";
	
	$("#rev").empty();
	
	$.each(reviewList, function(i,list){
			
			rv = "<div class='review_Inq'>";
			rv += "<input type='hidden' value='"+reviewList[i].reviewSubject+"' name='reviewSubject'>";
			rv += "<input type='hidden' value='"+reviewList[i].reviewNo+"' name='reviewNo'>";
			rv += "<input type='hidden' value='"+reviewList[i].reviewContent+"' name='reviewContent'>";
			rv += "<table><tr>"
			rv += "<td class='reviewTitle rnum'><input type='hidden' value='"+reviewList[i].reviewNo+"'></td>";
			rv += "<td class='reviewTitle rname><span><a href='#'>"+reviewList[i].recipeName+"</a></span></td>";
			rv += "<td class='reviewTitle rsub' id='rsub-"+reviewList[i].reviewNo+"'><span><a href='#' onclick='return false'>"+reviewList[i].reviewSubject+"</a></span></td>";
			rv += "<td class='reviewTitle rwriter'><span>"+reviewList[i].nickname+"</span></td>";
			rv += "<td class='reviewTitle rdate'> <span>"+reviewList[i].reviewDate+"</span></td>";
			rv += "<td class='reviewTitle rcnt'><span>"+reviewList[i].hit+"</span></td>";
			rv += "</tr></table>"
			
			rv += "<div class='review_content' id='review_content-"+reviewList[i].reviewNo+"'>";
			rv += "<div id='line'></div>";
			if(reviewList[i].reviewPhoto != null){
				rv += "<div class='contentImage'><img src='"+contextPath+"/files/"+reviewList[i].reviewPhoto+"' style='width:500px; height:300px;' alt='이미지가 없습니다.'> </div>";	
			}				
			rv += "<div id='content' style='padding: 0 100px;'><p>"+reviewList[i].reviewContent+"</p>";
			
			if(currentMail == reviewList[i].email){
			rv += "<div class='showWriter'>";
			rv += "<button type='submit' formaction='"+contextPath+"/reviewModify' formmethod='post' >수정</button>";
			rv += "<button type='button' id='delete_modal-"+reviewList[i].reviewNo+"'>삭제</button></div>"
			rv += "</div>";
			}
			rv+=  "</div>"; //content
			rv += "</div>"; //review_Inq
			rv += "<div id='line'></div>";
			$("#rev").append(rv);
			
	});
	
	

	$("#title_txt").html("<h3>리뷰 ("+data.cnt+" review)</h3>");
	
	var page = "";
	
	if(data.startPage != 1){
	page += "<a id='beforeP' onclick='pageGo("+(data.startPage-1)+">이전</a>";				
	}
	for (var i = data.startPage; i<=data.endPage; i++){
	page += "<a class='page' onclick='pageGo("+i+")'>"+" "+ i +" "+"</a>";				
	}
	
	if(data.endPage < data.pageCnt)
	page += "<a id='afterP' onclick='pageGo("+(data.endPage+1)+">다음</a>"
	

	$("#pageCount").html(page);
	

}










  