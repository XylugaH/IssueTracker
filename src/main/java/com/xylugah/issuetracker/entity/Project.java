package com.xylugah.issuetracker.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Project")
public class Project extends AbstractEntity{
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(name="build", nullable=false)
	private String build;
	
	@OneToOne
	@JoinColumn(name = "manager_user_id")
	private User manager;
	
}
