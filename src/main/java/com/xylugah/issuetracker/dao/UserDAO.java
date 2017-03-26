package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.User;

public interface UserDAO {
	User getById(int id);
	
	List<User> getAll();
	
}
