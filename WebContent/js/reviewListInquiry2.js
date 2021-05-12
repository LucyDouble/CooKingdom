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
		
			var contextPath = getContextPath();
			console.log(contextPath);
		
			$.each(reviewList, function(i,list){
					var rv = "<div class='review_Inq'>";
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
					rv += "<div class='contentImage'><img src='"+contextPath+"/files/"+reviewList[i].reviewPhoto+"' style='width:500px; height:300px;' alt='이미지가 없습니다.'> </div>";
					rv += "<div id='content' style='padding: 0 100px;'><p>"+reviewList[i].reviewContent+"</p></div>";
					rv += "<div class='showWriter'>";
					rv += "<button type='submit' formaction='"+contextPath+"/reviewModify' formmethod='post' >수정</button>";
					rv += "<button type='button' id='delete_modal-"+reviewList[i].reviewNo+"'>삭제</button></div>"
					rv += "</div></div>";			
					$("#rev").append(rv);
					console.log(rv);
			});
			
			
	
			$("#title_txt").html("<h3>리뷰 "+data.cnt+" review</h3>");
			
			var page = "<a id='beforeP' href='<%=request.getContextPath() %>/reviewListInquiry?pageNum="+data.startPage-1+"'>이전</a>";
			page += "<a class='focus${(currentPage == s)? 'Page' : ''}' href='<%=request.getContextPath() %>/reviewListInquiry?pageNum="+data.pageNum+"'>"+data.pageNum+"</a>";
			page += "<a  id='afterP' href='<%=request.getContextPath() %>/reviewListInquiry?pageNum="+data.endPage+1+"'>다음</a>"
			

			
			
			$("#pageCount").html(page);
		}
	});
}

function goModify(){
	console.log("들어옴");
	$("#recipe_frm").action = "<%=request.getContextPath()%>/reviewModify";
	$("#recipe_frm").method = "post";
	$("#recipe_frm").submit();
	
}


function getContextPath() {
    hostIndex = location.href.indexOf( location.host ) + location.host.length;
    return location.href.substring( hostIndex, location.href.indexOf('/', hostIndex + 1) );
}












  