<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/WEB-INF/view/main/header.jsp"></jsp:include>
		<div style="clear:both;">
			<img
				src="https://ww.namu.la/s/1bd7453343646f106926d6d05f85cd77cb28b0be4679593ca208a4cd0fbd88075e5592f731f61a75f2677f1a692e1d17c97409aac72224c573e3592067df7a17152fe7cc9bfd43527c0b175a527bcc662c79b3c51c73fa0893bff1f6d6d322ed">
			<br>${errorMsg }<br> <a
				href="<%=request.getContextPath()%>/index.jsp"><strong style="cursor:pointer; ">홈으로 이동</strong></a>

		</div>
		<jsp:include page="/WEB-INF/view/main/footer.jsp"></jsp:include>
	</div>
</body>
</html>