package com.dao;

import java.util.List;

import com.model.User;


public interface UserDao {
	
	public void saveUser(User user);

	public User getUserWithKey(String keyValue);

	public void updateUser(User user);

	public List<User> getAllUserAccounts();

	public User getUserById(int id);

	public void deleteUser(int id);

	public User verifyUserEmail(String email);

	public User verifyingAccount(String randomkey);

}
