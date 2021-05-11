<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Register Account</title>
</head>
<body>
	<div class="create-account">
		<h1>Create Account</h1>
		
		<form method="POST">
		
			<label for="name-input">Name:</label>
			<input type="text" id="name-input" name="name-input" 
				placeholder="John Smith" title="First name followed by Last name"
				value={name}>
			
			<label for="contactNumber-input">Contact Number:</label>
			<input type="tel" id="contactNumber-input" name="contactNumber-input" 
				title="Phone Number with Area code, dashes between each set of numbers"
				placeholder="123-456-7890" value={contactNumber}>
	
			<label for="userId-input">User Id: </label>
			<input type="text" id="userId-input" name="userId-input"
				placeholder="jsmith" title="username"
				value={userId}>
	
			<label for="password-input1">Password: </label>
			<input type="text" id="password-input1" name="password-input1"
				title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
				placeholder="P@ssw0rd" value={password1}>
			
			<input type="text" id="password-input2" name="password-input2" 
				title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
				placeholder="P@ssw0rd" value={password2}>
			
			<p>Your Password Must Contain:</p>
			<ul>
				<li>Eight total characters</li>
				<li>One uppercase letter</li>
				<li>One lowercase letter</li>
				<li>One number (0-9)</li>
				<li>One special character</li>
			</ul>
	
			<label for="balance-input">Starting Deposit:</label> 
				<div class="currency-input">
					<input type="number" id="balance-input" name="balance-input" 
					placeholder="0.01" title="Dollar.Cent amount" min=".01" step=".01"
					value={balance}>
				</div>
			<br/>
			
			<button type="submit">Submit</button>
		</form>
		{result}
	</div>
</body>
</html>