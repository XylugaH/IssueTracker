package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.User;

@Repository("UserDAO")
public class UserDAOImpl extends AbstractDAO<Integer,User> implements UserDAO{

	@Override
	public User getById(int id) {
		User user = (User) getSession().get(User.class, id);
		if (user!=null){
			user.setPasswordConfirm(user.getPassword());	
		}
		return user;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<User> getAll() {
		List<User> users = getSession().createCriteria(User.class).list();
		return users;
	}

	@SuppressWarnings("deprecation")
	@Override
	public User getByEmail(String email) {
		Criteria criteria = getSession().createCriteria(User.class);
		User user = (User) criteria.add(Restrictions.eq("email", email)).uniqueResult();
		return user;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<User> getByPartName(String name){
		Criteria criteria = getSession().createCriteria(User.class);
		List<User> users = (List<User>) criteria.add(Restrictions.ilike("firstName", name, MatchMode.ANYWHERE)).list();
		return users;
	}
	
	@Override
	public void add(User user) {
		getSession().saveOrUpdate(user);		
	}

	@Override
	public void delete(int id) {
		User user = getById(id);
		if (user!=null){
			getSession().delete(user);
		}		
	}

	@Override
	public User edit(User user) {
		getSession().update(user);
		return user;
	}
	
	

}
