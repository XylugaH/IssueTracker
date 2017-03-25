package com.xylugah.issuetracker.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.xylugah.issuetracker.entity.Role;
import com.xylugah.issuetracker.entity.User;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Override
	public User getById(int id) {
		return new User("Andrey","Olifenko","123","qwe@gmail.com",new Role());
	}

	@Override
	public User getByEmail(String email) {
		return null;
	}
	
	@Override
	public List<User> getAll() {
		List<User> user = new ArrayList<>();
		user.add(new User("Andrey","Olifenko","123","qwe@gmail.com",new Role()));
		user.add(new User("Admin","Admin","123","admin@gmail.com",new Role()));
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
