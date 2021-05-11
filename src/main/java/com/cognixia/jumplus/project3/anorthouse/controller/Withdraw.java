package com.cognixia.jumplus.project3.anorthouse.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Withdraw extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Withdraw() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logged_in/actions/withdrawal.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect info from JSP
		var withdrawal = Double.parseDouble(request.getParameter("withdrawl-input"));
		
		//returns attributes
		request.setAttribute("withdrawal", withdrawal);
		
		doGet(request, response);
	}

}
