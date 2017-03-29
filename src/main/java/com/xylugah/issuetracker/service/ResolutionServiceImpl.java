package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.ResolutionDAO;
import com.xylugah.issuetracker.entity.Resolution;

@Service("ResolutionService")
public class ResolutionServiceImpl implements ResolutionService{

	@Autowired
	private ResolutionDAO dao;

	@Transactional
	@Override
	public Resolution getById(int id) {
		Resolution resolution = dao.getById(id);
		return resolution;
	}

	@Transactional
	@Override
	public List<Resolution> getAll() {
		List<Resolution> resolutionList = dao.getAll();
		return resolutionList;
	}

	@Transactional
	@Override
	public void add(Resolution resolution) {
		dao.add(resolution);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);		
	}

	@Transactional
	@Override
	public Resolution edit(Resolution resolution) {
		return dao.edit(resolution);
	}
}
