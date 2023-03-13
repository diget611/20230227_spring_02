<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
	session="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>여러개 마커 표시하기</title>
<script src="https://code.jquery.com/jquery-3.6.3.js"></script>
<script src="
https://cdn.jsdelivr.net/npm/verbal-expressions@1.0.2/dist/verbalexpressions.min.js
"></script>
</head>
<body>
	<script>
		const vExp = VerEx()
				   .startOfLine()
				   .range('2', '2')
				   .repeatPrevious(1)
				   .range('0', '6', '8', '8')
				   .repeatPrevious(1)
				   .maybe('-')
				   .range('0', '9')
				   .repeatPrevious(2)
				   .maybe('-')
				   .range('0', '9')
				   .repeatPrevious(6)
				   .maybe('-')
				   .range('0', '9')
				   .repeatPrevious(2)
				   .endOfLine();
		
		console.log(vExp);
		console.log(vExp.test('13-29-473728-91'));
	</script>
</body>
</html>
