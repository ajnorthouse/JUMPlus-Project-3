<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Recent Transactions</title>
</head>
<body>
	<%@ include file="../account-header.jsp" %>
	<%@ include file="../account-navbar.jsp" %>
	<div class="recent_transactions">
		<h1>Recent Transactions Page</h1>

		<div class="transaction-entry" key={"Entry " + counter}>
			<h2>{log[counter][0]}</h2>
			<p>{log[counter][1]}</p>
		</div>
		<div class="transaction-entry" key={"Entry " + counter}>
			<h2>{log[counter][0]}</h2>
			<p>{log[counter][1]}</p>
		</div>
		<div class="transaction-entry" key={"Entry " + counter}>
			<h2>{log[counter][0]}</h2>
			<p>{log[counter][1]}</p>
		</div>
		<div class="transaction-entry" key={"Entry " + counter}>
			<h2>{log[counter][0]}</h2>
			<p>{log[counter][1]}</p>
		</div>
		<div class="transaction-entry" key={"Entry " + counter}>
			<h2>{log[counter][0]}</h2>
			<p>{log[counter][1]}</p>
		</div>
	</div>
	<%@ include file="../../footer.jsp" %>
</body>
</html>