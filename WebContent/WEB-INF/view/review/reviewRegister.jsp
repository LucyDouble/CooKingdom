<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/reviewRegister.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%--
	//TODO reviewSubjectrequest.getSession();
--%>
<div class="wrapper">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="reviewReg">     
            <h3 id="head">리뷰 작성</h3>
            <div id="line"></div>
            <div id="frmCS">
                <form id="frm" enctype="multipart/form-data">
                	<input type="hidden" name="email" value= "abc" id="email"/>
                	<input type="hidden" name="recipeCode" value= "123456"  id="recipeCode" />        	
                    <table>
                        <tr class="tr1">
                            <td><label>제목</label></td>
                            <td class="inp" id="subinp"><input type="text" style="width: 365px;" name="reviewSubject" id="reviewSubject"  /></td>
                        </tr>
                        <tr></tr>
                        <tr class="tr1">
                            <td><label>파일선택</label></td>
                            <td class="inp"><input type="file" name="reviewPhoto" id="reviewPhoto"></td>
                        </tr>
                        <tr></tr>
                        <tr class="tr1">
                            <td rowspan="10"><label>내용</label></td>
                            <td class="inp"><textarea placeholder="1000자까지만 허용합니다." cols="50" rows="10" name="reviewContent" id="reviewContent"></textarea></td>
                        </tr>
                    </table>    
                    <div id="btn">
                    	<input type="button" id="btnSubmit" value="글 등록" onclick="goList();">
                	</div>                
                </form>             
            </div>
        </div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
	<script type="text/javascript">
	
		function goList(){
			
			var formData = new FormData(document.getElementById("frm"));
			formData.append('email',document.getElementById("email").value);
			formData.append('recipeCode',document.getElementById("recipeCode").value);
			formData.append('reviewSubject',document.getElementById("reviewSubject").value);
			formData.append('reviewPhoto',document.getElementById("reviewPhoto").files[0]);
			formData.append('reviewContent',document.getElementById("reviewContent").value);
			alert(
					"***********JSP에서 넘어갑니다~~~***************"+
					"email: "+document.getElementById("email").value +"<br>"+
					"recipeCode: "+document.getElementById("recipeCode").value +"<br>"+
					"reviewSubject: "+document.getElementById("reviewSubject").value +"<br>"+
					"reviewPhoto: "+document.getElementById("reviewPhoto").value +"<br>"+
					"reviewContent: "+document.getElementById("reviewContent").value +"<br>"
			);
			
			
			$.ajax({
				url: "<%=request.getContextPath()%>/reviewRegister",
				type:"POST",
				cache: false,
				processData: false,
	            contentType: false,
				data : formData,
				success : function(data){
					console.log(data);
					window.location = "<%=request.getContextPath()%>/reviewList";
				},
				error : function(request, status, error){
					console.log(error);
				}
			});
		}
	</script>
</div>
</body>
</html>