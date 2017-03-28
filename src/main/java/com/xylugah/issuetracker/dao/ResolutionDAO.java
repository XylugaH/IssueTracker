package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Resolution;

public interface ResolutionDAO {
	
	Resolution getById(int id);
	
	List<Resolution> getAll();
	
	void add(Resolution resolution);
	
	void delete(int id);
	
	Resolution edit(Resolution resolution);	
	
}
