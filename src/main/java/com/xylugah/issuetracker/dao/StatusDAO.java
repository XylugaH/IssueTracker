package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Status;

public interface StatusDAO {
	
	Status getById(int id);
	
	List<Status> getByPartName(String name);
	
	List<Status> getAll();
	
	void add(Status status);
	
	void delete(int id);
	
	Status edit(Status status);
	
}
