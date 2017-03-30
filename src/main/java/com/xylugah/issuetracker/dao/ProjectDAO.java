package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Project;

public interface ProjectDAO {
	
	Project getById(int id);
	
	List<Project> getAll();
	
	void add(Project project);
	
	void delete(int id);
	
	Project edit(Project project);
	
}
