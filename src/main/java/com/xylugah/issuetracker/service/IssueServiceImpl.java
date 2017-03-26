package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.xylugah.issuetracker.entity.Issue;
import com.xylugah.issuetracker.entity.User;

@Service("IssueService")
public class IssueServiceImpl implements IssueService{

	@Override
	public Issue getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Issue> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Issue issue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User edit(Issue issue) {
		// TODO Auto-generated method stub
		return null;
	}

}
