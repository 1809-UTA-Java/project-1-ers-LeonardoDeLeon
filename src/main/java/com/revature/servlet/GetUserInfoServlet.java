package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repository.ErsDao;

@SuppressWarnings("serial")
public class GetUserInfoServlet extends HttpServlet {

	ErsDao ers = new ErsDao();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String userId = req.getParameter("userid");
		pw.println("POST -- userid: " + userId);
		pw.println(ers.getEmployeeById(Integer.parseInt(userId)));
		pw.println("<html><body>");
		pw.println("<h1>User info: </h1>");
		
		pw.println("<a href='index.html'>home</a><br>");
		pw.println("</body></html>");
		pw.close();

	}

}
