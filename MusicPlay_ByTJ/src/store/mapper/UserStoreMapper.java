package store.mapper;

import domain.User;

public interface UserStoreMapper {

	boolean create(User user);
	User read(String id);
}
