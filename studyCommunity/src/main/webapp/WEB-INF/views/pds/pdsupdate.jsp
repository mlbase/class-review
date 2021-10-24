<%@page import="mul.com.sc.dto.PdsDto"%>
<%@page import="mul.com.sc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
PdsDto pds = (PdsDto)request.getAttribute("pds");
int seq = (Integer)request.getAttribute("seq");
UserDto user = (UserDto)session.getAttribute("login");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="./css/table.css">
</head>
<body>
<h2 class="mt-5">게시글 수정</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class=" form-inline w-50 d-flex flex-column justify-content-center" action="pdsupdateAf.do" method="post" enctype="multipart/form-data">
			<input type="hidden" name="seq" value="<%=pds.getSeq() %>">
			<input type="hidden" name="userid" value="<%=user.getId() %>">
			<div class="form-group border">
			  <input class="form-control form-control-lg border-bottom" style="border: none" type="text" value="<%=pds.getTitle() %>" id="inputLarge" name="title">
			<div class="form-group">
      		  <input class="form-control" type="file" id="formFile" name="fileload">
			  <textarea rows="20" cols="78px" name="content" style="border: none" class="w-auto"><%=pds.getContent() %></textarea>
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






