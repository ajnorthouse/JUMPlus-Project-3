<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Account Details</title>
	<style><%@include file="/WEB-INF/css/Project3.css"%></style>
</head>
<body>
	<%@ include file="account-header.jsp" %>
	<nav>
		<a href="${pageContext.request.contextPath}/account/deposit">Deposit Funds</a>
		<a href="${pageContext.request.contextPath}/account/withdrawal">Withdraw Funds</a>
		<a href="${pageContext.request.contextPath}/account/transfer">Transfer Funds</a>
		<a href="${pageContext.request.contextPath}/account/transactions">View Recent Transactions</a>
		<a class="current-page" href="${pageContext.request.contextPath}/account/info">View Account Details</a>
		<a href="${pageContext.request.contextPath}/account/sign-out">Sign out</a>
	</nav>
	<main class="logged-in">
		<div class="main-content">
			<h2>Account Details:</h2>
			<section>
				<h3>Username:</h3>
				<p>${sessionScope.current_user.getUsername()}</p>
			</section>
			<section>
				<h3>Password:</h3>
				<p>${sessionScope.current_user.getPassword()}</p>
			</section>
			<section>
				<h3>Name:</h3>
				<p>${sessionScope.current_user.getName()}</p>
			</section>
			<section>
				<h3>Contact Number:</h3>
				<p>${sessionScope.current_user.getContactNumber()}</p>
			</section>
			<section>
				<h3>Current Balance:</h3>
				<p>${sessionScope.current_user.getBalance()}</p>
			</section>
			<section>
				<h3>Total Transactions:</h3>
				<p>${sessionScope.current_user.getLog().size() - 1}</p>
			</section>
		</div>
	</main>
	<%@ include file="account-footer.jsp" %>
</body>
</html>