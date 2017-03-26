package com.xylugah.issuetracker.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.User;

@Repository("UserDAO")
public class UserDAOImpl extends AbstractDAO<Integer,User> implements UserDAO{

	@Override
	public User getById(int id) {
		User user = (User) getSession().get(User.class, id);
		return user;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> getAll() {
		List<User> userList = getSession().createCriteria(User.class).list();
		return userList;
	}
	
	

}
