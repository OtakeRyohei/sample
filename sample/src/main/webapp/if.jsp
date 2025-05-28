<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ifSample</title>
</head>
<body>
<li>あなたの得点は<c:out value = "${score}"/>です</li>
	<c:if test="${score > 60}" >
		<span style="color:Red;">合格です</span>
		</c:if>
</body>
</html>