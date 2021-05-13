package com.cognixia.jumplus.project3.anorthouse.web;

import java.io.IOException;
import java.util.List;

import static com.cognixia.jumplus.project3.anorthouse.utility.InputParserUtil.parseInt;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.checkBadLogin;
import com.cognixia.jumplus.project3.anorthouse.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RecentTransactions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (checkBadLogin(request)) {
			response.sendRedirect(request.getContextPath() + "/");
			return;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/logged_in/view-trans.jsp");
		
		//variable creation.
		StringBuilder sb = new StringBuilder();
		User user = (User) request.getSession(false).getAttribute("current_user");
		List<String[]> userLog = user.getLog();
		var requestedEntriesString = request.getParameter("requestedEntries");
		var requestedEntriesInt = 0;
		
		//invisible try-catch for custom requests
		try {
			requestedEntriesInt = parseInt(requestedEntriesString, "");
		} catch (Exception e) {
			requestedEntriesInt = 5;
		}
		
		//sets length to either the current log size, or requested value
		var length = (userLog.size() < requestedEntriesInt) ? userLog.size() : requestedEntriesInt; 
	
		//for loop that goes over the log array backwards
		for (int counter = length - 1; counter > -1; counter--) {
			sb.append("<div class=\"log-entry\" name=\"Entry ").append(counter).append("\">")
					.append("<section><h3>").append(userLog.get(counter)[0]).append("</h3>")
					.append("<p>").append(userLog.get(counter)[1]).append("</p></section>")
				.append("</div>");
		}
		
		request.setAttribute("transactions", sb.toString());
		dispatcher.forward(request, response);
	}

}
