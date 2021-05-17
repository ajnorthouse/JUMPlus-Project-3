package com.cognixia.jumplus.project3.anorthouse.service;

import java.io.IOException;

import com.cognixia.jumplus.project3.anorthouse.model.User;
import com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.RESULT_CLASS;

import static com.cognixia.jumplus.project3.anorthouse.controller.DollarsBankController.addDeposit;
import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseDouble;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.setResult;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.checkBadLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/logged_in/deposit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		//collect info from JSP
		var depositString = request.getParameter("deposit-input");
		var depositDouble = 0.00;
		var keepRunning = true;
		
		//first tries to clean inputs
		try {
			depositDouble = parseDouble(depositString, "deposit");
		} catch (Exception e) {
			keepRunning = false;
			setResult(request, RESULT_CLASS.ERROR, e.getMessage());
		}
		
		
		//next tries to deposit
		if (keepRunning) {
			User user = (User) request.getSession(false).getAttribute("current_user");
			addDeposit(user, depositDouble);
		}
		
		
		//finally displays the results.
		if (keepRunning) {
			setResult(request, RESULT_CLASS.SUCCESS, "Deposited $" + depositDouble + "!");
			doGet(request, response);
			
		//failed deposit
		} else {
			request.setAttribute("deposit", depositDouble);
			doGet(request, response);
		}
	}

}
