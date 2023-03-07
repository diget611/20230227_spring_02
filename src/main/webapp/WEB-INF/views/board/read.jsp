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
		</fieldset>
	</form>
	<hr>
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${reply }" var="re">
				<tr>
				 	<td>${re.boardNum }</td>
				 	<td><a href="<%=request.getContextPath()%>/board/read?boardNum=${re.boardNum}">${re.boardTitle }</a></td>
				 	<td>${re.boardWriter }</td>
				 	<td>${re.boardDate }</td>
				 	<td>${re.boardReadcount }</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<script>
		$('.btn.reply').on('click', replyClickHandler);
		
		function replyClickHandler(){
			console.log(this);		// this >> (DOM)
			console.log($(this));	// this를 jquery 형태로 변환
			
			$.ajax({
				url: "<%=request.getContextPath()%>/board/insertReplyAjax",
				type: "post",
				data: $('#frmReply').serialize(),
				dataType: "json",	// success에 들어오는 데이터가 json 타입이고 이것을 js object로 변형해서 result에 실어줌
				success: function(result){
					//$('#frmReply')[0].reset();	// 작성 폼 초기화
					frmReply.reset();
					
					if(result) {
						alert("댓글 작성 완료");
					} else {
						alert("댓글 작성 실패");
					}
					// 답글 부분 화면 업데이트
					displayReply(result);
				},
				error: function(){
					
				}
			});
		}
		
		function displayReply(data){
			console.log(data);
			
			var htmlVal = '';
			for(i = 0; i < data.length; i++) {
				var reply = data[i];
				htmlVal += '<tr>';
				htmlVal += '<td>' + reply.boardNum + '</td>';
				htmlVal += '<td><a href="<%=request.getContextPath()%>/board/read?boardNum='+ reply.boardNum +'">'+ reply.boardTitle +'</a></td>';
				htmlVal += '<td>' + reply.boardWriter + '</td>';
				htmlVal += '<td>' + reply.boardDate + '</td>';
				htmlVal += '<td>' + reply.boardReadcount + '</td>';
				htmlVal += '</tr>';
			}
			
			$('tbody').html(htmlVal);
		}
	</script>
</body>
</html>