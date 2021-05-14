	$(function() {
		
		$("#btnSearch").on("click", function() {
			var search1 = $("#search").val();
			
			$.ajax({
				url : "<%=request.getContextPath() %>/recipelistinquery.do",
				type : "get",
				data : {search : search1},
				success : function(resultData) {
					console.log(resultData.pageCnt);
					console.log(resultData.startPage);
					console.log(resultData.endPage);
					console.log(resultData.currentPage);
					console.log(resultData.boardList);
					console.log(resultData.search); 
				}
			});
		});
	});