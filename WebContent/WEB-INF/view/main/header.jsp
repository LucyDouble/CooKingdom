<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="ckd.member.vo.User"%>
<%@ page import="ckd.member.vo.Manager" %>

<header id="header">
            <div id="hamburgerM">
                <a href="#"><img src="image/header/menu.png" alt=""></a>
            </div>
            <div id="logo">
                <a href="<%=request.getContextPath()%>/cookingDom?command=Main"><img src="image/header/logo.png"  ></a>
            </div>
            <ul id="my">
                <li class="my"><a href="#"><img src="image/header/delivery.png"></a></li>
                <li class="my"><a href="CartListInquiry"><img src="image/header/cart.png"></a></li>
                <%
                User user = (User)session.getAttribute("User");
            	Manager manager = (Manager)session.getAttribute("Manager");
            	Manager director = (Manager)session.getAttribute("Director"); 
            	if (user == null && manager == null && director == null) {%>
            		<li class="my"><a href="loginUser"><img src="image/header/myPage.png"></a></li>
            	<%} else if (user != null) {%>
            		<li class="my"><a href="modifyUserInfo"><img src="image/header/myPage.png"></a></li>
            	<%} else if (manager != null) {%>
            		<li class="my"><a href="modifyManagerInfo"><img src="image/header/myPage.png"></a></li>
            	<%} else if (director != null) {%>
            		<li class="my"><a href="modifyDirectorInfo"><img src="image/header/myPage.png"></a></li>
            	<%}%>               
            </ul>
</header>
<nav id="nav">
            <ul>
                <li class="menu"><a href="recipelistinquery.do">레시피 목록</a></li>
                <li class="menu"><a href="teamMember">요리하시조 소개</a></li>
                <li class="menu"><a href="recipelistinquery.do">맛있는 요리</a></li>
                <li class="menu"><a href="recipelistinquery.do">집에서 만들어 먹어요!</a></li>
            </ul>
            <ul>	
                <% if (user == null && manager == null && director == null) {%>
               		<li id="join"><a href="inquiryUser">회원가입</a></li>
                	<li id="login"><a href="loginUser">로그인</a></li>
                <%} else if (user != null) {%>
                	<li id="join"><a href="logout">로그아웃</a></li>
                <%} else if (manager != null) {%>
                	<li id="join"><a href="logout">로그아웃</a></li>
                <%} else if (director != null) {%>
                	<li id="join"><a href="logout">로그아웃</a></li>
                <%}%>
            </ul>
</nav>