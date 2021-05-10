package com.cognixia.jumplus.project3.anorthouse;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class TestClass extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.println("""
				<html>
					<head><title>Hello Page</title></head>
				<body>
					<h1>Hello World!</h1>
				</body>
				</html>
				""");
		pw.close();
	}

}
