<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<script>
	goMain();
	
	function goMain() {
		var link = '<%= request.getContextPath() %>/cookingDom?command=Main';
		location.href=link;
	};
	</script>
</body>
</html>