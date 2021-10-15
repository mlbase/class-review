<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
</head>
<body>

<h2>회원가입</h2>

<form action="joinAf.do" method="post" id="loginForm">

<table border="1">

	<tr>
		<th>이메일</th>
		<td>
			<input type="email" name="email" id="email" size="20"><br>
			<p id="emailCheck" style="font-size: 8px"></p>
			<input type="button" id="emailCheckBtn" value="이메일확인">
		</td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td>
			<input type="password" name="pwd" id="pwd" size="20">
		</td>
	</tr>
	<tr>
		<th>패스워드확인</th>
		<td>
			<input type="password" name="pwd2" id="pwd2" size="20">
			<p id="pwdCheck" style="font-size: 8px"></p>
		</td>
	</tr>
	<tr>
		<th>닉네임</th>
		<td>
			<input type="text" name="nickname" id="nickname" size="20">
			<p id="nickCheck" style="font-size: 8px"></p>
			<input type="button" id="nickCheckBtn" value="닉네임확인">
		</td>
	</tr>
	<tr>
		<td colspan="2" align="center">
			<button type="button" id="submitBtn">회원가입</button>
		</td>
	</tr>
	
</table>

</form>

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
						
						$("#emailCheck").html("중복된 이메일 입니다").css("color", "red");
					} else {
						$("#emailCheck").html("사용 가능한 이메일 입니다.").css("color", "white");
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
						
						$("#nickCheck").html("중복된 닉네임 입니다").css("color", "red");
					} else {
						$("#nickCheck").html("사용 가능한 닉네임 입니다.").css("color", "white");
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
	    	$("#pwdCheck").html("비밀번호 확인").css("color", "white");
	    	pwCheck = true;
		} else {
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