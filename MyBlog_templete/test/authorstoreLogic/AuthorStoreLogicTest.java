package authorstoreLogic;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import blog.domain.Author;
import blog.store.logic.AuthorStoreLogic;

public class AuthorStoreLogicTest {

	private AuthorStoreLogic store;

	@Before
	public void setUp() {
		store = new AuthorStoreLogic();
	}

	
	// @Test
	// public void testFindAuthor() {
	// Author a = store.findAuthor("demonpark");
	// assertNotNull(a);
	// assertEquals("demonpark", a.getId());
	// }

	// @Test
	// public void testFindAllAuthors() {
	//
	// List<Author> list = store.findAllAuthors();
	// assertEquals(5, list.size());
	// assertEquals("한승용",list.get(0).getName());
	// }

//	 @Test
//	 public void testFindAuthorsByName() {
//
//	 List<Author> list = store.findAuthorsByName("김기사");
//	 
//	 	assertEquals(1, list.size());
//		assertEquals("김기사",list.get(0).getName());
//	 
//	 }
	
//	 @Test
//	 public void testRegistAuthor() {
//		 
//		 Author a = new Author();
//		 
//		 a.setId("kimo");
//		 a.setName("택진");
//		 a.setPassword("1111");
//		 a.setEmail("kimo3434");
//		 store.registAuthor(a);
//	 }
	
//	 @Test
//	 public void testUpdateAuthor() {
//		 Author a = new Author();
//		 a.setId("kimo");
//		 a.setName("택진");
//		 a.setPassword("2222");
//		 a.setEmail("kimo3434");
//		 store.updateAuthor(a);
//	 }
	//
//	 @Test
//	 public void testDeleteAuthor() {
//
//		 store.deleteAuthor("kimo");
//		 
//	 }
	//
	// @Test
	// public void testFindAuthorsByIds() {
	//
	//
	// List<String> ids = new ArrayList<>();
	// ids.add("demonpark");
	// ids.add("kimgisa");
	//
	//
	// List<Author> list = store.findAuthorsByIds(ids);
	// assertEquals(2, list.size(),3);
	// }
	//
//	@Test
//	public void testFindAuthorByCondition() {
//
//		Map<String, String> map = new HashMap<>();
//
//		map.put("id", "demonpark");
//		
//		List<Author> list = store.findAuthorByCondition(map);
//		
//		assertEquals(1, list.size());
//		map.remove("id");
//		
//		list = store.findAuthorByCondition(map);
//		assertEquals(5, list.size());
//		
//		
//		
//
//	}

}
