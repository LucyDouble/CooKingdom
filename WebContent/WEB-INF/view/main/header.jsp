<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<header id="header">
            <div id="hamburgerM">
                <a href="#"><img src="image/header/menu.png" alt=""></a>
            </div>
            <div id="logo">
                <a href="<%=request.getContextPath()%>/cookingDom"><img src="image/header/logo.png"  ></a>
            </div>
            <ul id="my">
                <li class="my"><a href="#"><img src="image/header/delivery.png"></a></li>
                <li class="my"><a href="#"><img src="image/header/cart.png"></a></li>
                <li class="my"><a href="#"><img src="image/header/myPage.png"></a></li>
            </ul>
</header>
<nav id="nav">
            <ul>
                <li class="menu"><a href="recipelistinquery.do">레시피 목록</a></li>
                <li class="menu"><a href="#">메뉴2</a></li>
                <li class="menu"><a href="#">메뉴3</a></li>
                <li class="menu"><a href="#">메뉴4</a></li>
                <li class="menu"><a href="#">메뉴5</a></li>
            </ul>
            <ul>
                <li id="join"><a href="#">회원가입</a></li>
                <li id="login"><a href="#">로그인</a></li>
            </ul>
</nav>