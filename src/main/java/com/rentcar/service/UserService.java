package com.rentcar.service;

import java.util.List;

import com.rentcar.entity.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
//	public List<User> findAll();
}
