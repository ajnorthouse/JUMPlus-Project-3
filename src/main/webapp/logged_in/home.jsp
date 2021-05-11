<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Home</title>
</head>
<body>
	<div class="home">
		<h1>Home Page</h1>
		<a href="<%= request.getContextPath()%>/account/deposit">Deposit Funds</a>
		<a href="<%= request.getContextPath()%>/account/withdrawal">Withdraw Funds</a>
		<a href="<%= request.getContextPath()%>/account/transfer">Transfer Funds</a>
		<a href="<%= request.getContextPath()%>/account/transactions">View Recent Transactions</a>
		<a href="<%= request.getContextPath()%>/account/info">View Account Details</a>
		<a href="<%= request.getContextPath()%>/sign-out">Sign out</a>
	</div>
</body>
</html>