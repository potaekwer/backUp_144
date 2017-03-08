import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.Customer;
import store.CustomerSoreLogic;



public class CustomerStoreLogicTest {
	
	private CustomerSoreLogic store;
	
	@Before
	public void setUp(){
		store = new CustomerSoreLogic();
	}

//	@Test
//	public void testRegisterCustomer() {
//		Customer cus = new Customer();
//		cus.setAge(27);
//		cus.setName("정택진");
//		cus.setId("kimo");
//		assertEquals(1, store.registerCustomer(cus));
//	}
	
//	@Test
//	public void testSearchAll(){
//		assertNotNull(store.searchAll());
//		assertEquals("kimo", store.searchAll().get(0).getId());
//	}
	
	
//	@Test
//	public void testSearchById(){
//		assertNotNull(store.searchById("kimo"));
//		
//	}
	
	@Test
	public void testSearchByAge(){
		assertNotNull(store.searchByAge(25));
		assertEquals("kimo", store.searchByAge(25).get(0).getId());
		
	}
	
}
