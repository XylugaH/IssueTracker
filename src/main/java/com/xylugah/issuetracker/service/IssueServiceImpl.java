package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.IssueDAO;
import com.xylugah.issuetracker.entity.Issue;

@Service("IssueService")
public class IssueServiceImpl implements IssueService{
	
	@Autowired
	private IssueDAO dao;

	@Transactional
	@Override
	public Issue getById(int id) {
		Issue issue = dao.getById(id);
		return issue;
	}

	@Transactional
	@Override
	public List<Issue> getAll() {
		List<Issue> issueList = dao.getAll();
		return issueList;
	}

	@Transactional
	@Override
	public void add(Issue issue) {
		dao.add(issue);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);		
	}

	@Transactional
	@Override
	public Issue edit(Issue issue) {
		return dao.edit(issue);
	}
}
