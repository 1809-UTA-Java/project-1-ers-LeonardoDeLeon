package com.revature.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.Users;
import com.revature.repository.ErsDao;

@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	ErsDao ers = new ErsDao();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw = resp.getWriter();
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		pw.println("POST -- username: " + username + " , password:  " + password);
		
		boolean isUsername = false;
		boolean isPassword = false;
		boolean isEmployee = false;
		boolean isManager = false;
		
		String uname = "";
		String pswd = "";
		int roleId = 0;
		String userId = "";

		List<Users> users = ers.getUsers();
		for (Users u : users) {
			if (username.equals(u.getUsername())) {
				isUsername = true;
				uname = u.getUsername();
				roleId = u.getUserRoleId();
				userId = Integer.toString(u.getUserId());
			}
			if (password.equals(u.getPassword())) {
				isPassword = true;
				pswd = u.getPassword();
			}
		}
		
		boolean isValidating = true;
		
		while (isValidating) {
			if (!isUsername) {
				pw.println("Username is not valid: "+ uname);
				break;
			}
			if (!isPassword) {
				pw.println("Password is not valid: "+ pswd);
				break;
			}
			if (isUsername && isPassword) {
				if (roleId == 33) {
					isEmployee = true;
				}
				
				if (roleId == 45) {
					isManager = true;
				}
				isValidating = false;
			}
			
			HttpSession session = req.getSession();
			session.setAttribute(uname, userId);
			
			if (isEmployee) {
				resp.sendRedirect("employee");
			}
			
			if (isManager) {
				resp.sendRedirect("manager");
			}
		}

		
		pw.close();
	}

}
