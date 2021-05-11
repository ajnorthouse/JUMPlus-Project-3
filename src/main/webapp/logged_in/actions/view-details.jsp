<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Account Details</title>
</head>
<body>
	<%@ include file="../account-header.jsp" %>
	<%@ include file="../account-navbar.jsp" %>
	<main class="recent_transactions">
		<h1>Account Details:</h1>
		<div class="username">
			<h2>Username:</h2>
			<p>{props.login.username}</p>
		</div>

		<div class="password">
			<h2>Password:</h2>
			<p>{props.login.password}</p>
		</div>

		<div class="name">
			<h2>Name:</h2>
			<p>{props.login.name}</p>
		</div>

		<div class="contact-number">
			<h2>Contact Number:</h2>
			<p>{props.login.contactNumber}</p>
		</div>

		<div class="balance">
			<h2>Current Balance:</h2>
			<p>${props.login.balance.toFixed(2)}</p>
		</div>

		<div class="total-transactions">
			<h2>Total Transactions:</h2>
			<p>{props.login.log.length - 1}</p>
		</div>
	</main>
	<%@ include file="../../footer.jsp" %>
</body>
</html>