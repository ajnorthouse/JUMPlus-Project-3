<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sign in</title>
</head>
<body>
	<%@ include file="welcome-header.jsp" %>
	<div class="login">
		<h2>Login Page</h2>
		
		<form method="POST">
		
			<label for="username-input">User Id:</label>
			<input type="text" id="username-input" name="username-input"
				placeholder="jsmith" title="username"
				value="${requestScope.username}">
	
			<label for="password-input">Password:</label>
			<input type="password" id="password-input" name="password-input"
				title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
				placeholder="P@ssw0rd"
				value="${requestScope.password}">
			
			<button type="submit">Submit</button>
		</form>
		<%@ include file="result.jsp" %>
	</div>
	<%@ include file="footer.jsp" %>
</body>
</html>