<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 - 회원 목록</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<style>
	.f-3 {
		display: flex;
		width: 500px;
		height: 50px;
		flex-wrap: nowrap;
		align-items: center;
		text-align: center;
	}
	
	.f-3 div {
		width: 150px;
		border: 1px black solid;
	}
</style>
</head>
<body>
	<div class="f-3">
		<div>아이디</div>
		<div>이름</div>
		<div>이메일</div>
	</div>
	<c:forEach items="${memberlist }" var="member">
		<div class="f-3">
			<div><a href="<%=request.getContextPath()%>/member/info?id=${member.id}">${member.id }</a></div>
			<div>${member.name }</div>
			<div>${member.email }</div>
		</div>	
	</c:forEach>
</body>
</html>