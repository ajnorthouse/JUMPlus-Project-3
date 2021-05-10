<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Welcome!</title>
</head>
<body>
	<div class="welcome">
		<h1>Welcome Page</h1>
		<a href="<%= request.getContextPath()%>/Login">Sign-In</a>
		<a href="<%= request.getContextPath()%>/CreateAccount">Create Account</a>
		<br/>
	</div>
</body>
</html>