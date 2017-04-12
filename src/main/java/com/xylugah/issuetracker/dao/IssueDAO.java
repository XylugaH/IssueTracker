package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Issue;

public interface IssueDAO {
	
	Issue getById(int id);
	
	List<Issue> getByName(String name);
	
	List<Issue> getAll();
	
	void add(Issue issue);
	
	void delete(int id);
	
	Issue edit(Issue issue);
	
}
