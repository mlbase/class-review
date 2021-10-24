<%@page import="mul.com.sc.dto.UserDto"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>
<body>

<%
UserDto user = (UserDto)session.getAttribute("login");
if(user == null){
%>
	<script type="text/javascript">
	alert("로그인 해 주십시오");
	location.href = "login.do";
	</script>
<%
}
%>

<h2 class="mt-5">후기게시글 작성</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class=" form-inline w-50 d-flex flex-column justify-content-center" action="revwriteAf.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="userid" value="<%=user.getId() %>">
			<div class="form-group border">
			  <input class="form-control form-control-lg border-bottom" style="border: none" type="text" name="title" placeholder="여기에 제목을 작성해주세요" id="inputLarge">
			  <textarea rows="20" cols="82px" name="content" style="border: none" class="w-auto"></textarea>
			  <div class="form-group">
     				 <input class="form-control" multiple="multiple" type="file" name="revfile" accept="image/*"/>
    		  </div>
			</div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">글작성</button>
            </div>
		</form>
	</div>   
</div> 



</body>
</html>



