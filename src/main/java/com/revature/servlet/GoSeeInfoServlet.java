package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Users;
import com.revature.repository.ErsDao;

@SuppressWarnings("serial")
public class GoSeeInfoServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter pw = resp.getWriter();
		
		pw.println("<html><body>");
		pw.println("<h1>Enter User Id</h1>");
		pw.println("<form action=\"getuserinfo\" method=\"post\">");
		pw.println("<label>UserId: </label>");
		pw.println("<input type=\"text\" name=\"userid\">");
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
