package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Issue;
import com.xylugah.issuetracker.entity.util.SearchBody;

public interface IssueService {
	
	Issue getById(int id);
	
	List<Issue> getAll();
	
	List<Issue> search(SearchBody searchBody);
	
	void add(Issue issue);
	
	void delete(int id);
	
	Issue edit(Issue issue);
	
	Issue getEmptyIssue();
	
}
