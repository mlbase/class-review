<%@page import="mul.com.sc.dto.PdsDto"%>
<%@page import="mul.com.sc.dto.UserDto"%> 
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
PdsDto pds = (PdsDto)request.getAttribute("pds");
%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>

<%
UserDto user = (UserDto)session.getAttribute("login");
%>


<div class="container d-flex flex-column justify-content-center align-items-center">
    <div class="row w-100 d-flex justify-content-center">
        <div class="col-xs-8 d-flex justify-content-end w-75">
        	<a class="mt-5 mb-2 fs-6" style="color:#787878;text-decoration: none;">학습 자료실</a>
        </div>
        <div class="col-xs-12 d-flex justify-content-between w-75 px-4 pt-2 pb-2 bg-secondary border-dark">
        	<div><span><%=pds.getNickname() %></span></div>
	        <div><span><%=pds.getRegdate().substring(0, pds.getRegdate().indexOf(".")) %></span></div>
	        <div>
	        	<span>조회: <%=pds.getReadcount() %></span>
	        </div>
        </div>
        <div class="col-xs-12 d-flex justify-content-between w-75 px-4 pb-2 bg-secondary border-bottom border-dark mb-3">
        	<div>
        		<span class="text-primary" type="button" onclick="filedownload('<%=pds.getNewfilename() %>', '<%=pds.getFilename() %>', <%=pds.getSeq() %>)"><%=pds.getFilename() %></span>
        	</div>
	        <div>
	        	<span>다운로드: <%=pds.getDowncount() %></span>
	        </div>
        </div>
        <div class="col-xs-12 w-75 pb-5 mb-5 bg-white border-dark mb-3">
        	<%
			if(user != null && user.getNickname().equals(pds.getNickname())){
			%>
			<div class="d-flex justify-content-end">
				<div>
	        		<span onclick="updatepds(<%=pds.getSeq() %>)" style="cursor: pointer;">수정</span>
	        		<span class="mx-2">|</span>
	        		<span onclick="deletepds(<%=pds.getSeq() %>)" style="cursor: pointer;">삭제</span>
        		</div>
        	</div>
			<%
			 } 
			%>
        	<div style="height:200px;" class="mb-5">
        		<h1 class="m-5"><%=pds.getTitle()%></h1>	
        	</div>
        	<div class="mx-5 d-flex flex-column"> 
        		<%
				if(pds.getContent() != null && !pds.getContent().equals("")){
				%>
				<tr><%=pds.getContent() %><tr>
				<%
				}
				%>
        	</div>
        </div>
        <div class="col-md-12 d-flex justify-content-end w-75 mb-5">
        	<button type="button" class="btn btn-outline-primary mx-3" onclick="location.href='pdslist.do'">목록</button>
        	<button type="button" class="btn btn-primary">글쓰기</button>
        </div>
    </div>
    <div class="row mt-5 d-flex justify-content-center w-75">
        <div class="col-xs-12 border-bottom pb-3">
        	<span><i class="far fa-comment"></i> 댓글 (<span id="commentCount"></span>)</span>
        </div>
        <div class="col-xs-12" id="commentContainer">
        </div>
        <div class="col-xs-12 mt-3">
        	<div class="form-group d-flex justify-content-center mb-5 pb-5">
        	  	<%
				if(user != null){
				%>
				<div class="d-flex justify-content-center align-items-center text-primary me-3" style="width:120px; height:100px; font-size:23px;"><%=user.getNickname() %></div>
				<textarea class="form-control" id="commentContent" rows="2"></textarea>
				<button id="commentBtn" type="button" class="btn btn-primary ms-3" style="width:120px;height: 100px;">등록</button>
				<%
				 } else {
				 %>
				 <textarea  class="form-control" placeholder="로그인해주세요" id="commentContent" rows="2"></textarea>
				 <button id="commentBtn" type="button" class="btn btn-primary ms-3 disabled" style="width:120px;height: 100px;">등록</button>
				 <%
				 }
				%>
				
		    </div>
        </div>
    </div>
</div>


<script type="text/javascript">
function filedownload(newfilename, filename, seq) {
	location.href = "fileDownload.do?newfilename=" + newfilename + "&filename=" + filename + "&seq=" + seq;	
}
</script>

<script type="text/javascript">
function updatepds(seq) {	
	location.href = "pdsupdate.do?seq=" + seq;
}
function deletepds(seq) {
	$.ajax({
    	type:"POST",
        url:"commentAllDelete.do",
        data:{
        	pdsseq:<%=pds.getSeq() %>,
            bbschoice: 2					
        },
        beforeSend:function() {
	        console.log("삭제중...");
	    },
	    complete:function() {
	        console.log("삭제완료");
	    },
        success:function(data) {
            if(data === "YES") {
                console.log("comment가 정상적으로 삭제되었습니다.");
            } else {
            	console.log("삭제실패");
            }
        }
    });
	location.href = "pdsdelete.do?seq=" + seq;
}
</script>

<%
if(user != null){
%>
<script type="text/javascript">
$("#commentBtn").on("click", function() {
	const commentVal = $("#commentContent").val();
	if(!commentVal) {
		alert("내용이 없습니다.")
		$("#commentContent").focus();
	} else {
		$.ajax({
	    	type:"POST",
	        url:"commentWrite.do",
	        data:{
	            content:$("#commentContent").val(),
	            pdsseq:<%=pds.getSeq() %>,
	            userid: <%=user.getId() %>,
	            bbschoice: 2
	        },
	        beforeSend:function() {
		        console.log("댓글 작성중...");
		    },
		    complete:function() {
		        console.log("작성완료");
		    },
	        success:function(data) {
	            if(data === "YES") {
	                console.log("comment가 정상적으로 입력되었습니다.");
	                getAllComment();
	            } else {
	            	console.log("답글 작성 실패");
	            	getAllComment();
	            }
	        }
	    });
	}
    $("#commentContent").val("");
});
</script>
<%
 } 
%>


<script type="text/javascript">
const getAllComment = () => {
	$.ajax({
		type:"POST",
		async: true,
		contentType: "application/x-www-form-urlencoded; charset=UTF-8",
		url: "getAllComment.do",
		data: { bbschoice: 2, pdsseq: <%=pds.getSeq() %> },
		beforeSend:function() {
	        console.log("댓글 로딩중...");
	    },
	    complete:function() {
	        console.log("로딩완료");
	    },
	    success: ( data ) => {
	    	const comments = JSON.parse(data).comments;
	    	if(!comments.length) {
	    		$("#commentCount").html("0");
	    	} else {
	    		$("#commentContainer").empty();
    			$("#commentCount").html(comments.length);
	    		for(i = 0; i < comments.length; i++) {
	    			const regdate = displayedAt(comments[i].regdate)
	    			let writer = "";
	    			if( comments[i].nickname === '<%=pds.getNickname() %>') {
	    				writer = '<span class="badge bg-secondary" style="font-size:12px;">작성자</span>';
	    			}
	    			const commentDiv = $(
	    					'<div class="d-flex flex-column py-2 px-3 border-bottom w-100"><span class="mb-2"><a class="fs-5" style="text-decoration: none;">' + comments[i].nickname + " " + writer + '</a> <span class="fs-6" style="color:rgba(0, 0, 0, 0.3)">' + regdate + '</span></span><span class="my-4">' + comments[i].content + '</span></div>'
	    				);
	    			$("#commentContainer").append(commentDiv)
	    		}
	    	}
	    }
	})
}
getAllComment();

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
	  if (days < 7) return createdAt.substring(0, createdAt.indexOf(" "));
}
</script>


</body>
</html>




