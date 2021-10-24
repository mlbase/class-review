<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>

<h2 class="my-5">로그인</h2>

<div class="col-12 d-flex flex-column justify-content-center">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class="mt-3 form-inline w-50" action="loginAf.do" method="post">
			<div class="form-group">
			  <div class="form-floating mb-3">
			    <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
			    <label for="floatingInput">Email address</label>
			  </div>
			  <div class="form-floating">
			    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
			    <label for="floatingPassword">Password</label>
			  </div>
			</div>
			<div class="form-group form-check mt-2">
                <input type="checkbox" class="form-check-input" id="chk_save_email" value="email 저장">
                <span>이메일 저장</span>
            </div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">로그인</button>
            </div>
            <div class="mt-5">
                 <p class="text-center">
                     계정이 없으신가요?
                     <a href="join.do">클릭해서 회원가입하기</a>
                 </p>
             </div>
		</form>
	</div>   
</div> 
                   

<script type="text/javascript">
const saved_email = $.cookie("savedEmail");
if(saved_email) {
	$("#email").val(saved_email);
	$("#chk_save_email").attr("checked", "checked")
}

$("#chk_save_email").click(function() {
	if( $("#chk_save_email").is(":checked")) {
		
		if( $("#email").val().trim() === "" ) {
			alert('email을 입력해 주십시오');
			$("#email").val().trim();
			$("#chk_save_email").prop("checked", false);
		}else {
			$.cookie("savedEmail", $("#email").val().trim(), { expires:7, path:'./' })
		}
	} else {
		$.removeCookie("savedEmail", { path: './' });
	}
	
})


</script>

</body>
</html>