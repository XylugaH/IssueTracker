package com.xylugah.issuetracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Issue")
public class Issue extends AbstractEntity{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="createDate")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@OneToOne
	@JoinColumn(name = "create_user_id")
	private User createdBy;
	
	@Column(name="modifyDate")
	@Temporal(TemporalType.DATE)
	private Date modifyDate;
	
	@OneToOne
	@JoinColumn(name = "modify_user_id")
	private User modifiedBy;
	
	@Column(name="summary", nullable=false)
	private String summary;
	
	@Column(name="description", nullable=false)
	private String description;
	
	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;
	
	@OneToOne
	@JoinColumn(name = "type_id")
	private Type type;
	
	@OneToOne
	@JoinColumn(name = "priority_id")
	private Priority priority;
	
	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@OneToOne
	@JoinColumn(name = "assignee_user_id")
	private User assignee;
	
}
