package yorizori.service.logic;

import yorizori.domain.User;
import yorizori.service.UserService;
import yorizori.store.StoreFactory;
import yorizori.store.UserStore;
import yorizori.store.jdbc.JdbcStoreFactory;

public class UserServiceLogic implements UserService{
	
	private UserStore store;
	
	public UserServiceLogic(){
		
		StoreFactory factory = new JdbcStoreFactory();
		store = factory.getUserStore();
		
	}
	

	@Override
	public User findUser(String userId) {	
		
		return store.retrieve(userId);
	}

	@Override
	public void registerUser(User user) {

		
		store.create(user);
		
	}
	
	

}
