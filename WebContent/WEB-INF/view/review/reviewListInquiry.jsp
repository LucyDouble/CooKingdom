<%@page import="ckd.member.vo.User"%>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/reviewListInquiry.css" rel="stylesheet" type="text/css">
<link href="css/comment.css" rel="stylesheet" type="text/css">
<link href="css/deleteModal.css" rel="stylesheet" type="text/css">
<!-- TODO -->
<%-- Member m = (Member)session.getAttribute("member"); --%>
<%@ page isELIgnored="false" language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    User user = (User)session.getAttribute("User");
	String email = user.getEmail();
%>
<%
	int recipeCode2 = Integer.parseInt(request.getParameter("recipeCode"));
%>
        <div class="tabBoard">
            <div class="tab">
                <button class="tablinks active" onclick="openCont(event, 'review');  return false">리뷰</button>
                <button class="tablinks" onclick="openCont(event, 'comment'); return false">댓글</button>
            </div>
        </div>
	        <input type="hidden" name="email" value= <%=email %> id="email"/>
	        
 			<input type="hidden" name="recipeCode" value= <%=recipeCode2%>  id="recipeCode" />
        <div class="board" id="board">
            <div id="review" class="tabcontent">
				
 <!-- 리뷰 -->
                    <div id="title_txt">
                    <!-- 리뷰 총몇개인지 표시하는 곳 -->
                    </div>
                    <div id="line"></div>
         			<div id="rev">
                    <!-- 각 리뷰의 목록을 보여주는 div-->
                    </div>
 					<div id= "pageCount">	
 					<!-- 페이지나오는곳 -->
					</div>
					<br>
                    <button type="button" id="writeReview" onclick= "window.location ='<%=request.getContextPath()%>/registerReview?recipeCode=<%=recipeCode2%>';">글쓰기</button>
            </div>
<!-- 댓글 -->     
            <div id="comment"  class="tabcontent">
                    <div class="title_txt" id="comment_cnt">
                    <!-- 댓글 총몇개인지 표시하는 곳 -->
                    </div>
                    <div id="line"></div>
                   	<div id="cmt">
					<!-- 댓글들을 보여주는 div-->
                   	</div>
                   	 	<br><br>                                  	                    	 
                   <input type="text" id="commentInput" /><input type="button" value="글 등록" id="commentSubmit" onclick="goReview();"><input type="button" value="글 수정" id="commentModify" />
            </div> 
        </div>
		<jsp:include page="../modal/DeleteModal.jsp"></jsp:include>	  
	</div>
	<script type="text/javascript" src="js/reviewListInquiry2.js"></script>
	<script type="text/javascript" src="js/reviewListInquiry.js"></script>
	<script type="text/javascript" src="js/reviewRemove.js"></script>
	<script type="text/javascript" src="js/commentRegister.js"></script>
	<script type="text/javascript" src="js/commentModify.js"></script>	
	<script type="text/javascript" src="js/commentRemove.js"></script>
</body>
</html>