<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/recipeListInquery.css" rel="stylesheet" type="text/css">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CooKingDom RecipeList</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
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
</script>

</head>
<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>

		<section class="recipeListInquery">
			<article class="searchCategory">
				<div>
					<ul>
						<li>종류별</li>
						<li><a href="#">전체</a></li>
						<li><a href="#">밥</a></li>
						<li><a href="#">밑반찬/김치</a></li>
						<li><a href="#">찜</a></li>
						<li><a href="#">부침</a></li>
						<li><a href="#">조림</a></li>
						<li><a href="#">구이</a></li>
						<li><a href="#">볶음</a></li>
						<li><a href="#">찌개/전골/스튜</a></li>
						<li><a href="#">만두/면류</a></li>
						<li><a href="#">나물/생채/샐러드</a></li>
						<li><a href="#">그라탕/리조또</a></li>
					</ul>
					<ul>
						<li>나라별</li>
						<li><a href="#">전체</a></li>
						<li><a href="#">한식</a></li>
						<li><a href="#">중식</a></li>
						<li><a href="#">일식</a></li>
						<li><a href="#">서양</a></li>
						<li><a href="#">퓨전</a></li>
						<li><a href="#">이탈리아</a></li>
						<li><a href="#">동남아시아</a></li>
					</ul>
					<ul>
						<li>분량별</li>
						<li><a href="#">전체</a></li>
						<li><a href="#">1인분</a></li>
						<li><a href="#">2인분</a></li>
						<li><a href="#">3인분</a></li>
						<li><a href="#">4인분</a></li>
					</ul>
					<ul>
						<li>시간별</li>
						<li><a href="#">전체</a></li>
						<li><a href="#">20분이하</a></li>
						<li><a href="#">30분</a></li>
						<li><a href="#">40~50분</a></li>
						<li><a href="#">1시간 이상</a></li>
					</ul>
					<ul>
						<li>칼로리별</li>
						<li><a href="#">전체</a></li>
						<li><a href="#">100kcal이하</a></li>
						<li><a href="#">~200kcal</a></li>
						<li><a href="#">~300kcal</a></li>
						<li><a href="#">~400kcal</a></li>
						<li><a href="#">500kcal 이상</a></li>
					</ul>
					<ul>
						<li>난이도별</li>
						<li><a href="#">전체</a></li>
						<li><a href="#">초보환영</a></li>
						<li><a href="#">보통</a></li>
						<li><a href="#">어려움</a></li>
					</ul>
				</div>
			</article>
		</section>
		
		<div>
			<button>
				<a href="<%= request.getContextPath() %>/cookingDom?command=recipeRegester">등록</a>
			</button>
		</div>

		<c:if test="${not empty search }">
			<h1>${search }에대한검색 결과입니다.</h1>
		</c:if>
		<c:if test="${empty recipeList }">
			게시글이 없습니다.		
		</c:if>
		<c:if test="${not empty recipeList }">
		
			<main class="goodsList">
				<div class="goodsList_innerbox">
					<ul>
						<c:forEach items="${recipeList }" var="v">
							<li>
								<div class="goodsList_card">
									<div class="goodsList_card_inner">
										<a href="<%= request.getContextPath()%>/recipeinquery.do?recipeCode=${v.recipeCode}&pageNum=${currentPage}&search=${search}">
										<img src="${v.recipeUrl }" alt="img">
										</a>
										<div id="likeBtn">
											<button type="button">
												<i class="far fa-heart"></i> <span>${v.likes }</span>
											</button>
										</div>
									</div>
									<a class="goodsList_card_info" href="<%= request.getContextPath()%>/recipeinquery.do?recipeCode=${v.recipeCode}&pageNum=${currentPage}&search=${search}"> <span>${v.recipeName }</span>
										<span>${v.price }원</span>
									</a>
								</div>
							</li>
						</c:forEach>
					</ul>
				</div>
			</main>
		</c:if>




		<c:if test="${startPage != 1 }">
			<a
				href="<%=request.getContextPath() %>/recipelistinquery.do?pageNum=${startPage-1}&search=${search}">이전</a>
		</c:if>
		<c:forEach begin="${startPage }" end="${endPage }" var="s" step="1">
			<a
				href="<%=request.getContextPath() %>/recipelistinquery.do?pageNum=${s }&search=${search}">${s }</a>
		</c:forEach>
		<c:if test="${endPage < pageCnt }">
			<a
				href="<%=request.getContextPath() %>/recipelistinquery.do?pageNum=${endPage+1}&search=${search}">다음</a>
		</c:if>

		<form name="f">
			<input type="search" name="search" id="search" value="${search}">
			<button type="button" id="btnSearch">검색</button>
		</form>

		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	<script src="https://kit.fontawesome.com/6a57affb8e.js"
		crossorigin="anonymous"></script>
</body>
</html>