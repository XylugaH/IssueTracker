package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Priority;

public interface PriorityDAO {
	
	Priority getById(int id);
	
	Priority getByName(String name);
	
	List<Priority> getAll();
	
	void add(Priority priority);
	
	void delete(int id);
	
	Priority edit(Priority priority);
	
}
