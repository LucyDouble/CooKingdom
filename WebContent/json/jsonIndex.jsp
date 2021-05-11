<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<a href="<%= request.getContextPath() %>/jsonRecipe.do?command=list">레시피 데이터</a>
	<br>
	<a href="<%= request.getContextPath() %>/jsonIngredient.do?command=list">재료 데이터</a>
	<br>
	<a href="<%= request.getContextPath() %>/jsonCookingStep.do?command=list">음식 조리 과정 데이터</a>
</body>
</html>