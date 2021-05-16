<%@page import="ckd.member.vo.User"%>
<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/reviewRegister.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<!-- TODO -->
<%-- Member m = (Member)session.getAttribute("member"); --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
<%
        User user = (User)session.getAttribute("User");
		String email = user.getEmail();
%>
<%
	int recipeCode2 = Integer.parseInt(request.getParameter("recipeCode"));
%>
<div class="wrapper">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="reviewReg">     
            <h3 id="head">리뷰 작성</h3>
            <div id="line"></div>
            <div id="frmCS">
                <form id="frm" enctype="multipart/form-data">
                <!-- TODO -->
                	<input type="hidden" name="email" value= <%=email %> id="email"/>
                	<!-- ${param.email}-->
                	<input type="hidden" name="recipeCode" value= <%=recipeCode2%>  id="recipeCode" />        
                	<!--  ${param.recipeCode}  -->	
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
			var rsubject = document.getElementById("reviewSubject").value;
			var rContent = document.getElementById("reviewContent").value;
			if(rsubject == "" || rsubject == "null" ){
				alert("제목을 입력해주세요!");
				return;
			}else if(rContent == "" || rContent == "null" ){
				alert("내용을 입력해주세요!");
				return;
			}

			
			var formData = new FormData(document.getElementById("frm"));
			formData.append('email',document.getElementById("email").value);
			formData.append('recipeCode',document.getElementById("recipeCode").value);
			formData.append('reviewSubject',document.getElementById("reviewSubject").value);
			formData.append('reviewPhoto',document.getElementById("reviewPhoto").files[0]);
			formData.append('reviewContent',document.getElementById("reviewContent").value);
			alert("글 등록 성공!");
			var i = document.getElementById("recipeCode").value;
			console.log(i);
			
			
			$.ajax({
				url: "<%=request.getContextPath()%>/reviewRegister",
				type:"POST",
				cache: false,
				processData: false,
	            contentType: false,
				data : formData,
				success : function(data){
					$.ajax({
						url : "<%=request.getContextPath()%>/recipeinquery.do",
						type : "POST",
						data : {
							recipeCode : i
						},
						success : function(data){
							console.log("잘갔음!");
							history.back();
						}
					});
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