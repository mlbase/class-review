<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>


<h2 class="my-5">회원가입</h2>
<div class="col-12 d-flex flex-column justify-content-center my-5">
	<div class="login-card-light p-3 rounded d-flex flex-column justify-content-center align-items-center">
		<form class="mt-3 form-inline w-50" action="joinAf.do" method="post">
			<div class="form-group">
			  <div class="form-floating mb-5">
			    <input type="email" class="form-control" id="email" name="email" placeholder="name@example.com">
			    <label for="floatingInput">이메일</label>
			    <div class="d-flex justify-content-between mt-2">
			    	<div id="emailCheck"> </div>
			    	<button type="button" class="btn btn-primary" id="emailCheckBtn">중복확인</button>
			    </div>
			  </div>
			  <div class="form-floating mb-5">
			    <input type="text" class="form-control" id="nickname" name="nickname" placeholder="nickname">
			    <label for="floatingInput">닉네임</label>
			    <div class="d-flex justify-content-between mt-2">
			    	<div id="nickCheck"> </div>
			    	<button type="button" class="btn btn-primary" id="nickCheckBtn">중복확인</button>
			    </div>
			  </div>
			  <div class="form-floating my-5">
			    <input type="password" class="form-control" id="pwd" name="pwd" placeholder="Password">
			    <label for="floatingPassword">비밀번호</label>
			  </div>
			  <div class="form-floating my-5">
			    <input type="password" class="form-control" id="pwd2" name="pwd2" placeholder="Password">
			    <label for="floatingPassword">비밀번호확인</label>
			    <div id="pwdCheck"> </div>
			  </div>
			</div>
            <div class="mt-5 d-flex flex-column justify-content-center">
                <button class="btn btn-lg btn-primary" type="submit">회원가입</button>
            </div>
		</form>
	</div>   
</div> 


<script type="text/javascript">
$(document).ready(function() {
	let emailCheck = false;
	let nickCheck = false;
	let pwCheck = false;
	$("#emailCheckBtn").click(function() {
		const email = $("#email").val().trim();
		if(email) {
			$.ajax({
				url: "emailCheck.do",
				type: "post",
				data: { email },
				success: (data) => {
					if(data.trim() === "NO") {
						$("#email").val("").focus();
						$("#email").removeClass("is-valid");
						$("#email").addClass("is-invalid");
						$("#emailCheck").html("중복된 이메일 입니다").css("color", "red");
					} else {
						$("#email").removeClass("is-invalid");
						$("#email").addClass("is-valid");
						$("#emailCheck").html("사용 가능한 이메일 입니다.").css("color", "yellowgreen");
						emailCheck = true;
					}
				},
				error: () => {
					alert("error");
				}
			});
		}
	});
	$("#nickCheckBtn").click(function() {
		const nick = $("#nickname").val().trim();
		if(nick) {
			$.ajax({
				url: "nickCheck.do",
				type: "post",
				data: { nickname:nick },
				success: (data) => {
					if(data.trim() === "NO") {
						$("#nickname").val("").focus();
						$("#nickname").removeClass("is-valid");
						$("#nickname").addClass("is-invalid");
						$("#nickCheck").html("중복된 닉네임 입니다").css("color", "red");
					} else {
						$("#nickname").removeClass("is-invalid");
						$("#nickname").addClass("is-valid");
						$("#nickCheck").html("사용 가능한 닉네임 입니다.").css("color", "yellowgreen");
						nickCheck = true;
					}
				},
				error: () => {
					alert("error");
				}
			});
		}
	});
	
	$("#pwd2").on("propertychange change keyup paste input", () => {
		let pwd = $("#pwd").val();
		let pwd2 = $("#pwd2").val()
	    if(pwd === pwd2) {
	    	$("#pwd2").removeClass("is-invalid")
	    	$("#pwd2").addClass("is-valid")
	    	$("#pwdCheck").html("비밀번호 확인").css("color", "yellowgreen");
	    	pwCheck = true;
		} else {
			$("#pwd2").removeClass("is-valid")
	    	$("#pwd2").addClass("is-invalid")
			$("#pwdCheck").html("비밀번호를 확인해주세요").css("color", "red");
			pwCheck = false;
		}
	}) 
	$("#submitBtn").click(() => {
		if(!emailCheck) {
			alert("이메일 중복확인을 해주세요");
			$("#email").focus();
		} else if(!pwCheck) {
			alert("패스워드를 확인 해주세요");
			$("#pwd2").focus();
		} else if(!nickCheck) {
			alert("닉네임 중복확인을 해주세요");
			$("#nickname").focus();
		} else {
			$("#loginForm").submit();
		}
	})
})
</script>







</body>
</html>