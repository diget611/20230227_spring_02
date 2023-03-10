<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기본 화면 구성</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/kh_layout.css"/>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/header.css"/>
</head>
<body>
	<jsp:include page="header.jsp"/>
	<jsp:include page="section.jsp"/>
	<jsp:include page="footer.jsp"/>
</body>
</html>