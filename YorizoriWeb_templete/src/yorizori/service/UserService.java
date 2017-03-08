package yorizori.service;

import yorizori.domain.User;

public interface UserService {
    
    User findUser(String userId);
    void registerUser(User user);
}
