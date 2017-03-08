package shop.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {

	private Customer customer;
	private List<Product> products;
	private PaymentMethod payment;     // �������
	private String shipAddress; // ����� �ּ�
	
	public Order() {
		//
		this.products = new ArrayList<Product>();
	}
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Product> getProducts() {
		return products;
	}
	public PaymentMethod getPayment() {
		return payment;
	}
	public void setPayment(PaymentMethod payment) {
		this.payment = payment;
	}
	public String getShipAddress() {
		return shipAddress;
	}
	public void setShipAddress(String shipAddress) {
		this.shipAddress = shipAddress;
	}
	
	//--------------------------------------------------------------------------
	public void addProduct(Product product) {
		//
		products.add(product);
	}
	
	public int getTotalPrice() {
		//
		int total = 0;
		for (Product product : products) {
			total += product.getPrice();
		}
		return total;
	}
}
