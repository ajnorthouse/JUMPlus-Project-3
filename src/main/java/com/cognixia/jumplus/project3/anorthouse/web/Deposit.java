package com.cognixia.jumplus.project3.anorthouse.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Deposit extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Deposit() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logged_in/actions/deposit.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect info from JSP
		var deposit = Double.parseDouble(request.getParameter("deposit-input"));
		
		//returns attributes
		request.setAttribute("deposit", deposit);
		
		doGet(request, response);
	}

}