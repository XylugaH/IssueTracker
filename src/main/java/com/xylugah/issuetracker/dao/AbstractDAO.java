package com.xylugah.issuetracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.xylugah.issuetracker.entity.AbstractEntity;

public abstract class AbstractDAO<PK extends java.io.Serializable, T extends AbstractEntity> {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
