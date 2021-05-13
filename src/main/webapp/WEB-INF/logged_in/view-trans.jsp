<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Recent Transactions</title>
	<style><%@include file="/WEB-INF/css/Project3.css"%></style>
</head>
<body>
	<%@ include file="account-header.jsp" %>
	<nav>
		<a href="${pageContext.request.contextPath}/account/deposit">Deposit Funds</a>
		<a href="${pageContext.request.contextPath}/account/withdrawal">Withdraw Funds</a>
		<a href="${pageContext.request.contextPath}/account/transfer">Transfer Funds</a>
		<a class="current-page" href="${pageContext.request.contextPath}/account/transactions">View Recent Transactions</a>
		<a href="${pageContext.request.contextPath}/account/info">View Account Details</a>
		<a href="${pageContext.request.contextPath}/account/sign-out">Sign out</a>
	</nav>
	<main class="logged-in">
		<div class="main-content">
			<h2>Recent Transactions Page</h2>
			${requestScope.transactions}
		</div>
	</main>
	<%@ include file="account-footer.jsp" %>
</body>
</html>