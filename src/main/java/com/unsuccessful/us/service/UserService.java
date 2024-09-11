package com.unsuccessful.us.service;

import java.util.List;

import com.unsuccessful.us.entity.User;


public interface UserService {
	
	public User addUser(User userRequest);

	public List<User> getAllUsers();

	public User getUserById(Long id); 

}
