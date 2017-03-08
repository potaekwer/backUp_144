package hr.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login.do")
public class LoginCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	String loginId = req.getParameter("loginId");
	String passwd = req.getParameter("passwd");
	
	if("1234".equals(passwd)){
		
		HttpSession session = req.getSession();
		
		session.setAttribute("loginId", loginId);
		
		resp.sendRedirect(req.getContextPath() +"/views/menu.jsp");
		
	}else{
		resp.sendRedirect(req.getContextPath()+"/views/login.jsp");
	}
	
	}
	
	

}
