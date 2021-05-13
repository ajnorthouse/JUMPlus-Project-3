<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register Account</title>
	<style><%@include file="/WEB-INF/css/Project3.css"%></style>
</head>
<body>
	<%@ include file="welcome-header.jsp" %>
	<main class="no-nav">
		<form method="POST" class="main-content">
		<h2>Create Account</h2>
			<section>
				<label for="name-input">Name:</label>
				<input type="text" id="name-input" name="name-input" 
					placeholder="John Smith" title="First name followed by Last name"
					value="${requestScope.name}">
			</section>
			<section>
				<label for="contactNumber-input">Contact Number:</label>
				<input type="tel" id="contactNumber-input" name="contactNumber-input" 
					title="Phone Number with Area code, dashes between each set of numbers"
					placeholder="123-456-7890" value="${requestScope.contactNum}">
			</section>
			<section>
				<label for="username-input">User Id: </label>
				<p id="password-requirements">Username Requirements:</p>
				<ul>
					<li>8 total characters</li>
					<li>One letter</li>
					<li>One number</li>
					<li>NO special symbols</li>
				</ul>
				<input type="text" id="username-input" name="username-input"
					placeholder="jsmith" title="username"
					value="${requestScope.username}">
			</section>
			<section>
				<label for="password-input1">Password: </label>
				<p id="password-requirements">Password Requirements:</p>
				<ul>
					<li>8 total characters</li>
					<li>One uppercase letter</li>
					<li>One lowercase letter</li>
					<li>One number (0-9)</li>
					<li>One special character</li>
				</ul>
				<input type="text" id="password-input1" name="password-input1"
					title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
					placeholder="P@ssw0rd" value="${requestScope.password1}">
				<input type="text" id="password-input2" name="password-input2" 
					title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
					placeholder="P@ssw0rd" value="${requestScope.password2}">
			</section>
			<section>
			<label for="balance-input">Starting Deposit:</label> 
				<div class="currency-input">
					<input type="number" id="balance-input" name="balance-input" 
					placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
					value="${requestScope.balance}">
				</div>
			</section>
			<%@ include file="result.jsp" %>
			<button type="submit">Submit</button>
		</form>
	</main>
	<%@ include file="welcome-footer.jsp" %>
</body>
</html>