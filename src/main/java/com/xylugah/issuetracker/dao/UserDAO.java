package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.User;

public interface UserDAO {
	
	User getById(int id);
	
	List<User> getAll();
	
	User getByEmail(String email);
	
	List<User> getByName(String name);
	
	void add(User user);
	
	void delete(int id);
	
	User edit(User user);	
	
}
