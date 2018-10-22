package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class GoSeeResolveRequestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		pw.println("<html><body>");
		pw.println("<h1>Enter Author Id</h1>");
		pw.println("<form action=\"getresolvedreqbyid\" method=\"post\">");
		pw.println("<label>Author Id: </label>");
		pw.println("<input type=\"text\" name=\"authorid\">");
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
