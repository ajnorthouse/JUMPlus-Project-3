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
		<a href="<%= request.getContextPath()%>/deposit">Deposit Funds</a>
		<a href="<%= request.getContextPath()%>/withdraw">Withdraw Funds</a>
		<a href="<%= request.getContextPath()%>/transferFunds">Transfer Funds</a>
		<a href="<%= request.getContextPath()%>/recentTransactions">View Recent Transactions</a>
		<a href="<%= request.getContextPath()%>/view-details">View Account Details</a>
		<a href="<%= request.getContextPath()%>/log-out">Sign out</a>
	</div>
</body>
</html>