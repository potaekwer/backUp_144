package yorizori.store;

import yorizori.domain.User;

public interface UserStore {
    
    void create(User user);
    User retrieve(String userId);
}
