package com.xylugah.issuetracker.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.UserDAO;
import com.xylugah.issuetracker.entity.User;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDAO dao;
	
	@Override
	@Transactional
	public User getById(final int id) {
		User user = dao.getById(id);
		return user;
	}

	@Override
	@Transactional
	public User getByEmail(String email) {
		User user = dao.getByEmail(email);
		return user;
	}
	
	@Override
	@Transactional
	public List<User> getAll() {
		List<User> user = dao.getAll();
		return user;
	}

	@Override
	@Transactional
	public void add(User user) {
		dao.add(user);
	}

	@Override
	@Transactional
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	@Transactional
	public User edit(User user) {
		return dao.edit(user);
	}

	@Override
	public User getEmptyUser() {
		User user = new User();
		return user;
	}

	
}
