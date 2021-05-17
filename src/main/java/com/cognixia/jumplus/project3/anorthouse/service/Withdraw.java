package com.cognixia.jumplus.project3.anorthouse.service;

import static com.cognixia.jumplus.project3.anorthouse.controller.DollarsBankController.subtractWithdrawal;
import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseDouble;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.setResult;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.checkBadLogin;

import java.io.IOException;

import com.cognixia.jumplus.project3.anorthouse.model.User;
import com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.RESULT_CLASS;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/logged_in/withdrawal.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		//collect info from JSP
		var withdrawalString = request.getParameter("withdrawl-input");
		var withdrawalDouble = 0.00;
		var keepRunning = true;
		
		//first tries to clean inputs
		try {
			withdrawalDouble = parseDouble(withdrawalString, "withdrawal");
		} catch (Exception e) {
			keepRunning = false;
			setResult(request, RESULT_CLASS.ERROR, e.getMessage());
		}
		
		
		//next tries to withdraw
		if (keepRunning) {
			User user = (User) request.getSession(false).getAttribute("current_user");
			try {
				subtractWithdrawal(user, withdrawalDouble);
			} catch (Exception e) {
				keepRunning = false;
				setResult(request, RESULT_CLASS.ERROR, e.getMessage());
			}
		}
		
		
		//finally displays the results.
		if (keepRunning) {
			setResult(request, RESULT_CLASS.SUCCESS, "Withdrew $" + withdrawalDouble + "!");
			doGet(request, response);
			
		//failed deposit
		} else {
			request.setAttribute("withdrawal", withdrawalDouble);
			doGet(request, response);
		}
	}
	
}
