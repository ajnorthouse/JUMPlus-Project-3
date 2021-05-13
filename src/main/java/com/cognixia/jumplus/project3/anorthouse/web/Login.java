package com.cognixia.jumplus.project3.anorthouse.web;

import java.io.IOException;

import com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.RESULT_CLASS;

import static com.cognixia.jumplus.project3.anorthouse.controller.DollarsBankController.attemptLogin;
import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseUsername;
import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseString;
import static com.cognixia.jumplus.project3.anorthouse.utility.RegexUtil.checkPassword;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.setSessionUser;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.setResult;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.checkLoggedIn;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkLoggedIn(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/public/login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkLoggedIn(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		//collect info from JSP
		var username = request.getParameter("username-input");
		var password = request.getParameter("password-input");
		var keepRunning = true;
		
		//first tries to clean & check inputs
		try {
			username = parseUsername(username, "username");
			password = parseString(password, "password");
			checkPassword(password);
		} catch (Exception e) {
			keepRunning = false;
			setResult(request, RESULT_CLASS.ERROR, e.getMessage());
		}
		
		
		//next tries to login
		if (keepRunning) {
			var user = attemptLogin(username, password);
			
			if (user == null) {
				keepRunning = false;
				setResult(request, RESULT_CLASS.ERROR, "No matching Username/Password combo.");
			} else {
				setSessionUser(request, user);
			}
		}
		
		
		//finally redirects or displays errors.
		if (keepRunning) {
			response.sendRedirect(request.getContextPath() + "/account/info");
			return;
			
		//failed login
		} else {
			request.setAttribute("username", username);
			request.setAttribute("password", password);
			doGet(request, response);
		}
		
	}

}
