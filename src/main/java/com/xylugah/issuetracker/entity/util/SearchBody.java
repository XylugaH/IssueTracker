package com.xylugah.issuetracker.entity.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import com.xylugah.issuetracker.entity.Priority;
import com.xylugah.issuetracker.entity.Project;
import com.xylugah.issuetracker.entity.Status;
import com.xylugah.issuetracker.entity.User;

@Component
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SearchBody {

	private static final Field DEFAULT_SORT_FIELD=Field.ID;
	
	private String value;

	private boolean ASC;

	private Field field;

	private List<User> users;

	private List<Project> projects;

	private List<Status> statuses;

	private List<Priority> priorities;

	public SearchBody() {
		this.value = "";
		this.ASC = true;
		this.field = DEFAULT_SORT_FIELD;
		this.users = new ArrayList<User>();
		this.projects = new ArrayList<Project>();
		this.statuses = new ArrayList<Status>();
		this.priorities = new ArrayList<Priority>();
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean getASC() {
		return ASC;
	}

	public void setASC(boolean aSC) {
		ASC = aSC;
	}

	public Field getField() {
		return field;
	}

	public void setField(Field field) {
		this.field = field;
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
	
	public enum Field{
		
		ID("id"), PRIORITY("priority"), ASSIGNEE("assignee"), TYPE("type"), STATUS ("status"), SUMMARY("summary");
		
		private String name;
		
		private Field(String name){
			this.name = name;
		}

		public String getName() {
			return name;
		}
	}
}
