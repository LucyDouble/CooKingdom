<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/reviewListInquiry.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
        <div class="board" id="board">
            <div id="review"   class="tabcontent">
                <form action="" name="frmList">
                    <div class="title_txt">
                        <h3>리뷰( review)</h3>
                    </div>
                    <div id="line"></div>
                    <!-- 각 리뷰의 목록을 보여주는 div-->
                    <c:if test="${empty reviewList}" >
				       		게시글이 없습니다.	
			        </c:if>
			        <c:if test="${not empty reviewList}" >
			        <c:forEach items="${reviewList}" var="r" >
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
                                <td class="reviewTitle rsub" id="rsubjs">
                                    <span><a href="#">${r.reviewSubject}</a></span>
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
                        <div id="review_content">
                            <div id="line"></div>
                            <div class="contentImage">
                                <img src="http://placehold.it/500x300">
                            </div>
                            <div id="content">
                                <p>${r.reviewContent }</p>
                            </div>
                            <div class="showWriter">
                                <button type="button"> 수정</button>
                                <button type="button">삭제</button>
                            </div>
                            <br>
                        </div>
                        <div id="line"></div>
                    </div>
                    </c:forEach>
                    </c:if>
                    <button type="button" id="writeReview" onclick="">글쓰기</button>
                </form>  
            </div>
            <div id="comment"  class="tabcontent">
                <form action="" name="frmList">
                    <div class="title_txt">
                        <h3>댓글( comment)</h3>
                    </div>
                    <div id="line"></div>
                    <!-- 각 리뷰의 목록을 보여주는 div-->
                    <div class="review_Inq">
                        <table>
                            <tr>
                                <td class="reviewTitle rnum"><span>1</span></td>
                                <td class="reviewTitle">
                                    <a href="#"><img src="http://placehold.it/50x80"></a>
                                </td>
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
                                <td class="reviewTitle rcnt">
                                    <span>0</span>
                                </td>
                            </tr>

                        </table>
                        <div id="review_content">
                            <div id="line"></div>
                            <div class="contentImage">
                                <img src="http://placehold.it/500x300">
                            </div>
                            <div id="content">
                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores quod impedit nisi
                                    nemo ipsum accusantium temporibus. Vero, aperiam omnis. Soluta, beatae recusandae?
                                    Voluptate placeat consectetur mollitia doloremque quam, quidem minus?</p>
                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores quod impedit nisi
                                    nemo ipsum accusantium temporibus. Vero, aperiam omnis. Soluta, beatae recusandae?
                                    Voluptate placeat consectetur mollitia doloremque quam, quidem minus?</p>
                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores quod impedit nisi
                                    nemo ipsum accusantium temporibus. Vero, aperiam omnis. Soluta, beatae recusandae?
                                    Voluptate placeat consectetur mollitia doloremque quam, quidem minus?</p>
                                <p>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Maiores quod impedit nisi
                                    nemo ipsum accusantium temporibus. Vero, aperiam omnis. Soluta, beatae recusandae?
                                    Voluptate placeat consectetur mollitia doloremque quam, quidem minus?</p>
                            </div>
                            <div class="showWriter">
                                <button type="button"> 수정</button>
                                <button type="button">삭제</button>
                            </div>
                            <br>
                        </div>
                        <div id="line"></div>
                    </div>
                    <button type="button" id="writeReview" onclick="">글쓰기</button>
                </form>
            </div>
        </div>
		<jsp:include page="../main/footer.jsp"></jsp:include>	
	</div>
	<script type="text/javascript" src="js/reviewListInquiry.js"></script>
</body>
</html>