package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Priority;

@Repository("PriorityDAO")
public class PriorityDAOImpl extends AbstractDAO<Integer, Priority> implements PriorityDAO{

	@Override
	public Priority getById(int id) {
		Priority priority = (Priority) getSession().get(Priority.class, id);
		return priority;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Priority getByName(String name){
		Criteria criteria = getSession().createCriteria(Priority.class);
		Priority priority = (Priority) criteria.add(Restrictions.eq("name", name)).uniqueResult();
		return priority;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Priority> getByPartName(String name){
		Criteria criteria = getSession().createCriteria(Priority.class);
		List<Priority> priorities = (List<Priority>) criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE)).list();
		return priorities;
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
