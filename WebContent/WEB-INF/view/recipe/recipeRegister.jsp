<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/recipeRegester.css" rel="stylesheet" type="text/css">

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
		<jsp:include page="../main/header.jsp"></jsp:include>
		
		<main class="recipeRegester">
	        <form action="">
	            <div class="recipeRegester_title">
	                <h3>레시피 등록</h3>
	            </div>
	
	            <table class="recipeRegester_table">
	                <tbody>                
	                    <tr>
	                        <th>레시피 코드</th>
	                        <td>
	                            <input required type="text" name="recipeCode" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>레시피명</th>
	                        <td>
	                            <input required type="text" name="recipeName" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>레시피 요약</th>
	                        <td>
	                            <input required type="text" name="recipeInfo" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>분량</th>
	                        <td>
	                            <input required type="text" name="recipeQty" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>칼로리</th>
	                        <td>
	                            <input required type="text" name="recipeCalorie" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>음식 종류</th>
	                        <td>
	                            <input required type="text" name="recipeType" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>조리 난이도</th>
	                        <td>
	                            <input required type="text" name="recipeLevel" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>조리 시간</th>
	                        <td>
	                            <input required type="text" name="" placeholder="내용을 입력하세요">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>주재료</th>
	                        <td>
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                            <input type="text" name="" placeholder="주재료">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>부재료</th>
	                        <td>
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                            <input type="text" name="" placeholder="부재료">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>양념</th>
	                        <td>
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                            <input type="text" name="" placeholder="양념">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>메인 이미지</th>
	                        <td>
	                            <input type="file" name="bfilepath" id="bfilepath">
	                        </td>
	                    </tr>
	                    <tr>
	                        <th>상품 소개</th>
	                        <td>
	                            <div id="editor" contenteditable="true">
	                                
	                            </div>
	                        </td>
	                    </tr>
	                </tbody>
	            </table>
	            <button class="regesterBtn" id="regesterBtn">등록</button>
	        </form>
    	</main>
	
		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
</body>
</html>