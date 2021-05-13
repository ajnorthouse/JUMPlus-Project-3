<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Deposit Funds</title>
	<style><%@include file="/WEB-INF/css/Project3.css"%></style>
</head>
<body>
	<%@ include file="account-header.jsp" %>
	<nav>
		<a class="current-page" href="${pageContext.request.contextPath}/account/deposit">Deposit Funds</a>
		<a href="${pageContext.request.contextPath}/account/withdrawal">Withdraw Funds</a>
		<a href="${pageContext.request.contextPath}/account/transfer">Transfer Funds</a>
		<a href="${pageContext.request.contextPath}/account/transactions">View Recent Transactions</a>
		<a href="${pageContext.request.contextPath}/account/info">View Account Details</a>
		<a href="${pageContext.request.contextPath}/account/sign-out">Sign out</a>
	</nav>
	<main class="logged-in">
		<form method="POST" class="main-content">
			<h2>Deposit Page</h2>
			<section>
				<label for="deposit-input">Deposit Amount:</label>
				<div class="currency-input">
					<input type="number" id="deposit-input" name="deposit-input"
						placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
						value="${requestScope.deposit}">
				</div>
			</section>
			<%@ include file="../public/result.jsp" %>
			<button type="submit">Submit</button>
		</form>
	</main>
	<%@ include file="account-footer.jsp" %>
</body>
</html>