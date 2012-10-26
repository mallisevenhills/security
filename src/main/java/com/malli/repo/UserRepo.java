package com.malli.repo;

import org.springframework.data.repository.CrudRepository;

import com.malli.entity.User;



public interface UserRepo extends CrudRepository<User, Long> {
	
	 public User findByUsername(String username);

}
