<%@page import="java.util.List"%>
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
	<main class="recent_transactions">
		<h1>Recent Transactions Page</h1>
		
		${param.transactions}
		
	</main>
	<%@ include file="../../footer.jsp" %>
</body>
</html>