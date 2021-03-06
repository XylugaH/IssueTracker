package com.xylugah.issuetracker.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "issues")
public class Issue extends AbstractEntity {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "createDate")
	@Temporal(TemporalType.DATE)
	private Date createDate;

	@OneToOne
	@JoinColumn(name = "create_user_id")
	private User createdBy;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "modifyDate")
	@Temporal(TemporalType.DATE)
	private Date modifyDate;

	@OneToOne
	@JoinColumn(name = "modify_user_id")
	private User modifiedBy;

	@Column(name = "summary", nullable = false)
	private String summary;

	@Column(name = "description", nullable = false)
	private String description;

	@OneToOne
	@JoinColumn(name = "status_id")
	private Status status;

	@Transient
	private Status tempStatus;
	
	@OneToOne
	@JoinColumn(name = "resolution_id")
	private Resolution resolution;

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
	@JoinColumn(name = "build_id")
	private Build build;

	@OneToOne
	@JoinColumn(name = "assignee_user_id")
	private User assignee;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "issue", cascade = CascadeType.ALL)
	private List<Comment> comments;
	
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

	public Status getTempStatus() {
		return tempStatus;
	}

	public void setTempStatus(Status tempStatus) {
		this.tempStatus = tempStatus;
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

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	public User getAssignee() {
		return assignee;
	}

	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}

	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Issue [ ");
		sb.append("createDate=").append(this.createDate.toString()).append(',');
		sb.append("createdBy=").append(this.createdBy.getEmail()).append(' ');
		sb.append("modifyDate=").append(this.modifyDate.toString()).append(' ');
		sb.append("modifiedBy=").append(this.modifiedBy.getEmail()).append(' ');
		sb.append("status=").append(this.status.getName()).append(' ');
		sb.append("type=").append(this.type.getName()).append(' ');
		sb.append("priority=").append(this.priority.getName()).append(' ');
		sb.append("project=").append(this.project.getName()).append(' ');
		sb.append("build=").append(this.build.getName()).append(' ');
		sb.append("assignee=").append(this.assignee.getEmail()).append(' ');
		sb.append("]");
		return sb.toString();
	}

}
