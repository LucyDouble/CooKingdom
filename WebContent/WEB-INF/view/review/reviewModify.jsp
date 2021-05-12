<%@page import="ckd.member.vo.User"%>
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
<title>리뷰 수정</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%
                User user = (User)session.getAttribute("User");
				String email = user.getEmail();
%>
<div class="wrapper">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="reviewReg">     
            <h3 id="head">리뷰수정</h3>
            <div id="line"></div>
            <div id="frmCS">
                <form id="frm" enctype="multipart/form-data">
                	<input type="hidden" name="reviewNo" id="reviewNo" value="${reviewNo}" />
                	<input type="hidden" name="recipeCode" id="recipeCode" value="${recipeCode}" />
                	<input type="hidden" name="email" id="email" value=<%=email %> />
                	<input type="hidden" name="nickname" id="nickname" value="${nickname}" />
                    <table>
                        <tr class="tr1">
                            <td><label>제목</label></td>
                            <td class="inp" id="subinp"><input type="text" style="width: 365px;" name="reviewSubject" id="reviewSubject" value="${reviewSubject }" /></td>
                        </tr>
                        <tr></tr>
                        <tr class="tr1">
                            <td><label>파일선택</label></td>
                            <td class="inp"><input type="file" name="reviewPhoto" id="reviewPhoto"></td>
                        </tr>
                        <tr></tr>
                        <tr class="tr1">
                            <td rowspan="10"><label>내용</label></td>
                            <td class="inp"><textarea placeholder="1000자까지만 허용합니다." cols="50" rows="10" name="reviewContent" id="reviewContent" >${reviewContent}</textarea></td>
                        </tr>
                    </table>    
                    <div id="btn">
                    	<input type="button" id="btnSubmit" value="글 수정" onclick="goList();">
                	</div>                
                </form>             
            </div>
        </div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
	<script type="text/javascript">
	
		function goList(){
			
			var formData = new FormData(document.getElementById("frm"));
			formData.append('reviewNo',document.getElementById("reviewNo").value);
			formData.append('recipeCode',document.getElementById("recipeCode").value);
			formData.append('email',document.getElementById("email").value);
			formData.append('reviewSubject',document.getElementById("reviewSubject").value);
			formData.append('reviewPhoto',document.getElementById("reviewPhoto").files[0]);
			formData.append('reviewContent',document.getElementById("reviewContent").value);
			alert("글 수정 성공!");
				
			$.ajax({
				url: "<%=request.getContextPath()%>/reviewModifyDo",
				type:"POST",
				cache: false,
				processData: false,
	            contentType: false,
				data : formData,
				success : function(data){
					console.log(data);
					history.back();
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