package com.xylugah.issuetracker.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xylugah.issuetracker.entity.AbstractEntity;

public abstract class AbstractDAO<PK extends java.io.Serializable, T extends AbstractEntity> {
	
	private SessionFactory sessionFactory;
	
	protected Session getSession(){
		return sessionFactory.getCurrentSession();
	}
}
