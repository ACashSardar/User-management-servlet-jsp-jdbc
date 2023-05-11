package com.usermgmt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.usermgmt.dao.UserDao;
import com.usermgmt.entity.User;

@WebServlet("/Delete")
public class DeleteServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		UserDao dao = new UserDao();
		int id = Integer.parseInt(req.getParameter("id"));
		User user=dao.getUser(id);
		
		HttpSession session=req.getSession();
		String loggedInUserEmail=(String) session.getAttribute("email");
		User loggedInUser=dao.getUserByEmail(loggedInUserEmail);
		
		if(loggedInUserEmail.equals(user.getEmail())) {
			dao.deleteUser(id);
			session.removeAttribute("email");
			session.invalidate();
			res.sendRedirect("Register.jsp");
		}
		
		else if(loggedInUser.getRole().equals("admin") && user.getRole().equals("user")){
			dao.deleteUser(id);
			List<User> userlist=dao.getAllUsers();
			req.setAttribute("userlist", userlist);
			req.setAttribute("user", loggedInUser);
			req.getRequestDispatcher("AdminHome.jsp").forward(req, res);
		}
		PrintWriter obj=res.getWriter();
		obj.println("Invalid Access..");
	}
	
}
