<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<script>
	goOrderList();
	
	function goOrderList() {
		alert("정상 결제 되었습니다!")
		var link = '<%= request.getContextPath() %>/orderListInquiry';
		location.href=link;
	};
	</script>
</body>
</html>