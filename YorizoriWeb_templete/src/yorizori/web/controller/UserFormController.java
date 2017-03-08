package yorizori.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yorizori.domain.User;
import yorizori.service.ServiceFactory;
import yorizori.service.UserService;

@WebServlet("/user/register.do")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			UserService service = ServiceFactory.getUserService();
			
	
	
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String name = request.getParameter("name");
			
			User user = new User();
			user.setUserId(userId);
			user.setPassword(password);
			user.setName(name);

			
			service.registerUser(user);
			response.sendRedirect(request.getContextPath() + "/user/login.do");
	}

}
