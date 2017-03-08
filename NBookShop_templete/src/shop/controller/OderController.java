package shop.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shop.domain.Customer;
import shop.domain.Product;
import shop.service.facade.CustomerService;
import shop.service.facade.ProductService;
import shop.service.logic.CustomerServiceLogic;
import shop.service.logic.ProductServiceLogic;

@WebServlet("/order.do")
public class OderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
			CustomerService customerService = new CustomerServiceLogic();
			
			ProductService productService = new ProductServiceLogic();
			
			String [] serials = request.getParameterValues("buyItems");
			
			
			HttpSession session = request.getSession();
			String userId = (String)session.getAttribute("userId");
			
			Customer customer = customerService.getCustomer(userId);
			
			List<Product> list = productService.getBuyProducts(serials);
			
			request.setAttribute("customer", customer);
			request.setAttribute("products", list);
			request.getRequestDispatcher("orderForm.jsp").forward(request, response);
	
	
	}

}
