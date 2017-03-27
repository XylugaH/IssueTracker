package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Type;

public interface TypeDAO {
	Type getById(int id);
	
	List<Type> getAll();
	
	
}
