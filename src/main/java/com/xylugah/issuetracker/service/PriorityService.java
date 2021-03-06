package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Priority;

public interface PriorityService {

	Priority getById(int id);
	
	Priority getByName(String name);
	
	List<Priority> getByPartName(String name);
	
	List<Priority> getAll();
	
	void add(Priority priority);
	
	void delete(int id);
	
	Priority edit(Priority priority);
	
	Priority getEmptyPriority();
	
}
