package shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Order;
import shop.service.facade.OrderService;
import shop.service.logic.OrderServiceLogic;

@WebServlet("/orderComplete.do")
public class ComleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		Order order = (Order) request.getSession().getAttribute("order");
		OrderService service = new OrderServiceLogic();
		
		if(service.order(order)){
			response.sendRedirect("complete.html");
		}
		
	
	}

}
