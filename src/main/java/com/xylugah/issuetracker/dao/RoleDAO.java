package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Role;

public interface RoleDAO {
	
	Role getById(int id);
	
	List<Role> getAll();
	
	void add(Role role);
	
	void delete(int id);
	
	Role edit(Role role);	
}
