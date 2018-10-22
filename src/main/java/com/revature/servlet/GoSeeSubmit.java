package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GoSeeSubmit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Enter Amount, AuthorId, and Expense Type</h1>");
		pw.println("<form action=\"submitrequest\" method=\"post\">");
		pw.println("<label>Amount: </label>");
		pw.println("<input type=\"text\" name=\"amount\">");
		pw.println("<label>Author Id: </label>");
		pw.println("<input type=\"text\" name=\"authorid\">");
		pw.println("<label>Select from the following: </label>");
		pw.println("<select name=\"typeid\">");
		pw.println("<option value=\"120\">Travel Expense</option>");
		pw.println("<option value=\"121\">Lodging</option>");
		pw.println("<option value=\"123\">Meals</option>");
		pw.println("<option value=\"124\">Dry Cleaning</option>");
		pw.println("<option value=\"125\">Entertainment</option>");
		pw.println("</select>");
		pw.println("<button type=\"submit\">Submit</button>");
		pw.println("</form>");
		pw.println("<a href='index.html'>home</a><br>");
		pw.println("</body></html>");
		pw.close();
		

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
