package com.cognixia.jumplus.project3.anorthouse.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Transfer extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Transfer() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logged_in/actions/transfer.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect info from JSP
		var transfer = Double.parseDouble(request.getParameter("transfer-input"));
		var recepient = request.getParameter("recepient-input");
		
		//returns attributes
		request.setAttribute("transfer", transfer);
		request.setAttribute("recepient", recepient);
		
		doGet(request, response);
	}

}
