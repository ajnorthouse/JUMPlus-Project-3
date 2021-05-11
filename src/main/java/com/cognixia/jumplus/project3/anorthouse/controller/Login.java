package com.cognixia.jumplus.project3.anorthouse.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		
	}
	
	// JSP EL way to get session variables:
	//	${sessionScope.attribute}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		//collect info from JSP
//		var withdrawal = Double.parseDouble(request.getParameter("withdrawl-input"));
//		
//		//returns attributes
//		request.setAttribute("withdrawal", withdrawal);
//		
//		session.setAttribute("UserName", username);
//		
//		doGet(request, response);
		response.sendRedirect(request.getContextPath() + "/account/info");
	}

}
