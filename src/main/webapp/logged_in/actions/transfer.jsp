<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Transfer Funds</title>
</head>
<body>
	<div class="transfer-funds">
		<h1>Transfer Funds</h1>
		
		<form method="POST">
		
			<label for="transfer-input">Transfer Amount:</label>
			<div class="currency-input">
				<input type="number" id="transfer-input" name="transfer-input"
					placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
					value={transfer}>
			</div>
	
			<label for="recepient-input">Transfer Recipient:</label>
			<input type="text" id="recepient-input" name="recepient-input"
				placeholder="jsmith" title="Username of recepient"
				value={recepient}>
			
			<button type="submit">Submit</button>
		</form>
		{result}
	</div>
</body>
</html>