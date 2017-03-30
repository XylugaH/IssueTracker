package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.ProjectDAO;
import com.xylugah.issuetracker.entity.Project;

@Service("ProjectService")
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDAO dao;

	@Transactional
	@Override
	public Project getById(int id) {
		Project project = dao.getById(id);
		return project;
	}

	@Transactional
	@Override
	public List<Project> getAll() {
		List<Project> projectList = dao.getAll();
		return projectList;
	}

	@Transactional
	@Override
	public void add(Project project) {
		dao.add(project);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);		
	}

	@Transactional
	@Override
	public Project edit(Project project) {
		return dao.edit(project);
	}

}
