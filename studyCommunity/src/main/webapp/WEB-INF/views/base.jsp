<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
<link rel="stylesheet" href="resources/css/bootstrap.min.css">
</head>
<body>

<script type="text/javascript">
function displayedAt(createdAt) {
	  const milliSeconds = new Date() - new Date(createdAt)
	  console.log(milliSeconds)
	  const seconds = milliSeconds / 1000
	  if (seconds < 60) return "방금 전"
	  const minutes = seconds / 60
	  if (minutes < 60) return Math.floor(minutes) + "분 전"
	  const hours = minutes / 60
	  if (hours < 24) return Math.floor(hours) + "시간 전"
	  const days = hours / 24
	  if (days < 7) return createdAt.substring(2, createdAt.indexOf(" "));
	}
</script>

<header>
	<jsp:include page="navbar.jsp" flush="false"/>
</header>

 
<div class="container mb-4">
    <div class="row">
        <div class="col-md-12 mt-1 d-flex flex-column justify-content-center align-items-center">
        	<c:choose>
				<c:when test="${ content == 'login' }">
					<jsp:include page="user/login.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'join' }">
					<jsp:include page="user/join.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'userDetail' }">
					<jsp:include page="user/userDetail.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'main' }">
					<jsp:include page="main.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'updateUser' }">
					<jsp:include page="user/updateUser.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'noticeList' }">
					<jsp:include page="notice/noticelist.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'noticedetail' }">
					<jsp:include page="notice/noticedetail.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'noticewrite' }">
					<jsp:include page="notice/noticewrite.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'noticeupdate' }">
					<jsp:include page="notice/noticeupdate.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'bbsList' }">
					<jsp:include page="bbs/bbslist.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'bbsdetail' }">
					<jsp:include page="bbs/bbsdetail.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'bbswrite' }">
					<jsp:include page="bbs/bbswrite.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'bbsupdate' }">
					<jsp:include page="bbs/bbsupdate.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'revbbs' }">
					<jsp:include page="review/revbbs.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'revwrite' }">
					<jsp:include page="review/revwrite.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'revdetail' }">
					<jsp:include page="review/revdetail.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'revupdate' }">
					<jsp:include page="review/revupdate.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'pdslist' }">
					<jsp:include page="pds/pdslist.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'pdswrite' }">
					<jsp:include page="pds/pdswrite.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'pdsdetail' }">
					<jsp:include page="pds/pdsdetail.jsp" flush="false"/>
				</c:when>
				<c:when test="${ content == 'pdsupdate' }">
					<jsp:include page="pds/pdsupdate.jsp" flush="false"/>
				</c:when>
			</c:choose>
        </div>
    </div>
</div>
<footer class="footer py-3 bg-dark" style="position: fixed; left: 0px; bottom: 0px; width:100%; height:60px;">
  <div class="container">
    <jsp:include page="footer.jsp" flush="false"/> 
  </div>
</footer>


</body>
</html>