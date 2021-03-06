package com.rentcar.service;

import java.util.List;

import com.rentcar.entity.User;

public interface UserService {
	//List<User> findUserByName(String name);
	List<User> getUserList();
	List<User> getAdminList();
	User getUserById(int id);
	User getUserByEmail(String email);
	void addUser(User user);
	void updateUser(User user);
	void deleteUser(int id);
}
