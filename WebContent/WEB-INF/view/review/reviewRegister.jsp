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

</head>
<body>
<div class="wrapper">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<div id="reviewReg">     
            <h3 id="head">리뷰 작성</h3>
            <div id="line"></div>
            <div id="frmCS">
                <form  action="<%=request.getContextPath() %>/reviewRegister" method="post" enctype="multipart/form-data">
                	<input type="hidden" name="email" value= "abc"  />
                	<input type="hidden" name="recipeCode" value= 123456  />
                	
                    <table>
                        <tr class="tr1">
                            <td><label>제목</label></td>
                            <td class="inp" id="subinp" name="reviewSubject"><input type="text" style="width: 365px;" /></td>
                        </tr>
                        <tr></tr>
                        <tr class="tr1">
                            <td><label>파일선택</label></td>
                            <td class="inp"><input type="file" name="rfilepath"></td>
                        </tr>
                        <tr></tr>
                        <tr class="tr1">
                            <td rowspan="10"><label>내용</label></td>
                            <td class="inp"><textarea placeholder="1000자까지만 허용합니다." cols="50" rows="10" name="reviewContent"></textarea></td>
                        </tr>
                    </table>
                    <div id="btn">
                        <button type="submit" id="btnSubmit" onclick="<%=request.getContextPath()%>/">글 등록</button>
                    </div>
                </form>
            </div>
        </div>
	<jsp:include page="../main/footer.jsp"></jsp:include>
</div>
</body>
</html>