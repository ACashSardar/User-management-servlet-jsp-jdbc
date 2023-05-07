package com.usermgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usermgmt.dao.UserDao;
import com.usermgmt.entity.User;

@WebServlet("/Edit")
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		UserDao dao = new UserDao();
		int id = Integer.parseInt(req.getParameter("id"));
		User user = dao.getUser(id);
		HttpSession session = req.getSession();
		if (!((String) session.getAttribute("email")).equals(user.getEmail())) {
			PrintWriter out = res.getWriter();
			out.println("<html><p>Invalid Access </p></html>");
			return;
		}
		req.setAttribute("user", user);
		RequestDispatcher rd = req.getRequestDispatcher("EditUser.jsp");
		rd.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String passsword = req.getParameter("password");
		String role = req.getParameter("role");
		UserDao dao = new UserDao();
		User newUser = new User(id, name, email, passsword, role);
		dao.updateUser(id, newUser);
		HttpSession session = req.getSession();
		session.setAttribute("email", email);
		req.setAttribute("user", newUser);

		if (newUser.getRole().equals("user")) {
			req.getRequestDispatcher("UserHome.jsp").forward(req, res);
		} else {
			List<User> userlist = dao.getAllUsers();
			req.setAttribute("userlist", userlist);
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		}
	}

}
