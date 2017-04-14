package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.BuildDAO;
import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.entity.Project;

@Service("BuildService")
public class BuildServiceImpl implements BuildService{
	
	@Autowired
	private BuildDAO dao;

	@Transactional
	@Override
	public Build getById(int id) {
		Build build = dao.getById(id);
		return build;
	}

	@Transactional
	@Override
	public List<Build> getAll() {
		List<Build> builds = dao.getAll();
		return builds;
	}
	
	@Transactional
	@Override
	public List<Build> getByProject(Project project) {
		List<Build> builds = dao.getByProject(project);
		return builds;
	}

	@Transactional
	@Override
	public void add(Build build) {
		dao.add(build);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Transactional
	@Override
	public Build edit(Build build) {
		return dao.edit(build);
	}

}
