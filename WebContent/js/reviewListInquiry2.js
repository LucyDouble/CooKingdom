/**
 * 
 */
window.onload = function(){
	var recipeCode = document.getElementById("recipeCode").value;
	$.ajax({
		url:"reviewListInquiry",
		type:"POST",
		dataType : "json",
		data: { 
			recipeCode : recipeCode
		},
		success: function(data){	
			console.log("됐다!!!");
			var reviewList = data.reviewList;
			console.log("reviewList : "+reviewList);

			
			$.each(reviewList, function(i,list){
					var rv = "<div class='review_Inq'>";
					rv += "<table><tr>";
					rv += "<td class='reviewTitle rnum'><input type='hidden' value='"+reviewList[i].reviewNo+"'></td>";
					rv += "<td class='reviewTitle rname><span><a href='#'>"+reviewList[i].recipeName+"</a></span></td>";
					rv += "<td class='reviewTitle rsub' id='rsub-"+reviewList[i].reviewNo+"'><span><a href='#' onclick='return false'>"+reviewList[i].reviewSubject+"</a></span></td>";
					rv += "<td class='reviewTitle rwriter'><span>"+reviewList[i].nickname+"</span></td>";
					rv += "<td class='reviewTitle rdate'> <span>"+reviewList[i].reviewDate+"</span></td>";
					rv += "<td class='reviewTitle rcnt'><span>"+reviewList[i].hit+"</span></td>";
					rv += "</tr></table>"
					
					rv += "<div class='review_content' id='review_content-"+reviewList[i].reviewNo+"'>";
					rv += "<div id='line'></div>";
					rv += "<div class='contentImage'><img src='<%=request.getContextPath() %>/files/"+reviewList[i].reviewPhoto+"' style='width:500px; height:300px;' alt='이미지가 없습니다.'> </div>";
					rv += "<div id='content' style='padding: 0 100px;'><p>"+reviewList[i].reviewContent+"</p></div>";
					rv += "</div></div>";			
					$("#rev").append(rv);
					console.log(rv);
			});
			
	
			$("#title_txt").html("<h3>리뷰 "+data.cnt+" review</h3>");
		
			
		}
	});
}


	















  