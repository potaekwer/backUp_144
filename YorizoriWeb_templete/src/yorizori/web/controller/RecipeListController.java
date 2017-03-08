package yorizori.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yorizori.domain.Cookbook;
import yorizori.service.CookbookService;
import yorizori.service.ServiceFactory;

@WebServlet("/recipe/list.do")
public class RecipeListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		CookbookService service = ServiceFactory.getCookbookService();
		
		
		int cookbookId =  Integer.parseInt(request.getParameter("cdId"));
		Cookbook cookbook = service.findCookbook(cookbookId);
		
		request.setAttribute("cookbook", cookbook);
		
		request.getRequestDispatcher("/views/recipeList.jsp").forward(request, response);;
	
	}

}
