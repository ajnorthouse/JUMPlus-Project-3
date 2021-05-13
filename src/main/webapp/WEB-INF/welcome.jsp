<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome!</title>
	<style><%@include file="/WEB-INF/css/Project3.css"%></style>
</head>
<body>
	<%@ include file="public/welcome-header.jsp" %>
	<main class="welcome">
		<h2>Welcome to DollarsBank!</h2>
		<a href="${pageContext.request.contextPath}/sign-in">Sign-In</a>
		<a href="${pageContext.request.contextPath}/sign-up">Create Account</a>
	</main>
	<%@ include file="public/welcome-footer.jsp" %>
</body>
</html>