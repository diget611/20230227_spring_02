<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시글 작성</h1>
	<!-- file upload : enctype -->
	<form action="insert" method="post" enctype="multipart/form-data">
		<input type="text" name="boardTitle" placeholder="title"><br>
		<input type="text" name="boardContent" placeholder="content"><br>
		<!-- file의 경우 name은 vo와 다른 이름으로 작성 -->
		<input type="file" name="report" multiple="multiple"><br>
		<button type="submit">게시글 등록</button>
	</form>
</body>
</html>