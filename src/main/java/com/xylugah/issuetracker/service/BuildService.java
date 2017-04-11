package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Build;

public interface BuildService {

	Build getById(int id);
	
	List<Build> getAll();

	List<Build> getByProjectId(int id);

	void add(Build build);

	void delete(int id);

	Build edit(Build build);
}
