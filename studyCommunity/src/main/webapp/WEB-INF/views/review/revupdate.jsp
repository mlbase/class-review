
<%@page import="mul.com.sc.dto.RevBbsDto"%>
<%@page import="mul.com.sc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
UserDto mem = (UserDto)session.getAttribute("login");
if(mem == null){
%>	
	<script type="text/javascript">
	alert("로그인 해주세요");
	location.href = "login.do";
	</script>
<%	
}
%>
    
<%
RevBbsDto dto = (RevBbsDto)request.getAttribute("rbbs");
int seq = dto.getSeq();
%>

<!DOCTYPE html>
<html>
<head>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<h2 class="mt-5">후기게시글 수정</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class=" form-inline w-50 d-flex flex-column justify-content-center" action="revupdateAf.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="seq" value="<%=seq %>">
			<input type="hidden" name="userid" value="<%=mem.getId() %>">
			<div class="form-group border">
			  <input class="form-control form-control-lg border-bottom" style="border: none" type="text" name="title" id="inputLarge" value="<%=dto.getTitle() %>">			
			  <textarea rows="20" cols="82px" name="content" style="border: none" class="w-auto"><%=dto.getContent() %></textarea>
			  <div class="form-group">
			  
     				 <input class="form-control" multiple="multiple" type="file" name="revfile" accept="image/*"/>
    		  </div>
			</div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">수정하기</button>
            </div>
		</form>
	</div>   
</div> 

</body>
</html>



