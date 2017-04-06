package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Issue;

public interface IssueService {
	
	Issue getById(int id);
	
	List<Issue> getAll();
	
	void add(Issue issue);
	
	void delete(int id);
	
	Issue edit(Issue issue);
	
	Issue getEmptyIssue();
	
}
