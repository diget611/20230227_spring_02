<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>

	<P>The time on the server is ${serverTime}.</P>

	<script>
		var msg = "${alerMsg}"
		if (msg) {
			alert(msg);
		}
		
		var msg2 = "${msg}"
			if (msg2) {
				alert(msg2);
			}
	</script>
</body>
</html>
