package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class ManagerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	PrintWriter pw = resp.getWriter();
		
		pw.println("<html><body>");
		pw.println("<h1>Manager Page</h1><br>");
		pw.println("<a href='employeeinfo'>Go See Employee Info</a><br>");
		pw.println("<a href='request'>Go Approve a Request</a><br>");
		pw.println("<a href='deny'>Go Deny a Request</a><br>");
		pw.println("<a href='logout'>Logout</a><br>");
		pw.println("<a href='index.html'>home</a><br>");
		pw.println("</body></html>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

}
