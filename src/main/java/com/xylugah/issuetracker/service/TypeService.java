package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Type;

public interface TypeService {
	
	Type getById(int id);
	
	Type getByName(String name);
	
	List<Type> getAll();
	
	void add(Type type);
	
	void delete(int id);
	
	Type edit(Type type);
	
	Type getEmptyType();
	
}
