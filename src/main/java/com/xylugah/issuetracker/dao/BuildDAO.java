package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.entity.Project;

public interface BuildDAO {
	
	Build getById(int id);
	
	List<Build> getAll();
	
	List<Build> getByProject(Project project);
	
	void add(Build build);
	
	void delete(int id);
	
	Build edit(Build build);
}
