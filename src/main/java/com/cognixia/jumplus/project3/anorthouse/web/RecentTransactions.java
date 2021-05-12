package com.cognixia.jumplus.project3.anorthouse.web;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RecentTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RecentTransactions() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/logged_in/actions/view-trans.jsp");
		
		//return full stack of divs for the transactions.
		
		// code from React project
//		//gets last [amount] inserted elements
//		let log = props.log.slice(-1 * props.amount);
//	
//		//determins how many times to run
//		let length = (log.length < props.amount) ?
//			log.length:
//			props.amount;
//	
//		//for loop that goes over the log array backwards
//		let counter;
//		let listEntries = [];
//		for (counter = length -1; counter > -1; counter--) {
//			listEntries.push(
//				<div className="transaction-entry" key={"Entry " + counter}>
//					<h2>{log[counter][0]}</h2>
//					<p>{log[counter][1]}</p>
//				</div>
//			);
//		}
		
		dispatcher.forward(request, response);
	}

}
