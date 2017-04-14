package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Build;
import com.xylugah.issuetracker.entity.Project;

@Repository("BuildDAO")
public class BuildDAOImpl extends AbstractDAO<Integer, Build> implements BuildDAO {

	@Override
	public Build getById(int id) {
		Build build = (Build) getSession().get(Build.class, id);
		return build;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Build> getAll(){
		List<Build> buildList = (List<Build>)getSession().createQuery("from Build").list();
		return buildList;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Build> getByProject(Project project) {
		List<Build> builds = getSession().createCriteria(Build.class)
			    .add(Restrictions.eq("project", project))
			    .list();
		return builds;
	}

	@Override
	public void add(Build build) {
		getSession().saveOrUpdate(build);
	}

	@Override
	public void delete(int id) {
		Build build = getById(id);
		if (build!=null){
			getSession().delete(build);
		}
	}

	@Override
	public Build edit(Build build) {
		getSession().update(build);
		return build;
	}
	
}
