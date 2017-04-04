package com.xylugah.issuetracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name="Build")
public class Build extends AbstractEntity{
	
	@Id
	@Column(name="id")
	private int id;
	
	@NotEmpty
	@Size(min=3, max=45)
	@Column(name="name", nullable=false)
	private String name;

	@ManyToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	public Build() {

	}

	public Build(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Build [id=" + id + ", name=" + name + "]";
	}
	
	
}
