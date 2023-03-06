<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script>
	var msg = "${msg}"
	if (msg) {
		alert(msg);
	}
	location.href="<%=request.getContextPath()%>/";
</script>