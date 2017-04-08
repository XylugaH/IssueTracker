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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

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
	private User createdBy = new User();
	
	@Column(name="modifyDate")
	@Temporal(TemporalType.DATE)
	private Date modifyDate;
	
	@OneToOne
	@JoinColumn(name = "modify_user_id")
	private User modifiedBy = new User();
	
	@NotEmpty
	@Size(min=3, max=45)
	@Column(name="summary", nullable=false)
	private String summary;
	
	@NotEmpty
	@Size(min=3, max=100)
	@Column(name="description", nullable=false)
	private String description;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;
	
	@OneToOne
	@JoinColumn(name = "resolution_id")
	private Resolution resolution;

	@NotNull
	@OneToOne
	@JoinColumn(name = "type_id")
	private Type type;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "priority_id")
	private Priority priority;
	
	@NotNull
	@OneToOne
	@JoinColumn(name = "project_id")
	private Project project;
	
	@OneToOne
	@JoinColumn(name = "assignee_user_id")
	private User assignee;


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public User getCreatedBy() {
		return createdBy;
	}



	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}



	public Date getModifyDate() {
		return modifyDate;
	}



	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}



	public User getModifiedBy() {
		return modifiedBy;
	}



	public void setModifiedBy(User modifiedBy) {
		this.modifiedBy = modifiedBy;
	}



	public String getSummary() {
		return summary;
	}



	public void setSummary(String summary) {
		this.summary = summary;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Status getStatus() {
		return status;
	}



	public void setStatus(Status status) {
		this.status = status;
	}



	public Resolution getResolution() {
		return resolution;
	}



	public void setResolution(Resolution resolution) {
		this.resolution = resolution;
	}



	public Type getType() {
		return type;
	}



	public void setType(Type type) {
		this.type = type;
	}



	public Priority getPriority() {
		return priority;
	}



	public void setPriority(Priority priority) {
		this.priority = priority;
	}



	public Project getProject() {
		return project;
	}



	public void setProject(Project project) {
		this.project = project;
	}



	public User getAssignee() {
		return assignee;
	}



	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}



	@Override
	public String toString() {
		return "Issue [id=" + id + ", createDate=" + createDate + ", createdBy=" + createdBy + ", modifyDate="
				+ modifyDate + ", modifiedBy=" + modifiedBy + ", summary=" + summary + ", description=" + description
				+ ", status=" + status + ", resolution=" + resolution + ", type=" + type + ", priority=" + priority
				+ ", project=" + project + ", assignee=" + assignee + "]";
	}

	
		
}
