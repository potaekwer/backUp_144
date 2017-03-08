package torizori.service.logic;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import yorizori.domain.User;
import yorizori.service.UserService;
import yorizori.service.logic.UserServiceLogic;

public class UserServiceLogicTest {
	private UserService service;
	
	@Before
	public void setUp(){
		this.service = new UserServiceLogic();
	}
	

	@Test
	public void testFindUser() {
		User user = service.findUser("kimgisa");
		
		assertEquals("kimgisa", user.getUserId());
		assertEquals("1234", user.getPassword());
		assertEquals("김기사", user.getName());
		
	}

	@Test
	public void testRegisterUser() {
		
		User user = new User();
		user.setUserId("testuser");
		user.setPassword("1234");
		user.setName("테스트");
		
		service.registerUser(user);
		
		user = service.findUser("testuser");
		
		assertEquals("testuser", user.getUserId());
		assertEquals("1234", user.getPassword());
		assertEquals("테스트", user.getName());
	}

}
