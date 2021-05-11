<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Deposit Funds</title>
</head>
<body>
	<%@ include file="../account-header.jsp" %>
	<%@ include file="../account-navbar.jsp" %>
	<main class="deposit">
		<h1>Deposit Page</h1>

		<form method="POST">
		
			<label for="deposit-input">Deposit Amount:</label>
			<div class="currency-input">
				<input type="number" id="deposit-input" name="deposit-input"
					placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
					value={deposit}>
			</div>
			
			<button type="submit">Submit</button>
		</form>
		<%@ include file="../../result.jsp" %>
	</main>
	<%@ include file="../../footer.jsp" %>
</body>
</html>