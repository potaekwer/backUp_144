package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Product;
import shop.service.facade.ProductService;
import shop.service.logic.ProductServiceLogic;

@WebServlet("/productList.do")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ProductService service = new ProductServiceLogic();
		
		
		List<Product> list = service.getAllProducts();
		
		request.setAttribute("products", list);
		
		request.getRequestDispatcher("productList.jsp").forward(request, response);
	
	
	
	
	}

}
