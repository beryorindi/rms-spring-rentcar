package com.rentcar.service;

import java.util.List;

import com.rentcar.entity.User;

public interface LoginService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
}
