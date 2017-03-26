package com.xylugah.issuetracker.dao;

import com.xylugah.issuetracker.entity.User;

public interface UserDAO {
	User findById(int id);
	
}
