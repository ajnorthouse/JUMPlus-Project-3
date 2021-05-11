<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Transfer Funds</title>
</head>
<body>
	<%@ include file="../account-header.jsp" %>
	<%@ include file="../account-navbar.jsp" %>
	<main class="transfer-funds">
		<h1>Transfer Funds</h1>
		
		<form method="POST">
		
			<label for="transfer-input">Transfer Amount:</label>
			<div class="currency-input">
				<input type="number" id="transfer-input" name="transfer-input"
					placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
					value="${requestScope.transfer}">
			</div>
	
			<label for="recepient-input">Transfer Recipient:</label>
			<input type="text" id="recepient-input" name="recepient-input"
				placeholder="jsmith" title="Username of recepient"
				value="${requestScope.recepient}">
			
			<button type="submit">Submit</button>
		</form>
		<%@ include file="../../result.jsp" %>
	</main>
	<%@ include file="../../footer.jsp" %>
</body>
</html>