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
	int recipeCode2 = Integer.parseInt(request.getParameter("recipeCode"));
%>
        <div class="tabBoard">
            <div class="tab">
                <button class="tablinks active" onclick="openCont(event, 'review');">리뷰</button>
                <button class="tablinks" onclick="openCont(event, 'comment');">댓글</button>
            </div>
        </div>
        <!-- TODO -->
	        <input type="hidden" name="email" value= "kimttobi@ttobi.com" id="email"/>
 			<input type="hidden" name="recipeCode" value= <%=recipeCode2%>  id="recipeCode" />
        <div class="board" id="board">
            <div id="review" class="tabcontent">
				
                <form action="" name="frmList" >
 <!-- 리뷰 -->
                    <div id="title_txt">
                        <h3>리뷰 (<c:out value= "${cnt}" /> review)</h3>
                    </div>
                    <div id="line"></div>
                    <!-- 각 리뷰의 목록을 보여주는 div-->
         			<div id="rev">
	    	            <div class="review_Inq" >         	
	                        <table>
	                            <tr>
	                                <td class="reviewTitle rnum"><input type="hidden" value="${r.reviewNo}" /></td>
	                                <td class="reviewTitle">
	                                </td>
	                                <td class="reviewTitle rname">
	                                    <span><a href="#">${r.recipeName}</a></span>
	                                </td>
	                                <td class="reviewTitle rsub" id="rsub-${r.reviewNo}">
	                                    <span><a href="#"><c:out value= "${r.reviewSubject}" /></a></span>
	                                </td>
	                                <td class="reviewTitle rwriter">
	                                    <span>${r.nickname }</span>
	                                </td>
	                                <td class="reviewTitle rdate">
	                                    <span>${r.reviewDate }</span>
	                                </td>
	                                <td class="reviewTitle rcnt">
	                                    <span>${r.hit}</span>
	                                </td>
	                            </tr>
	                        </table>
	                        <div class="review_content" id="review_content-${r.reviewNo}">
	                            <div id="line"></div>
	                            <c:if test="${not empty r.reviewPhoto }">
	                            <div class="contentImage">                            	
	                                <img src="<%=request.getContextPath() %>/files/${r.reviewPhoto}" style="width:500px; height:300px;">
	                            </div>
	                            </c:if>
	                            <div id="content"  style="padding: 0 100px;">
	                                <p>${r.reviewContent }</p>
	                            </div>
	                            
	                            <div class="showWriter">
	                                <button type="button" onclick="window.location='<%=request.getContextPath()%>/reviewModify?reviewNo=${r.reviewNo}&reviewSubject=${r.reviewSubject}&reviewContent=${r.reviewContent }&email=abc&recipeCode=<%=recipeCode2%>';">수정</button>
	                                <button type="button" id="delete_modal-${r.reviewNo}" >삭제</button>
	                            </div>
	                            <br>
	                        </div>
	                    </div>
                    </div>
                    <c:if test=" ${not empty reviewList}">
 					<div id= "pageCount">	
	                    <c:if test="${startPage != 1 }">
							<a href="<%=request.getContextPath() %>/reviewListInquiry?pageNum=${startPage-1}">이전</a> 
						</c:if>
						<c:forEach begin="${startPage}" end="${endPage}" var="s" step="1">
							<a class="focus${(currentPage == s)? 'Page' : ''}" href="<%=request.getContextPath() %>/reviewListInquiry?pageNum=${s}">${s}</a> 
						</c:forEach>
						<c:if test="${endPage < pageCnt }">
							<a href="<%=request.getContextPath() %>/reviewListInquiry?pageNum=${endPage+1}">다음</a>
						</c:if>
					</div>
					</c:if>
					<br>
                    <button type="button" id="writeReview" onclick= "window.location ='<%=request.getContextPath()%>/registerReview?recipeCode=<%=recipeCode2%>';">글쓰기</button>
                </form>  
            </div>
<!-- 댓글 -->     
            <div id="comment"  class="tabcontent">
                <form action="" name="frmComment">
                    <div class="title_txt">
                        <h3>댓글( comment)</h3>
                    </div>
                    <div id="line"></div>
			        	<div class="comment_Inq">
        				<input type="hidden" name="commentNo" value=""  />
        				<input type="hidden" name="commentDepth" value=""  />
						<input type="hidden" name="commentGroup" value="1" />
						<input type="hidden" name="commentSorts" value=""  />
                        <table>
                            <tr>
                                <td class="cwriter">
                                   	 김또비
                                </td>
                                <td class="csub">
                                   	파래무침이라니!ㅋㅋㅋㅋㅋ
                                </td>
                                <td class="cdate">
                                    2021-05-11 11:51:00
                                </td>                        
                            </tr>
                        </table> 
                        <div class="commentBtn">
                        	<button type="button" class="cbtn" id="cbtn-">댓글쓰기</button>
                        	<button type="button" class="cbtn">수정</button>
                        	<button type="button" class="cbtn">삭제</button>
                        </div>
                   	 	</div>	
                   	 	<br><br>
                   	 	<!-- 대댓글 -->
                   	 	<div class="comment_Inq">
                        <table>
                            <tr>
                                <td class="cwriter2">
                                   	 김또비
                                </td>
                                <td class="csub2">
                                   	파래무침이라니!ㅋㅋㅋㅋㅋ
                                </td>
                                <td class="cdate">
                                    2021-05-11 11:51:00
                                </td>                        
                            </tr>
                        </table> 
                        <div class="commentBtn">
                        	<button type="button" class="cbtn">수정</button>
                        	<button type="button" class="cbtn">삭제</button>
                        </div>
                   	 	</div>	
                   	 	
                   	 	
                       <br><br>
                   <input type="text" id="commentInput" /><input type="button" value="글 등록" id="commentSubmit" onclick="goReview();">                 
                </form>
            </div> 
        </div>
		<jsp:include page="../modal/DeleteModal.jsp"></jsp:include>	  
	</div>
	<script type="text/javascript" src="js/reviewListInquiry2.js"></script>
	<script type="text/javascript" src="js/reviewListInquiry.js"></script>
	<script type="text/javascript" src="js/reviewRemove.js"></script>
	<script type="text/javascript" src="js/commentRegister.js"></script>
</body>
</html>