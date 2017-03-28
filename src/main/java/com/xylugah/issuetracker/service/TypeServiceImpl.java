package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.TypeDAO;
import com.xylugah.issuetracker.entity.Type;

@Service("TypeService")
public class TypeServiceImpl implements TypeService{

	@Autowired
	private TypeDAO dao;

	@Transactional
	@Override
	public Type getById(int id) {
		Type type = dao.getById(id);
		return type;
	}

	@Transactional
	@Override
	public List<Type> getAll() {
		List<Type> typeList = dao.getAll();
		return typeList;
	}

	@Transactional
	@Override
	public void add(Type type) {
		dao.add(type);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);		
	}

	@Transactional
	@Override
	public Type edit(Type type) {
		return dao.edit(type);
	}
}
