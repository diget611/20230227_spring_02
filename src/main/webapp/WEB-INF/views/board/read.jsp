<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<h1>${board.boardNum }번 게시글</h1>
	<div>${board.boardTitle } | ${board.boardWriter }</div>
	<div>${board.boardContent }</div>
	
	<form id="frmReply">
		<fieldset>
			<legend>답글작성</legend>
			<div><input type="text" name="boardTitle"></div>
			<div><input type="text" name="boardContent"></div>
			<input type="hidden" name="boardNum" value="${board.boardNum }">
			<button type="button" class="btn reply">답글작성</button>
			<button type="reset">초기화</button>
		</fieldset>
	</form>
	
	<script>
		$('.btn.reply').on('click', replyClickHandler);
		
		function replyClickHandler(){
			console.log(this);		// this >> (DOM)
			console.log($(this));	// this를 jquery 형태로 변환
			
			$.ajax({
				url: "<%=request.getContextPath()%>/board/insertReplyAjax",
				type: "post",
				data: $('#frmReply').serialize(),
				success: function(result){
					//$('#frmReply')[0].reset();	// 작성 폼 초기화
					frmReply.reset();
					if(result == "ok") {
						alert("댓글 작성 완료");
					} else {
						alert("댓글 작성 실패");
					}
				},
				error: function(){
					
				}
			});
		}
	</script>
</body>
</html>