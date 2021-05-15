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
					<img src="image/header/main1.png" style="width: 100%">
				</div>

				<div class="mySlides fade">
					<img src="http://placehold.it/300x100" style="width: 100%">
				</div>

				<div class="mySlides fade">
					<img src="http://placehold.it/300x100" style="width: 100%">
				</div>

			</div>
			<br>

			<section>
				<article id="monthlyRecipe">
					<h1>이달의 신규 레시피</h1>
					<div id="mrImg">
						<ul>
							<li class="mR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="mR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="mR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="mR"><a href="#"><img
									src="image/header/newR.png"></a></li>
						</ul>
					</div>
				</article>
				<br> <br>
				<article id="bestRecipe">
					<h1>베스트 레시피</h1>
					<div>
						<ul>
							<li class="bR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="bR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="bR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="bR"><a href="#"><img
									src="image/header/newR.png"></a></li>
						</ul>
					</div>
				</article>
				<div id="banner">
					<img src="image/header/banner.png">
				</div>
				<article id="kingdomRecipe">
					<h1>킹덤의 추천 레시피</h1>
					<div>
						<ul>
							<li class="cR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="cR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="cR"><a href="#"><img
									src="image/header/newR.png"></a></li>
							<li class="cR"><a href="#"><img
									src="image/header/newR.png"></a></li>
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
		    setTimeout(showSlides, 3000); 
		}
	
	</script>
</body>
</html>