package com.rentcar.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rentcar.dao.UserDAOImpl;
import com.rentcar.entity.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserDAOImpl userDAO;
	
	/*@Override
	public List<User> findUserByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<User> getUserList() {
		return userDAO.getUserList();
	}

	@Override
	public List<User> getAdminList() {
		return userDAO.getAdminList();
	}

	@Override
	public User getUserById(int id) {
		return userDAO.getUserById(id);
	}

	@Override
	public void addUser(User user) {
		userDAO.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	@Override
	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	@Override
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}

}
