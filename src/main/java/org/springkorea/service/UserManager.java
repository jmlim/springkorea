package org.springkorea.service;

import java.util.List;

import org.springkorea.model.User;

public interface UserManager {
	public User getUserByIdAndPassword(String userId, String password);

	public User createUser(User user);

	public void updateUser(User user);

	public void deleteUser(User user);

	public List<User> getUsers();
}
