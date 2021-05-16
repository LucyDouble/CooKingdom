<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/recipeRegester.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="css/summernote/summernote-lite.css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
let cnt = 0;
function addIng() {
	let ingTypeName = document.getElementById("ingTypeName").value;
	cnt++;
	let IngType = "<input class='newIngTypeText' name='p_"+cnt+"' type='text' readonly value='"+ingTypeName+"'>";
	let IngName = "<input type='text' name='v_"+cnt+"' placeholder='재료 이름'>";
	let IngQty = "<input type='text' name='q_"+cnt+"' placeholder='분량'><br>";
	
	let addIng_cnt = document.getElementById("addIng_cnt");
	
	console.log(ingTypeName);
	
	$("#ingAdded").append(IngType);
	$("#ingAdded").append(IngName);
	$("#ingAdded").append(IngQty);
	
	addIng_cnt.value = cnt;
	console.log(cnt);
};
</script>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="../main/header.jsp"></jsp:include>

		<main class="recipeRegester">
			<form id="frm" enctype="multipart/form-data">
				<div class="recipeRegester_title">
					<h3>레시피 등록</h3>
				</div>

				<table class="recipeRegester_table">
					<tbody>
						<tr>
							<th>레시피 코드</th>
							<td><input required type="text" name="recipeCode"
								placeholder="숫자만 입력해주세요"></td>
						</tr>
						<tr>
							<th>레시피명</th>
							<td><input required type="text" name="recipeName"
								placeholder="내용을 입력하세요"></td>
						</tr>
						<tr>
							<th>레시피 요약</th>
							<td><input required type="text" name="recipeInfo"
								placeholder="내용을 입력하세요"></td>
						</tr>
						<tr>
							<th>가격</th>
							<td><input required type="text" name="recipePrice"
								placeholder="숫자만 입력해주세요"></td>
						</tr>
						<tr>
							<th>나라</th>
							<td><select name="recipeNation" id="recipeNation">
									<option value="한식">한식</option>
									<option value="서양">서양</option>
									<option value="일본">일본</option>
									<option value="중국">중국</option>
							</select></td>
						</tr>
						<tr>
							<th>종류</th>
							<td><select name="recipeType" id="recipeType">
									<option value="밥">밥</option>
									<option value="밑반찬/김치">밑반찬/김치</option>
									<option value="찜">찜</option>
									<option value="부침">부침</option>
									<option value="조림">조림</option>
									<option value="구이">구이</option>
									<option value="튀김/커틀릿">튀김/커틀릿</option>
									<option value="볶음">볶음</option>
									<option value="찌개/전골/스튜">찌개/전골/스튜</option>
									<option value="만두/면류">만두/면류</option>
									<option value="나물/생채/샐러드">나물/생채/샐러드</option>
									<option value="그라탕/리조또">그라탕/리조또</option>
							</select></td>
						</tr>
						<tr>
							<th>분량</th>
							<td><select name="recipeQty" id="recipeQty">
									<option value="1인분">1인분</option>
									<option value="2인분">2인분</option>
									<option value="3인분">3인분</option>
									<option value="4인분">4인분</option>
							</select></td>
						</tr>
						<tr>
							<th>칼로리</th>
							<td><input required type="text" name="recipeCalorie"
								placeholder="내용을 입력하세요"></td>
						</tr>
						<tr>
							<th>조리 시간</th>
							<td><input required type="text" name="CookingTime"
								placeholder="내용을 입력하세요"></td>
						</tr>
						<tr>
							<th>조리 난이도</th>
							<td><select name="recipeLevel" id="recipeLevel">
									<option value="쉬움">쉬움</option>
									<option value="보통">보통</option>
									<option value="어려움">어려움</option>
							</select></td>
						</tr>
						<tr>
							<th>메인 이미지</th>
							<td><input type="file" name="rfilepath" id="rfilepath">
							</td>
						</tr>
						<tr>
							<th>재료 종류</th>
							<td><select name="ingTypeName" id="ingTypeName">
									<option value="주재료">주재료</option>
									<option value="부재료">부재료</option>
									<option value="양념">양념</option>
							</select></td>
						</tr>
						<tr>
							<th>재료</th>
							<td id="ingAdded">
						</tr>
						<tr>
							<th>추가</th>
							<td><input type="button" value="추가" onClick="addIng();">
								<input id="addIng_cnt" type="hidden" name="cnt"></td>
						</tr>

<!-- 						<tr>
							<th>상품 소개</th>
							<td><textarea id="summernote" name="editordata"></textarea>
							</td>
						</tr> -->

					</tbody>
				</table>
				<button type="button" class="regesterBtn" id="regesterBtn">등록</button>
			</form>
		</main>

		<jsp:include page="../main/footer.jsp"></jsp:include>
	</div>
	<script src="js/recipeRegester.js"></script>
	<script src="js/summernote/summernote-lite.js"></script>
	<script src="js/summernote/lang/summernote-ko-KR.js"></script>
</body>
</html>