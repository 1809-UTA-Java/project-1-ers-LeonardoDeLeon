package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class EmployeeServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html><body>");
		pw.println("<h1>Employee Page</h1><br>");
		pw.println("<a href='infoform'>Go See info</a><br>");
		pw.println("<a href='pendingbyid'>Go See Pending</a><br>");
		pw.println("<a href='resolvedbyid'>Go See Resolved</a><br>");
		pw.println("<a href='submit'>Go Submit Request</a><br>");
		pw.println("<a href='logout'>Logout</a><br>");
		pw.println("<a href='index.html'>home</a><br>");
		pw.println("</body></html>");
		pw.close();
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
