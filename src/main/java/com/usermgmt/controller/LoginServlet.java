package com.usermgmt.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usermgmt.dao.UserDao;
import com.usermgmt.entity.User;


@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {

		UserDao dao=new UserDao();
		String email = req.getParameter("email");
		String passsword = req.getParameter("password");
		User user=dao.authenticate(email, passsword);

		if (user!=null) {
			HttpSession session = req.getSession();
			session.setAttribute("email", email);
			req.setAttribute("user", user);
			
			if(user.getRole().equals("user")) {
				req.getRequestDispatcher("UserHome.jsp").forward(req, res);
			}
			else{
				List<User> userlist=dao.getAllUsers();
				req.setAttribute("userlist", userlist);
				req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
			}
			
		} else {
			res.sendRedirect("Login.jsp?error=true");
		}
	}
}
