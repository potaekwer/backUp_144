package yorizori.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import yorizori.common.exception.YzRuntimeException;
import yorizori.domain.User;
import yorizori.service.ServiceFactory;
import yorizori.service.UserService;

@WebServlet("/user/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();

		if (cookies != null) {

			for (Cookie cookie : cookies) {
				if ("userId".equals(cookie.getName())) {
					request.setAttribute("userId", cookie.getValue());
				}
			}
		}

		request.getRequestDispatcher("/views/loginForm.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserService service = ServiceFactory.getUserService();

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		String saveIdYn = request.getParameter("saveIdYn");

		if ("Y".equals(saveIdYn)) {
			Cookie cookie = new Cookie("userId", userId);

			cookie.setMaxAge(3600);

			cookie.setPath("/");
			response.addCookie(cookie);
		}
		User user = service.findUser(userId);

		if (user != null && userId.equals(user.getUserId()) && password.equals(user.getPassword())) {

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);

			response.sendRedirect(request.getContextPath());
		} else {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			
			throw new YzRuntimeException("로그인 정보를 확인하세요");
		}
		
		
		

	}

}
