package com.cognixia.jumplus.project3.anorthouse.service;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import static com.cognixia.jumplus.project3.anorthouse.utility.WebHelperUtil.destroySession;

public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		destroySession(request);
		response.sendRedirect(request.getContextPath() + "/");
		return;
	}

}
