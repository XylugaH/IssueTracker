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
		
		System.out.print(user);
		return user;
	}

	@Override
	public User getByEmail(String email) {
		return null;
	}
	
	@Override
	@Transactional
	public List<User> getAll() {
		List<User> user = dao.getAll();
		return user;
	}

	@Override
	public void add(User user) {
		
	}

	@Override
	public void delete(int id) {
	
	}

	@Override
	public User edit(User user) {
		return null;
	}

}
