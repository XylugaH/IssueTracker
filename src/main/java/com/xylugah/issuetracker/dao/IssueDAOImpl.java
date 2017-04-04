package com.xylugah.issuetracker.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Issue;

@Repository("IssueDAO")
public class IssueDAOImpl extends AbstractDAO<Integer, Issue> implements IssueDAO {

	@Override
	public Issue getById(int id) {
		Issue issue = (Issue) getSession().get(Issue.class, id);
		return issue;
	}

	@SuppressWarnings({ "unchecked"})
	@Override
	public List<Issue> getAll() {
		//List<Issue> issueList = getSession().createCriteria(Issue.class).list();
		List<Issue> issueList = (List<Issue>)getSession().createQuery("from Issue").list();
		return issueList;
	}

	@Override
	public void add(Issue issue) {
		getSession().saveOrUpdate(issue);
	}

	@Override
	public void delete(int id) {
		Issue issue = getById(id);
		if (issue!=null){
			getSession().delete(issue);
		}
	}

	@Override
	public Issue edit(Issue issue) {
		getSession().update(issue);
		return issue;
	}
}
