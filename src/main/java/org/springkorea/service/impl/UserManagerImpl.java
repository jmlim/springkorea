package org.springkorea.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springkorea.model.User;
import org.springkorea.persistence.mapper.UserMapper;
import org.springkorea.service.UserManager;

@Transactional
@Service("userManager")
public class UserManagerImpl implements UserManager {

	@Autowired
	private UserMapper userMapper;

	/**
	 * @see org.springkorea.service.UserManager#getUser(java.lang.String)
	 */
	@Override
	public User getUser(String userId) {
		return userMapper.getUser(new User(userId));
	}

	/**
	 * @see org.springkorea.service.UserManager#createUser(org.springkorea.model.User)
	 */
	@Override
	public User createUser(User user) {
		userMapper.createUser(user);
		return userMapper.getUser(user);
	}

	/**
	 * @see org.springkorea.service.UserManager#updateUser(org.springkorea.model.User)
	 */
	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
	}

	/**
	 * @see org.springkorea.service.UserManager#deleteUser(java.lang.String)
	 */
	@Override
	public void deleteUser(String uid) {
		userMapper.deleteUser(uid);
	}

	/**
	 * @see org.springkorea.service.UserManager#getUsers()
	 */
	@Override
	public List<User> getUsers() {
		return userMapper.getUsers();
	}
}
