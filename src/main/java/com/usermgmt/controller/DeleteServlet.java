package com.usermgmt.controller;

import java.io.IOException;

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
		if(((String) session.getAttribute("email")).equals(user.getEmail())) {
			dao.deleteUser(id);
		}
		session.removeAttribute("email");
		session.invalidate();
		res.sendRedirect("Register.jsp");
	}
	
}
