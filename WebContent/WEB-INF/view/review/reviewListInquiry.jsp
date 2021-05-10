<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/reviewListInquiry.css" rel="stylesheet" type="text/css">
<link href="css/deleteModal.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<!-- TODO -->
<%-- Member m = (Member)session.getAttribute("member"); --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠킹덤</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>
        <div class="tabBoard">
            <div class="tab">
                <button class="tablinks active" onclick="openCont(event, 'review');">리뷰</button>
                <button class="tablinks" onclick="openCont(event, 'comment');">댓글</button>
            </div>
        </div>
        <!-- TODO -->
	        <input type="hidden" name="email" value= "abc" id="email"/>
	        <!-- ${param.email}-->
	        
	        <!--  ${param.recipeCode}  -->	
        <div class="board" id="board">
            <div id="review"   class="tabcontent">
				
                <form action="" name="frmList" >
 <!-- 리뷰 -->
                    <div class="title_txt">
                        <h3>리뷰 (<c:out value= "${cnt}" /> review)</h3>
                    </div>
                    <div id="line"></div>
                    <input type="hidden" name="recipeCode" value= "347"  id="recipeCode" />
                    <!-- 각 리뷰의 목록을 보여주는 div-->
                    <c:if test="${empty reviewList}" >
				       		게시글이 없습니다.	
			        </c:if>
			        <c:if test="${not empty reviewList}" >
			        <c:forEach items="${reviewList}" var="r">             
                    <div class="review_Inq">         	
                        <table>
                            <tr>
                                <td class="reviewTitle rnum">${r.reviewNo}</td>
                                <td class="reviewTitle">
                                    <a href="#"><img src="http://placehold.it/50x80"></a>
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
                            <!-- TODO -->
                            <div class="showWriter">
                                <button type="button" onclick="window.location='<%=request.getContextPath()%>/reviewModify?reviewNo=${r.reviewNo}&reviewSubject=${r.reviewSubject}&reviewContent=${r.reviewContent }&email=abc&recipeCode=347';">수정</button>
                                <button type="button" id="delete_modal-${r.reviewNo}" >삭제</button>
                            </div>
                            <br>
                        </div>
                        <div id="line"></div>
                    </div>
                    </c:forEach>
                    </c:if>
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
					<br>
                    <button type="button" id="writeReview" onclick= "window.location ='<%=request.getContextPath()%>/registerReview';">글쓰기</button>
                </form>  
            </div>
            
<!-- 댓글 -->     
            <div id="comment"  class="tabcontent">
                <form action="" name="frmComment">
                    <div class="title_txt">
                        <h3>댓글( comment)</h3>
                    </div>
                    <div id="line"></div>
                    <div class="review_Inq">
                        <table>
                            <tr>
                                <td class="reviewTitle rnum"><span>1</span></td>
                                <td class="reviewTitle rname">
                                    <span><a href="#">밀푀유나베</a></span>
                                </td>
                                <td class="reviewTitle rsub" id="rsubjs">
                                    <span><a href="#">밀푀유 나베 정말 맛있어요!</a></span>
                                </td>
                                <td class="reviewTitle rwriter">
                                    <span>작성자</span>
                                </td>
                                <td class="reviewTitle rdate">
                                    <span>2021-05-04</span>
                                </td>
                            </tr>

                        </table>
                        
                       </div>
                       <div id="line"></div>
                    </div>                  
                </form>
            </div>
        </div>
		<jsp:include page="../main/footer.jsp"></jsp:include>			
		<jsp:include page="../modal/DeleteModal.jsp"></jsp:include>	  
	</div>
	<script type="text/javascript" src="js/reviewListInquiry.js"></script>
	<script type="text/javascript" src="js/reviewRemove.js"></script>
</body>
</html>