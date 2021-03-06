package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Project;

public interface ProjectService {

	Project getById(int id);
	
	List<Project> getAll();
	
	List<Project> getByPartName(String name);
	
	void add(Project project);
	
	void delete(int id);
	
	Project edit(Project project);
	
	Project getEmptyProject();
	
}
