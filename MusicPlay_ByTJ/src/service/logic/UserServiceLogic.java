package service.logic;

import domain.User;
import service.UserService;
import store.logic.UserStoreLogic;

public class UserServiceLogic implements UserService{

	private UserStoreLogic store;
	
	public UserServiceLogic(){
		store = new UserStoreLogic();
	}
	
	
	
	
	@Override
	public User login(User user) {
		return store.read(user.getLoginId());
	}

	@Override
	public boolean register(User user) {
		return store.create(user);
	}

	@Override
	public User find(String loginId) {
		return store.read(loginId);
	}

}
