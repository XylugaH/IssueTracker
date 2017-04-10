package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.BuildDAO;
import com.xylugah.issuetracker.entity.Build;

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
	public List<Build> getByProjectId(int id) {
		List<Build> builds = dao.getByProjectId(id);
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
