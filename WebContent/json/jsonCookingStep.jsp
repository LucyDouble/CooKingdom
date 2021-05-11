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
	$.getJSON("./recipeProcess.json", function(data) {
		$.each(data, function(key, val) {
			if(key == "data") {
				$("table").attr("border", "1");
				
				var list = val;	//	list 변수 : 배열로 정의
				for(var i = 0; i < list.length; i++) {
					var str = list[i];
					$("tbody").append(
						"<tr>" +
							"<th>" + str.RECIPE_ID + "</th>" +
							"<th>" + str.COOKING_NO + "</th>" +
							"<th>" + str.COOKING_DC + "</th>" +
							"<th>" + str.STRE_STEP_IMAGE_URL + "</th>" +
							"<input type='hidden' name='jsonCookingStep' value='" + 
							str.RECIPE_ID + "@" + str.COOKING_NO + "@" + str.COOKING_DC + "@" + 
							str.STRE_STEP_IMAGE_URL + "'>" +
						"</tr>"
					);
				}
			}
		});
	});
}
</script>
<!-- <script type="text/javascript" src="./js/"jsonIngredient.js></script> -->
</head>
<body>
	<form action="<%= request.getContextPath() %>/jsonCookingStep.do" method="post">
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