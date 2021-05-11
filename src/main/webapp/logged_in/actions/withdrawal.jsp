<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Withdraw Funds</title>
</head>
<body>
	<%@ include file="../account-header.jsp" %>
	<%@ include file="../account-navbar.jsp" %>
	<div class="withdraw">
		<h1>Withdrawal Page</h1>
		
		<form method="POST">
		
			<label for="withdrawl-input">Withdrawal Amount:</label>
			<div class="currency-input">
				<input type="number" id="withdrawl-input" name="withdrawl-input" 
					placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
					value={withdrawl}>
			</div>
			
			<button type="submit">Submit</button>
		</form>
		{result}
	</div>
	<%@ include file="../../footer.jsp" %>
</body>
</html>