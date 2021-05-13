<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Sign in</title>
	<style><%@include file="/WEB-INF/css/Project3.css"%></style>
</head>
<body>
	<%@ include file="welcome-header.jsp" %>
	<main class="no-nav">
		<form method="POST" class="main-content">
			<h2>Login Page</h2>
			<section>
				<label for="username-input">User Id:</label>
				<input type="text" id="username-input" name="username-input"
					placeholder="jsmith" title="username"
					value="${requestScope.username}">
			</section>
			<section>
				<label for="password-input">Password:</label>
				<input type="password" id="password-input" name="password-input"
					title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
					placeholder="P@ssw0rd"
					value="${requestScope.password}">
			</section>
			<%@ include file="result.jsp" %>
			<button type="submit">Submit</button>
		</form>
	</main>
	<%@ include file="welcome-footer.jsp" %>
</body>
</html>