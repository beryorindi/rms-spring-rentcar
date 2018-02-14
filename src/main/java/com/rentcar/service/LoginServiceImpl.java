package com.rentcar.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.rentcar.entity.Role;
import com.rentcar.entity.User;
import com.rentcar.repository.RoleRepository;
import com.rentcar.repository.UserRepository;

@Service("userService")
public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepository userRepo;
	@Autowired
    private RoleRepository roleRepo;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.findByEmail(email);
	}

	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepo.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepo.save(user);
	}


}
