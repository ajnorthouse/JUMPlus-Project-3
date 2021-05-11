<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome!</title>
</head>
<body>
	<%@ include file="welcome-header.jsp" %>
	<div class="welcome">
		<h2>Welcome Page</h2>
		<a href="<%= request.getContextPath()%>/sign-in">Sign-In</a>
		<a href="<%= request.getContextPath()%>/sign-up">Create Account</a>
		<br/>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>