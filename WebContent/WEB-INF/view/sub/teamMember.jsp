<link href="css/reset.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CookingDom Developer</title>

<style>
	body{ width: 1440px; margin: 0 auto;}
		#teamM {
		    text-align: center;
		}
		#memberP{ width: 1000px; margin: 0 auto;}
		.t1 {
		    display: inline-block;
		    margin-top: 30px;
		    margin-left: 30px;
		    text-align: center;
		}
		#m4{
		    margin-left: 150px;
		}
		.t2{
			text-align : center;
		    display: inline-block;
		    margin-top: 30px;
		    margin-right: 30px;
		}

</style>

</head>
<body>
<div class="wrapper">
	<jsp:include page="../main/header.jsp"></jsp:include>
	<br><br><br><br>

     <div id="section">
        <div id="teamM">
           <h1>요리하시조</h1>
        </div>
        <div id="memberP">
            <ul>
                <li class="t1"><h3>강수목</h3><img src="image/team/수목.png" ></li>
                <li class="t1"><h3>고현민(조장)</h3><img src="image/team/현민.png" ></li>
                <li class="t1"><h3>곽서현</h3><img src="image/team/서현.png" ></li>
                <br>
                <li class="t2" id="m4"><h3>김세훈</h3><img src="image/team/세훈.png" ></li>
                <li class="t2"><h3>박준태</h3><img src="image/team/준태.png" ></li>
            </ul>
        </div>
    </div>

	<jsp:include page="../main/footer.jsp"></jsp:include>
</div>	
</body>
</html>