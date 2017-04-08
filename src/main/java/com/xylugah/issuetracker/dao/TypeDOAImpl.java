package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Type;

@Repository("TypeDAO")
public class TypeDOAImpl extends AbstractDAO<Integer, Type> implements TypeDAO{

	@Override
	public Type getById(int id) {
		Type type = (Type) getSession().get(Type.class, id);
		return type;
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Type getByName(String name){
		Criteria criteria = getSession().createCriteria(Type.class);
		Type type = (Type) criteria.add(Restrictions.eq("name", name)).uniqueResult();
		return type;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Type> getAll() {
		List<Type> typeList = getSession().createCriteria(Type.class).list();
		return typeList;
	}

	@Override
	public void add(Type type) {
		getSession().saveOrUpdate(type);
	}

	@Override
	public void delete(int id) {
		Type type = getById(id);
		if (type!=null){
			getSession().delete(type);
		}
	}

	@Override
	public Type edit(Type type) {
		getSession().update(type);
		return type;
	}

}
