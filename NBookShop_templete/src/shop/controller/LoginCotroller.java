package shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.service.facade.CustomerService;
import shop.service.logic.CustomerServiceLogic;

@WebServlet("/login.do")
public class LoginCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		CustomerService service = new CustomerServiceLogic();
	
		if(service.login(userId, password)){
			HttpSession session = request.getSession();
			session.setAttribute("userId", userId);
			response.sendRedirect("productList.do");			
		}else{
			response.sendRedirect("login.html");
		}
	
	
	}

}
