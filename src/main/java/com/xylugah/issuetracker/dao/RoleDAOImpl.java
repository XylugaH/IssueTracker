package com.xylugah.issuetracker.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Role;

@Repository("RoleDAO")
public class RoleDAOImpl extends AbstractDAO<Integer, Role> implements RoleDAO{

	@Override
	public Role getById(int id) {
		Role role = (Role) getSession().get(Role.class, id);
		return role;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Role> getAll() {
		List<Role> roleList = getSession().createCriteria(Role.class).list();
		return roleList;
	}

	@Override
	public void add(Role role) {
		getSession().saveOrUpdate(role);
	}

	@Override
	public void delete(int id) {
		Role role = getById(id);
		if (role!=null){
			getSession().delete(role);
		}
	}

	@Override
	public Role edit(Role role) {
		getSession().update(role);
		return role;
	}
	
}
