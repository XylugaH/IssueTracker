package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Project;

@Repository("ProjectDAO")
public class ProjectDAOImpl extends AbstractDAO<Integer, Project> implements ProjectDAO{

	@Override
	public Project getById(int id) {
		Project project = (Project) getSession().get(Project.class, id);
		return project;
	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public List<Project> getAll() {
		List<Project> projectList = (List<Project>)getSession().createQuery("from Project").list();
		return projectList;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Project> getByPartName(String name){
		Criteria criteria = getSession().createCriteria(Project.class);
		criteria.add(Restrictions.ilike("name", name, MatchMode.ANYWHERE));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<Project> projects = (List<Project>) criteria.list();
		return projects;		
	}
	
	@Override
	public void add(Project project) {
		getSession().saveOrUpdate(project);
	}

	@Override
	public void delete(int id) {
		Project project = getById(id);
		if (project!=null){
			getSession().delete(project);
		}
	}

	@Override
	public Project edit(Project project) {
		getSession().update(project);
		return project;
	}
}
