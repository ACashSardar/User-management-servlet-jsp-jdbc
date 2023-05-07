package com.usermgmt.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.usermgmt.dao.UserDao;
import com.usermgmt.entity.User;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String passsword = req.getParameter("password");
		String role = req.getParameter("role");
		User user = new User(name, email, passsword, role);
		UserDao dao = new UserDao();
		dao.createUser(user);
		System.out.println(user);
		res.sendRedirect("Login.jsp?signup=true");
	}
}
