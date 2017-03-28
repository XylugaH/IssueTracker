package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.StatusDAO;

import com.xylugah.issuetracker.entity.Status;

@Service("StatusService")
public class StatusServiceImpl implements StatusService{

	
	@Autowired
	private StatusDAO dao;

	@Transactional
	@Override
	public Status getById(int id) {
		Status status = dao.getById(id);
		return status;
	}

	@Transactional
	@Override
	public List<Status> getAll() {
		List<Status> statusList = dao.getAll();
		return statusList;
	}

	@Transactional
	@Override
	public void add(Status status) {
		dao.add(status);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);		
	}

	@Transactional
	@Override
	public Status edit(Status status) {
		return dao.edit(status);
	}
}
