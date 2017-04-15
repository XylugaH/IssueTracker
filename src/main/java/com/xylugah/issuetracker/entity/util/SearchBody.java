package com.xylugah.issuetracker.entity.util;

import java.util.List;

import com.xylugah.issuetracker.entity.Priority;
import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.entity.User;

public class SearchBody {

	private String value;
	
	private List<User> users;
	
	private List<Project> projects;
	
	private List<Status> statuses;
	
	private List<Priority> priorities;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public List<Status> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}

	public List<Priority> getPriorities() {
		return priorities;
	}

	public void setPriorities(List<Priority> priorities) {
		this.priorities = priorities;
	}	
}
