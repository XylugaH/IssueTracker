package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Priority;

public class PriorityDAOImpl extends AbstractDAO<Integer, Priority> implements PriorityDAO{

	@Override
	public Priority getById(int id) {
		Priority priority = (Priority) getSession().get(Priority.class, id);
		return priority;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Priority> getAll() {
		List<Priority> priorityList = getSession().createCriteria(Priority.class).list();
		return priorityList;
	}

	@Override
	public void add(Priority priority) {
		getSession().saveOrUpdate(priority);
	}

	@Override
	public void delete(int id) {
		Priority priority = getById(id);
		if (priority!=null){
			getSession().delete(priority);
		}
	}

	@Override
	public Priority edit(Priority priority) {
		getSession().update(priority);
		return priority;
	}
}
