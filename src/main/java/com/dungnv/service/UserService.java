package com.dungnv.service;

import java.util.List;

import com.dungnv.collection.User;

public interface UserService {
	public User save(User user);
	
	public User getById(String id);
	
	public List<User> getAll();
	
	public void delete(String id);
}
