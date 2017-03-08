package yorizori.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yorizori.common.exception.YzRuntimeException;
import yorizori.domain.Cookbook;
import yorizori.domain.User;
import yorizori.service.CookbookService;
import yorizori.service.ServiceFactory;
@WebServlet("/cookbook/register.do")
public class CookbookFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		checkLogin(request);
		
		request.getRequestDispatcher("/views/cookbookForm.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User loginUser = checkLogin(request);
		
		CookbookService service = ServiceFactory.getCookbookService();
		
		String bookName = request.getParameter("bookName");
		String bookDesc = request.getParameter("bookDesc");
		
		Cookbook cookbook = new Cookbook();
		cookbook.setName(bookName);
		cookbook.setDescription(bookDesc);
		cookbook.setAuthor(loginUser);
		service.registerCookbook(cookbook);
		response.sendRedirect(request.getContextPath());
	}
	
	private User checkLogin(HttpServletRequest req){
		
		User user = (User)req.getSession().getAttribute("loginUser");
		
		if(user == null){
			YzRuntimeException ex = new YzRuntimeException("로그인이 필요 합니다.");
			ex.setRedirectURL(req.getContextPath() +"/user/login.do");
			throw ex;
		}
		
		return user;
	}

}
