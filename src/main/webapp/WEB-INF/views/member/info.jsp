<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내 정보 보기</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
</head>
<body>
	<h1>내 정보</h1>
	<form id="frmInfo" method="get">
		<input value="${info.id }" type="text" name="id" placeholder="id" readonly="readonly"><br>
		<input value="${info.passwd }" type="password" placeholder="pass" readonly="readonly"><br>
		<input value="${info.name }" type="text" placeholder="name" readonly="readonly"><br>
		<input value="${info.email }" type="text" placeholder="email" readonly="readonly"><br>
		<button type="button" onclick="frmSubmit('update');">수정</button>
		<button type="button" onclick="frmSubmit('delete');">탈퇴</button>
		<br>
		<button type="button">수정</button>
		<button type="button">탈퇴</button>
	</form>
	
	<script>
//		$('button').get(2).click('update', frmSubmit2);
//		$('button').get(3).click('delete', frmSubmit2);
		$('button').eq(2).click('update', frmSubmit2);
		$('button').eq(3).click('delete', frmSubmit2);
		
		function frmSubmit(targetEle){
			// form.action = targetEle;
			// document.getElementById("frmInfo").action = targetEle;
			// $("#frmInfo").attr("action", targetEle);
			// $("#frmInfo").submit();
			frmInfo.action = targetEle;
			frmInfo.submit();
			console.log(this); // this : window 객체
		}
		
		function frmSubmit2(event){
			frmInfo.action = event.data;
			frmInfo.submit();
			console.log(this); // this : click이 발생한 시점의 element
		}
	</script>
</body>
</html>