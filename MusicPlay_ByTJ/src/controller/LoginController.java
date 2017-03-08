package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.User;
import service.logic.UserServiceLogic;

@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("loginForm.jsp");
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserServiceLogic service = new UserServiceLogic();
		User user = new User();
		

		user = service.find(request.getParameter("loginId"));

		if (user == null) {
			response.sendRedirect("loginForm.jsp");
		} else if (user.getPassword().equals(request.getParameter("password"))) {
			String userName = user.getName();
			String loginId = user.getLoginId();
			HttpSession session = request.getSession();
			session.setAttribute("userId", loginId);
			session.setAttribute("userName", userName);
			response.sendRedirect("list.do");
		} else {
			response.sendRedirect("loginForm.jsp");
		}
	}

}
