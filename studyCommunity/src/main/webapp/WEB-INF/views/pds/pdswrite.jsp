<%@page import="mul.com.sc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
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

<h2 class="mt-5">게시글 작성</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class=" form-inline w-50 d-flex flex-column justify-content-center" action="pdsupload.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="userid" value="<%=user.getId() %>">
			<div class="form-group border">
			  <input class="form-control form-control-lg border-bottom" style="border: none" type="text" placeholder="여기에 제목을 작성해주세요" id="inputLarge" name="title">
			<div class="form-group">
      		  <input class="form-control" type="file" id="formFile" name="fileload">
			  <textarea rows="20" cols="78px" name="content" style="border: none" class="w-auto"></textarea>
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


