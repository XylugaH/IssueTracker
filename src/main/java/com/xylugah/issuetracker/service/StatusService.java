package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Status;

public interface StatusService {
	
	Status getById(int id);
	
	List<Status> getByName(String name);
	
	List<Status> getAll();
	
	void add(Status status);
	
	void delete(int id);
	
	Status edit(Status status);
	
	Status getEmptyStatus();
	
}
