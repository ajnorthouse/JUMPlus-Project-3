package com.cognixia.jumplus.project3.anorthouse.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Register() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect info from jsp
		var name = request.getParameter("name-input");
		var contactNum = request.getParameter("contactNumber-input");
		var username = request.getParameter("username-input");
		var password1 = request.getParameter("password-input1");
		var password2 = request.getParameter("password-input2");
		var balance = Double.parseDouble(request.getParameter("balance-input"));

		//returns attributes
		request.setAttribute("name", name);
		request.setAttribute("contactNum", contactNum);
		request.setAttribute("username", username);
		request.setAttribute("password1", password1);
		request.setAttribute("password2", password2);
		request.setAttribute("balance", balance);
		
		doGet(request, response);
	}

}
