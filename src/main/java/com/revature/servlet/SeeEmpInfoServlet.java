package com.revature.servlet;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.model.Users;
import com.revature.repository.ErsDao;
@SuppressWarnings("serial")
public class SeeEmpInfoServlet extends HttpServlet {
	ErsDao ers = new ErsDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		List<Users> userList = ers.getEmployees();
		for (Users u : userList) {
			pw.println(u.toString());
		}
		pw.println("<html><body>");
		pw.println("<h1>See Employee Info Page</h1><br>");

		pw.println("<a href='index.html'>home</a><br>");
		pw.println("</body></html>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
