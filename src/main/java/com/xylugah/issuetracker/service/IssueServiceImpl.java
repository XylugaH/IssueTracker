package com.xylugah.issuetracker.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.IssueDAO;
import com.xylugah.issuetracker.entity.AbstractEntity;
import com.xylugah.issuetracker.entity.Issue;

@Service("IssueService")
public class IssueServiceImpl implements IssueService {

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
	public List<Issue> search(String field, List<? extends AbstractEntity> list) {
		return dao.search(field, list);
	}

	@Transactional
	@Override
	public void add(Issue issue) {
		Date date = new Date();
		issue.setCreateDate(date);
		issue.setModifyDate(date);
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
		Date date = new Date();
		issue.setModifyDate(date);
		return dao.edit(issue);
	}

	@Override
	public Issue getEmptyIssue() {
		Issue issue = new Issue();
		return issue;
	}
}
