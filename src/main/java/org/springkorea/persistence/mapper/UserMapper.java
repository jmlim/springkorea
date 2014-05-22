package org.springkorea.persistence.mapper;

import java.util.List;

import org.springkorea.model.User;

public interface UserMapper {
	public User getUser(String userId);

	public void createUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> getUsers();
}
