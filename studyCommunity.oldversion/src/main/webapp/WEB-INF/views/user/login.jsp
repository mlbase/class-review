<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="https://unpkg.com/mvp.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="http://lab.alexcican.com/set_cookies/cookie.js" type="text/javascript" ></script>
</head>
<body>


<h2>Login Page</h2>

<div class="center">

<form action="loginAf.do" method="post">

<table border="1">
	<tr>
		<th>이메일</th>
		<td>
			<input type="email" id="email" name="email" size="20"><br>
			<input type="checkbox" id="chk_save_email"> save email
		</td>
	</tr>
	<tr>
		<th>패스워드</th>
		<td>
			<input type="password" id="pwd" name="pwd" size="20">
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="login">
			<a href="join.do">회원가입</a>
		</td>
	</tr>
</table>

</form>

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