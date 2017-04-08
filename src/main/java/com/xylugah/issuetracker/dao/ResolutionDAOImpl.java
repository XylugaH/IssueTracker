package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Resolution;

@Repository("ResolutionDAO")
public class ResolutionDAOImpl extends AbstractDAO<Integer, Resolution> implements ResolutionDAO{

	@Override
	public Resolution getById(int id) {
		Resolution resolution = (Resolution) getSession().get(Resolution.class, id);
		return resolution;
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public Resolution getByName(String name){
		Criteria criteria = getSession().createCriteria(Resolution.class);
		Resolution resolution = (Resolution) criteria.add(Restrictions.eq("name", name)).uniqueResult(); 
		return resolution;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Resolution> getAll() {
		List<Resolution> resolutionList = getSession().createCriteria(Resolution.class).list();
		return resolutionList;
	}

	@Override
	public void add(Resolution resolution) {
		getSession().saveOrUpdate(resolution);
	}

	@Override
	public void delete(int id) {
		Resolution resolution = getById(id);
		if (resolution!=null){
			getSession().delete(resolution);
		}
	}

	@Override
	public Resolution edit(Resolution resolution) {
		getSession().update(resolution);
		return resolution;
	}

}
