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
            <div id="main">
                <ul>
                    <li><img src="image/header/main1.png" alt="메인이미지1"></li>
                </ul>
            </div>
            <section>
                <article id="monthlyRecipe">
                    <h1>이달의 신규 레시피</h1>
                    <div id="mrImg">
                        <ul>
                            <li class="mR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="mR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="mR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="mR"><a href="#"><img src="image/header/newR.png"></a></li>
                        </ul>
                    </div>
                </article>
                <br><br>
                <article id="bestRecipe">
                    <h1>베스트 레시피</h1>
                    <div>
                        <ul>
                            <li class="bR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="bR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="bR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="bR"><a href="#"><img src="image/header/newR.png"></a></li>
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
                            <li class="cR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="cR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="cR"><a href="#"><img src="image/header/newR.png"></a></li>
                            <li class="cR"><a href="#"><img src="image/header/newR.png"></a></li>
                        </ul>
                    </div>
                </article>
            </section>
        </div>
	<jsp:include page="footer.jsp"></jsp:include>
</div>
</body>
</html>