package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.User;


public interface UserService {
	
	User getById(int id);
	
	User getByEmail(String email);
	
	List<User> getByPartOfFirstName(String name);
	
	List<User> getByPartOfAllFields(String name);
	
	List<User> getAll();
	
	void add(User user);
	
	void delete(int id);
	
	User edit(User user);
	
	User getEmptyUser();
		
}
