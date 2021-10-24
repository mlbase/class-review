<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2 class="my-5">회원 정보 수정</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class="mt-3 form-inline w-50" action="userUpdateAf.do" method="post" enctype="multipart/form-data" id="updateForm" accept="image/*">
			<input type="hidden" name="id" value="${ login.id }">
			<div class="form-group">
			  <label for="formFile" class="form-label">프로필 사진 변경</label>
	   		  <input class="form-control" type="file" name="fileload">
			</div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">정보수정</button>
            </div>
		</form>
	</div>   
</div> 


</body>
</html>