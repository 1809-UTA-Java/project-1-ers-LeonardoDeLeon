package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.repository.ErsDao;

@SuppressWarnings("serial")
public class SubmitRequestServlet extends HttpServlet {
	ErsDao ers = new ErsDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
		int amount = Integer.parseInt(req.getParameter("amount"));
		int author_Id = Integer.parseInt(req.getParameter("authorid"));
		int er_type = Integer.parseInt(req.getParameter("typeid"));
		
		ers.submitRequest(amount, author_Id, er_type);
		pw.println("POST -- authorid: " + author_Id);

		pw.println("<html><body>");
		pw.println("<h1>User info: </h1>");
		
		pw.println("<a href='index.html'>home</a><br>");
		pw.println("</body></html>");
		pw.close();
				
		
	}

}
