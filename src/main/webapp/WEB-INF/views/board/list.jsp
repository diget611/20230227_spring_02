<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일</th>
				<th>조회수</th>
			</tr>
		<tbody>
			<c:forEach items="${list }" var="board">
			 	<tr>
				 	<td>${board.boardNum }</td>
				 	<td><a href="<%=request.getContextPath()%>/board/read?boardNum=${board.boardNum}">${board.boardTitle }</a></td>
				 	<td>${board.boardWriter }</td>
				 	<td>${board.boardDate }</td>
				 	<td>${board.boardReadcount }</td>
			 	</tr>
			</c:forEach>
		</tbody>
	</table>
	<hr>
	<c:forEach begin="${paging.start }" end="${paging.end }" var="page" step="1">
		${page }
		<c:if test="${paging.end ne page }">
		|
		</c:if>
	</c:forEach>
</body>
</html>