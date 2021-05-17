package com.cognixia.jumplus.project3.anorthouse.service;

import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseUsername;
import static com.cognixia.jumplus.project3.anorthouse.controller.DollarsBankController.attemptTransfer;
import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseDouble;
import static com.cognixia.jumplus.project3.anorthouse.utility.RegexUtil.checkUsername;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.checkBadLogin;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.setResult;

import java.io.IOException;

import com.cognixia.jumplus.project3.anorthouse.model.User;
import com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.RESULT_CLASS;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/logged_in/transfer.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		
		//collect info from JSP
		var recipient = request.getParameter("recepient-input");
		var transferString = request.getParameter("transfer-input");
		var transferDouble = 0.00;
		var keepRunning = true;
		
		//first tries to clean and check inputs
		try {
			recipient = parseUsername(recipient, "transfer recipient");
			transferDouble = parseDouble(transferString, "transfer amount");
			checkUsername(recipient);
		} catch (Exception e) {
			keepRunning = false;
			setResult(request, RESULT_CLASS.ERROR, e.getMessage());
		}
		
		
		//next tries to transfer the funds
		if (keepRunning) {
			User user = (User) request.getSession(false).getAttribute("current_user");
			try {
				attemptTransfer(user, recipient, transferDouble);
			} catch (Exception e) {
				keepRunning = false;
				setResult(request, RESULT_CLASS.ERROR, e.getMessage());
			}
		}
		
		
		//finally displays the results.
		if (keepRunning) {
			setResult(request, RESULT_CLASS.SUCCESS, "Transferred $" + transferDouble + " to " + recipient + "!");
			doGet(request, response);
			
		//failed deposit
		} else {
			request.setAttribute("transfer", transferDouble);
			request.setAttribute("recepient", recipient);
			doGet(request, response);
		}
	}

}
