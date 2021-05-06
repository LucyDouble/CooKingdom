<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script type="text/javascript">
$(function() {
	getJson();
});

//	json 데이터 읽어오는 함수
function getJson() {
	$.getJSON("./recipeInfo.json", function(data) {
		$.each(data, function(key, val) {
			if(key == "data") {
				$("table").attr("border", "1");
				
				var list = val;	//	list 변수 : 배열로 정의
				for(var i = 0; i < list.length; i++) {
					var str = list[i];
					$("tbody").append(
						"<tr>" +
							"<th>" + str.RECIPE_ID + "</th>" +
							"<th>" + str.RECIPE_NM_KO + "</th>" +
							"<th>" + str.NATION_CODE + "</th>" +
							"<th>" + str.NATION_NM + "</th>" +
							"<th>" + str.SUMRY + "</th>" +
							"<th>" + str.TY_CODE + "</th>" +
							"<th>" + str.TY_NM + "</th>" +
							"<th>" + str.COOKING_TIME + "</th>" +
							"<th>" + str.CALORIE + "</th>" +
							"<th>" + str.QNT + "</th>" +
							"<th>" + str.LEVEL_NM + "</th>" +
							"<th>" + str.IRDNT_CODE + "</th>" +
							"<th>" + str.PC_NM + "</th>" +
							"<th>" + str.IMG_URL + "</th>" +
							"<input type='hidden' name='jsonRecipe' value='" +
							str.RECIPE_ID + "@" + str.RECIPE_NM_KO + "@" + str.NATION_CODE + "@" +
							str.NATION_NM + "@" + str.SUMRY + "@" + str.TY_CODE + "@" + 
							str.TY_NM + "@" + str.COOKING_TIME + "@" + str.CALORIE + "@" +
							str.QNT + "@" + str.LEVEL_NM + "@" + str.IRDNT_CODE + "@" + 
							str.PC_NM + "@" + str.IMG_URL + "'>" +
						"</tr>"
					);
				}
			}
		});
	});
}
</script>
<!-- <script type="text/javascript" src="./js/"jsonRecipe.js></script> -->
</head>
<body>
	<form action="<%= request.getContextPath() %>/json.do" method="post">
		<input type="submit" value="db에 저장">
		<input type="hidden" name="command" value="listdb">

		<table border="1">
			<thead>
			</thead>
			<tbody>
			</tbody>
		</table>
	</form>
</body>
</html>