package com.xylugah.issuetracker.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Comments")
public class Comment extends AbstractEntity{

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "createDate")
	@Temporal(TemporalType.DATE)
	private Date createDate;
	
	@Column(name = "comment")
	private String comment;
	
	@OneToOne
	@JoinColumn(name = "create_user_id")
	private User createdBy;
	
	@ManyToOne
	@JoinColumn(name = "issue_id")
	private Issue issue;

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

	
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public User getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(User createdBy) {
		this.createdBy = createdBy;
	}

	public Issue getIssue() {
		return issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Comment [ ");
		sb.append("id=").append(this.id).append(',');
		sb.append("date=").append(this.createDate.toString()).append(' ');
		sb.append("user=").append(this.createdBy.getFirstName()).append(' ');
		sb.append("]");
		return sb.toString();
	}
	
}
