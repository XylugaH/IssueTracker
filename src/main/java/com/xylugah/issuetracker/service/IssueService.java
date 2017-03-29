package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Issue;
import com.xylugah.issuetracker.entity.User;

public interface IssueService {
	
	Issue getById(int id);
	
	List<Issue> getAll();
	
	void add(Issue issue);
	
	void delete(int id);
	
	User edit(Issue issue);
	
}
