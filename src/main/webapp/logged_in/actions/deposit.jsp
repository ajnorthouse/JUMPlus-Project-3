<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Deposit Funds</title>
</head>
<body>
	<div class="deposit">
		<h1>Deposit Page</h1>
		<form>
			<label for="deposit-input">Deposit Amount:</label>
			<div class="currency-input">
				<input type="number" id="deposit-input" name="deposit-input"
				placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
				value={deposit}>
			</div>
			<br/>
			
			<button type="submit" onClick={handleSubmit}>Submit</button>
		</form>
		{result}
	</div>
</body>
</html>