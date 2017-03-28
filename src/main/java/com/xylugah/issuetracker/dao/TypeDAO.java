package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Type;

public interface TypeDAO {
	
	Type getById(int id);
	
	List<Type> getAll();
	
	void add(Type type);
	
	void delete(int id);
	
	Type edit(Type type);	
	
}
