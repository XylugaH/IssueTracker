package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.PriorityDAO;
import com.xylugah.issuetracker.entity.Priority;

@Service("PriorityService")
public class PriorityServiceImpl implements PriorityService{

	@Autowired
	private PriorityDAO dao;

	@Transactional
	@Override
	public Priority getById(int id) {
		Priority priority = dao.getById(id);
		return priority;
	}

	@Transactional
	@Override
	public Priority getByName(String name){
		Priority priority = dao.getByName(name);
		return priority;
	}
	
	@Transactional
	@Override
	public List<Priority> getAll() {
		List<Priority> priorityList = dao.getAll();
		return priorityList;
	}

	@Transactional
	@Override
	public void add(Priority priority) {
		dao.add(priority);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);		
	}

	@Transactional
	@Override
	public Priority edit(Priority priority) {
		return dao.edit(priority);
	}

	@Override
	public Priority getEmptyPriority() {
		Priority priority = new Priority();
		return priority;
	}
}
