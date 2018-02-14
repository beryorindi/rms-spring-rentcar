package com.rentcar.dao;

import java.util.List;

import com.rentcar.entity.User;

public interface UserDAO {
	List<User> getUserList();
	List<User> getAdminList();
	User getUserByEmail(String email);
	User getUserById(int id);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
}
