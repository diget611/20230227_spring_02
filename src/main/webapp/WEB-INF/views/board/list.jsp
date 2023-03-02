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
	<c:forEach items="${list }" var="board">
	 ${board.boardNum } | ${board.boardTitle } | ${board.boardWriter } | ${board.boardDate } <br>
	</c:forEach>
	<hr>
	<c:forEach begin="${paging.start }" end="${paging.end }" var="page" step="1">
		${page }
		<c:if test="${paging.end ne page }">
		,
		</c:if>
	</c:forEach>
</body>
</html>