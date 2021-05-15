<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/main.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>


</head>
<body>
	<div class="wrapper">
		<jsp:include page="header.jsp"></jsp:include>
		<div id="section">
			<div class="slideshow-container">

				<div class="mySlides fade">
					<img src="image/header/마라탕.png" style="width: 100%">
				</div>

				<div class="mySlides fade">
					<img src="image/header/코로나할인.png" style="width: 100%">
				</div>

				<div class="mySlides fade">
					<img src="image/header/밥도둑.png" style="width: 100%">
				</div>

			</div>
			<br>

			<section>
				<article id="monthlyRecipe">
					<h1>이달의 신규 레시피</h1>
					<div id="mrImg">
						<ul>
							<li class="mR"><a href="#"><img
									src="image/header/잡채밥.png"></a></li>
							<li class="mR"><a href="#"><img
									src="image/header/마라탕메뉴.png"></a></li>
							<li class="mR"><a href="#"><img
									src="image/header/아보카도 연어 샌드위치.png"></a></li>
							<li class="mR"><a href="#"><img
									src="image/header/캘리포니아롤.png"></a></li>
						</ul>
					</div>
				</article>
				<br> <br>
				<article id="bestRecipe">
					<h1>베스트 레시피</h1>
					<div>
						<ul>
							<li class="bR"><a href="#"><img
									src="image/header/가리비 치즈 버터구이.png"></a></li>
							<li class="bR"><a href="#"><img
									src="image/header/순두부찌개.png"></a></li>
							<li class="bR"><a href="#"><img
									src="image/header/오코노미야끼.png"></a></li>
							<li class="bR"><a href="#"><img
									src="image/header/열무비빔밥.png"></a></li>
						</ul>
					</div>
				</article>
				<div id="banner">
					<img src="image/header/국밥.png">
				</div>
				<article id="kingdomRecipe">
					<h1>킹덤의 추천 레시피</h1>
					<div>
						<ul>
							<li class="cR"><a href="#"><img
									src="image/header/아보카도 연어 샌드위치.png"></a></li>
							<li class="cR"><a href="#"><img
									src="image/header/마늘빵.png"></a></li>
							<li class="cR"><a href="#"><img
									src="image/header/해물스파게티.png"></a></li>
							<li class="cR"><a href="#"><img
									src="image/header/갈비찜.png"></a></li>
						</ul>
					</div>
				</article>
			</section>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
	</div>
	<script>
		var slideIndex = 0;
		showSlides();
	
		function showSlides() {
		    var i;
		    var slides = document.getElementsByClassName("mySlides");
		    for (i = 0; i < slides.length; i++) {
		       slides[i].style.display = "none";  
		    }
		    slideIndex++;
		    if (slideIndex > slides.length) {slideIndex = 1}    
		    slides[slideIndex-1].style.display = "block";  
		    setTimeout(showSlides, 4000); 
		}
	
	</script>
</body>
</html>