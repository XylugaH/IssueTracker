package com.xylugah.issuetracker.dao;

import java.util.List;

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
		//List<Project> projectList = getSession().createCriteria(Project.class).list();
		List<Project> projectList = (List<Project>)getSession().createQuery("from Project").list();
		return projectList;
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
