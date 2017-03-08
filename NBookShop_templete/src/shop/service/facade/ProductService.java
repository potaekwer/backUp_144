package shop.service.facade;

import java.util.List;

import shop.domain.Product;


/**
 * ProductService
 * 
 * @since 2016. 9. 28.
 * @author 진권기 (kwonkijin@nextree.co.kr)
 */
public interface ProductService {

	List<Product> getAllProducts();

	List<Product> getBuyProducts(String [] serials);
	
	Product getProduct(String serial);
}
