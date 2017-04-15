package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Issue;
import com.xylugah.issuetracker.entity.util.SearchBody;

public interface IssueDAO {
	
	Issue getById(int id);
	
	List<Issue> search(SearchBody searchBody);
	
	List<Issue> getAll();
	
	void add(Issue issue);
	
	void delete(int id);
	
	Issue edit(Issue issue);
	
}
