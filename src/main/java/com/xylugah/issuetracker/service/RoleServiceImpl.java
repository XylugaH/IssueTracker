package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.RoleDAO;
import com.xylugah.issuetracker.entity.Role;

@Service("RoleService")
public class RoleServiceImpl implements RoleService{
	
	@Autowired
	private RoleDAO dao;

	@Transactional
	@Override
	public Role getById(int id) {
		Role role = dao.getById(id);
		return role;
	}

	@Transactional
	@Override
	public List<Role> getAll() {
		List<Role> roleList = dao.getAll();
		return roleList;
	}

	@Transactional
	@Override
	public void add(Role role) {
		dao.add(role);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);		
	}

	@Transactional
	@Override
	public Role edit(Role role) {
		return dao.edit(role);
	}

}
