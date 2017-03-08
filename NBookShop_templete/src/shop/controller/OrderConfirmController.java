package shop.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.domain.Order;
import shop.domain.PaymentMethod;
import shop.service.facade.CustomerService;
import shop.service.facade.ProductService;
import shop.service.logic.CustomerServiceLogic;
import shop.service.logic.ProductServiceLogic;

@WebServlet("/orderConfirm.do")
public class OrderConfirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
			
			String [] serials = req.getParameterValues("serials");
			String userId = (String)req.getSession().getAttribute("userId");
			String approval = req.getParameter("approval");
			String shipAddress = req.getParameter("shipAddress");
			
			
			CustomerService customerService = new CustomerServiceLogic();
			ProductService productService = new ProductServiceLogic();
			
			Order order = new Order();
			
			order.setCustomer(customerService.getCustomer(userId));
			
			for(String serial : serials){
				order.addProduct(productService.getProduct(serial));
			}
			
			order.setShipAddress(shipAddress);
			order.setPayment(PaymentMethod.findBy(approval));
			
			req.setAttribute("order", order);
			
			req.getRequestDispatcher("orderConfirm.jsp").forward(req, resp);
	
	}

}
