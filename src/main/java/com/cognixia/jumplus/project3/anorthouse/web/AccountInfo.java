package com.cognixia.jumplus.project3.anorthouse.web;

import java.io.IOException;

import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.checkBadLogin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AccountInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/logged_in/view-details.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		// could use this to update user details
	}

}
