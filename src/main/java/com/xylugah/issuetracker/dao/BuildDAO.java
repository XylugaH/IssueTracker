package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Build;

public interface BuildDAO {
	
	Build getById(int id);
	
	List<Build> getAll();
	
	List<Build> getByProjectId(int id);
	
	void add(Build build);
	
	void delete(int id);
	
	Build edit(Build build);
}
