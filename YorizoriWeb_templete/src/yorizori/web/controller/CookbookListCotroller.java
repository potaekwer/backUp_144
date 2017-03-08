package yorizori.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yorizori.domain.Cookbook;
import yorizori.service.CookbookService;
import yorizori.service.ServiceFactory;
import yorizori.service.logic.CookbookServiceLogic;

@WebServlet("/cookbook/list.do")
public class CookbookListCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
//		CookbookService service = new CookBookServiceLogic();
		
		CookbookService service = ServiceFactory.getCookbookService();
		
		List<Cookbook> list = service.findAllCookbooks();
		request.setAttribute("cookbooks", list);
		request.getRequestDispatcher("/views/cookbookList.jsp").forward(request,response);
	}

}
