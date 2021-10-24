<%@page import="mul.com.sc.dto.BbsDto"%>
<%@page import="mul.com.sc.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	BbsDto dto = (BbsDto)request.getAttribute("bbs"); 
	UserDto user = (UserDto)session.getAttribute("login");
%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2 class="mt-5">게시글 수정</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class=" form-inline w-50 d-flex flex-column justify-content-center" action="bbsupdateAf.do" method="post">
			<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
			<input type="hidden" name="userId" value="<%=user.getId() %>">
			<div class="form-group border">
			  <input class="form-control form-control-lg border-bottom" name="title" style="border: none" type="text" placeholder="여기에 제목을 작성해주세요" value="<%=dto.getTitle() %>">
			  <textarea rows="20" cols="82px" name="content" style="border: none" class="w-auto form-control"><%=dto.getContent() %></textarea>
			</div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">수정</button>
            </div>
		</form>
	</div>   
</div> 


</body>
</html>