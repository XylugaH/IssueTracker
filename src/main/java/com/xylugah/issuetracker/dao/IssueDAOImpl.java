package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Issue;
import com.xylugah.issuetracker.entity.Priority;
import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.entity.User;
import com.xylugah.issuetracker.entity.util.SearchBody;

@Repository("IssueDAO")
public class IssueDAOImpl extends AbstractDAO<Integer, Issue> implements IssueDAO {

	@Override
	public Issue getById(int id) {
		Issue issue = (Issue) getSession().get(Issue.class, id);
		if (issue != null) {
			issue.setTempStatus(issue.getStatus());
		}
		return issue;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Issue> search(SearchBody searchBody) {
		Criteria criteria = getSession().createCriteria(Issue.class);
		Disjunction disjunction = Restrictions.disjunction();
		
		String value = searchBody.getValue();
		if (!value.isEmpty()){
			disjunction.add(Restrictions.ilike("summary", value, MatchMode.ANYWHERE));
			disjunction.add(Restrictions.ilike("description", value, MatchMode.ANYWHERE));
		}
		
		List<User> users = searchBody.getUsers();
		if(!users.isEmpty()){
			disjunction.add(Restrictions.in("assignee", users.toArray()));
		}

		List<Project> projects = searchBody.getProjects();
		if(!projects.isEmpty()){
			disjunction.add(Restrictions.in("project", projects.toArray()));
		}
		
		List<Priority> priorities = searchBody.getPriorities();
		if(!priorities.isEmpty()){
			disjunction.add(Restrictions.in("priority", priorities.toArray()));
		}
		
		List<Status> statuses = searchBody.getStatuses();
		if(!statuses.isEmpty()){
			disjunction.add(Restrictions.in("status", statuses.toArray()));
		}
		
		criteria.add(disjunction);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Issue> issues = criteria.list();
		
		return issues;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Issue> getAll() {
		List<Issue> issueList = (List<Issue>) getSession().createQuery("from Issue").list();
		return issueList;
	}

	@Override
	public void add(Issue issue) {
		getSession().saveOrUpdate(issue);
	}

	@Override
	public void delete(int id) {
		Issue issue = getById(id);
		if (issue != null) {
			getSession().delete(issue);
		}
	}

	@Override
	public Issue edit(Issue issue) {
		getSession().update(issue);
		return issue;
	}
}
