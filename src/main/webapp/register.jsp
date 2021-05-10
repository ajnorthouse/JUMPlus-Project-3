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
		<form>
		<label for="name-input">Name:</label>
		<input type="text" id="name-input" name="name-input" 
			placeholder="John Smith" title="First name followed by Last name"
			value={name}>
		
		<br/>
		
		<label for="contactNumber-input">Contact Number:</label>
			<input type="tel" id="contactNumber-input" name="contactNumber-input" 
				placeholder="123-456-7890"
				title="Phone Number with Area code, dashes between each set of numbers"
				value={contactNumber}>
		
			<br/>

		<label for="userId-input">User Id: </label>
		<input type="text" id="userId-input" name="userId-input"
				placeholder="jsmith" title="username"
			value={userId}>
		
		<br/>

		<label for="password-input1">Password: </label>
		<input type="text" id="password-input1" name="password-input1"
			placeholder="P@ssw0rd"
			title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
			value={password1}>
		
		<input type="text" id="password-input2" name="password-input2" 
			placeholder="P@ssw0rd"
			title="Password with minimum 8 characters, one number, one special character, one uppercase letter, and one lowercase letter."
			value={password2}>
		
		<ul>
			<p>Your Password Must Contain:</p>
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
		
		<button type="submit" onClick={handleSubmit}>Submit</button>
		</form>
		{result}
	</div>
</body>
</html>