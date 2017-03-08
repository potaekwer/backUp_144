package shop.service.logic;

import java.util.ArrayList;
import java.util.List;

import shop.domain.Product;
import shop.service.facade.ProductService;
import shop.store.facade.ProductStore;
import shop.store.logic.ProductStoreLogic;

public class ProductServiceLogic implements ProductService{
	
	private ProductStore store;
	
	
	public ProductServiceLogic(){
		store = new ProductStoreLogic();
	}
	
	

	@Override
	public List<Product> getAllProducts() {		
		return store.findAll();
	}

	@Override
	public List<Product> getBuyProducts(String[] serials) {
		List<Product> list = new ArrayList<>();
		
		for(String serial : serials){
			Product product = store.findByNo(Integer.parseInt(serial));
			if(product != null){
				list.add(product);
			}
		}
		
		return list;
	}

	@Override
	public Product getProduct(String serial) {
		return store.findByNo(Integer.parseInt(serial));
	}

}
