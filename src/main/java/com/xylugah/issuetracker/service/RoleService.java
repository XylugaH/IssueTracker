package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Role;

public interface RoleService {

	Role getById(int id);
	
	List<Role> getAll();
	
	void add(Role role);
	
	void delete(int id);
	
	Role edit(Role role);
	
}
