package org.springkorea.persistence.mapper;

import java.util.List;

import org.springkorea.model.User;

public interface UserMapper {
	public User getUser(User user);

	public void createUser(User user);

	public void updateUser(User user);

	public void deleteUser(String uid);

	public List<User> getUsers();
}
