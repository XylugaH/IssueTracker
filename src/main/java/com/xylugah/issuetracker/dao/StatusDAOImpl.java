package com.xylugah.issuetracker.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Status;

@Repository("StatusDAO")
public class StatusDAOImpl extends AbstractDAO<Integer,Status> implements StatusDAO{

	@Override
	public Status getById(int id) {
		Status status = (Status) getSession().get(Status.class, id);
		return status;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Status> getAll() {
		List<Status> statusList = getSession().createCriteria(Status.class).list();
		return statusList;
	}

	@Override
	public void add(Status status) {
		getSession().saveOrUpdate(status);
	}

	@Override
	public void delete(int id) {
		Status status = getById(id);
		if (status!=null){
			getSession().delete(status);
		}
	}

	@Override
	public Status edit(Status status) {
		getSession().update(status);
		return status;
	}

}
