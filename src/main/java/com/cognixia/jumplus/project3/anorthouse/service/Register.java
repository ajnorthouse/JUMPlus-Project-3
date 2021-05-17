package com.cognixia.jumplus.project3.anorthouse.service;

import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseString;
import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseUsername;
import static com.cognixia.jumplus.project3.anorthouse.controller.DollarsBankController.createUser;
import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseDouble;
import static com.cognixia.jumplus.project3.anorthouse.utility.RegexUtil.checkPassword;
import static com.cognixia.jumplus.project3.anorthouse.utility.RegexUtil.checkContactNumber;
import static com.cognixia.jumplus.project3.anorthouse.utility.RegexUtil.checkUsername;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.setResult;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.checkLoggedIn;

import java.io.IOException;

import com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.RESULT_CLASS;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkLoggedIn(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/public/register.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkLoggedIn(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		//collect info from JSP
		var name = request.getParameter("name-input");
		var contactNumber = request.getParameter("contactNumber-input");
		var username = request.getParameter("username-input");
		var password1 = request.getParameter("password-input1");
		var password2 = request.getParameter("password-input2");
		var balanceString = request.getParameter("balance-input");
		var balanceDouble = 0.00;
		var keepRunning = true;
		
		//first tries to clean inputs
		try {
			name = parseString(name, "name");
			contactNumber = parseString(contactNumber, "contact number");
			username = parseUsername(username, "username");
			password1 = parseString(password1, "1st password");
			password2 = parseString(password2, "2nd password");
			balanceDouble = parseDouble(balanceString, "starting deposit");
		} catch (Exception e) {
			keepRunning = false;
			setResult(request, RESULT_CLASS.ERROR, e.getMessage());
		}
		
		
		//next tests the inputs
		if (keepRunning) { 
			try {
				contactNumber = checkContactNumber(contactNumber);
				checkUsername(username);
				
				//tests if the passwords are equal BEFORE checking Regex
				if (password1.equals(password2)) {
					checkPassword(password1);
				} else {
					throw new Exception("Your passwords don't match!");
				}
			} catch (Exception e) {
				keepRunning = false;
				setResult(request, RESULT_CLASS.ERROR, e.getMessage());
			}
		}
		
		
		//then tries to add the user
		if (keepRunning) {
			try {
				username = createUser(username, password1, name, contactNumber, balanceDouble);
			} catch (Exception e) {
				keepRunning = false;
				setResult(request, RESULT_CLASS.ERROR, e.getMessage());
			}
		}
		
		
		//finally redirects or displays errors.
		if (keepRunning) {
			setResult(request, RESULT_CLASS.SUCCESS, "Created user: " + username + "\nRedirecting to login...");
			doGet(request, response);
			
		//failed login
		} else {
			request.setAttribute("name", name);
			request.setAttribute("contactNum", contactNumber);
			request.setAttribute("username", username);
			request.setAttribute("password1", password1);
			request.setAttribute("password2", password2);
			request.setAttribute("balance", balanceDouble);
			doGet(request, response);
		}
		
	}

}
