package com.rentcar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentcar.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long>{
	
//	<List>User findbyRole(String role);
	User findByEmail(String email);
}
