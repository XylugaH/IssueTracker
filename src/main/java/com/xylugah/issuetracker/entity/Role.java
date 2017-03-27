package com.xylugah.issuetracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Role")
public class Role extends AbstractEntity{
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;
	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean issueView;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean issueEdit;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean issueClose;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean issueReopen;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean issueAssignment;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean issueFind;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean userAdd;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean userFind;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean userEdit;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean userViewAllData;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean userEditAllData;	
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean projectAdd;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean projectEdit;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean statustEdit;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean resolutionAdd;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean resolucinEdit;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean priorityAdd;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean priorityEdit;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean typeAdd;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean typeEdit;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean messageGet;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean commentAdd;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean fileAdd;
	
	
	public Role() {
		
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


	public boolean isIssueView() {
		return issueView;
	}


	public void setIssueView(boolean issueView) {
		this.issueView = issueView;
	}


	public boolean isIssueEdit() {
		return issueEdit;
	}


	public void setIssueEdit(boolean issueEdit) {
		this.issueEdit = issueEdit;
	}


	public boolean isIssueClose() {
		return issueClose;
	}


	public void setIssueClose(boolean issueClose) {
		this.issueClose = issueClose;
	}


	public boolean isIssueReopen() {
		return issueReopen;
	}


	public void setIssueReopen(boolean issueReopen) {
		this.issueReopen = issueReopen;
	}


	public boolean isIssueAssignment() {
		return issueAssignment;
	}


	public void setIssueAssignment(boolean issueAssignment) {
		this.issueAssignment = issueAssignment;
	}


	public boolean isIssueFind() {
		return issueFind;
	}


	public void setIssueFind(boolean issueFind) {
		this.issueFind = issueFind;
	}


	public boolean isUserAdd() {
		return userAdd;
	}


	public void setUserAdd(boolean userAdd) {
		this.userAdd = userAdd;
	}


	public boolean isUserFind() {
		return userFind;
	}


	public void setUserFind(boolean userFind) {
		this.userFind = userFind;
	}


	public boolean isUserEdit() {
		return userEdit;
	}


	public void setUserEdit(boolean userEdit) {
		this.userEdit = userEdit;
	}


	public boolean isUserViewAllData() {
		return userViewAllData;
	}


	public void setUserViewAllData(boolean userViewAllData) {
		this.userViewAllData = userViewAllData;
	}


	public boolean isUserEditAllData() {
		return userEditAllData;
	}


	public void setUserEditAllData(boolean userEditAllData) {
		this.userEditAllData = userEditAllData;
	}


	public boolean isProjectAdd() {
		return projectAdd;
	}


	public void setProjectAdd(boolean projectAdd) {
		this.projectAdd = projectAdd;
	}


	public boolean isProjectEdit() {
		return projectEdit;
	}


	public void setProjectEdit(boolean projectEdit) {
		this.projectEdit = projectEdit;
	}


	public boolean isStatustEdit() {
		return statustEdit;
	}


	public void setStatustEdit(boolean statustEdit) {
		this.statustEdit = statustEdit;
	}


	public boolean isResolutionAdd() {
		return resolutionAdd;
	}


	public void setResolutionAdd(boolean resolutionAdd) {
		this.resolutionAdd = resolutionAdd;
	}


	public boolean isResolucinEdit() {
		return resolucinEdit;
	}


	public void setResolucinEdit(boolean resolucinEdit) {
		this.resolucinEdit = resolucinEdit;
	}


	public boolean isPriorityAdd() {
		return priorityAdd;
	}


	public void setPriorityAdd(boolean priorityAdd) {
		this.priorityAdd = priorityAdd;
	}


	public boolean isPriorityEdit() {
		return priorityEdit;
	}


	public void setPriorityEdit(boolean priorityEdit) {
		this.priorityEdit = priorityEdit;
	}


	public boolean isTypeAdd() {
		return typeAdd;
	}


	public void setTypeAdd(boolean typeAdd) {
		this.typeAdd = typeAdd;
	}


	public boolean isTypeEdit() {
		return typeEdit;
	}


	public void setTypeEdit(boolean typeEdit) {
		this.typeEdit = typeEdit;
	}


	public boolean isMessageGet() {
		return messageGet;
	}


	public void setMessageGet(boolean messageGet) {
		this.messageGet = messageGet;
	}


	public boolean isCommentAdd() {
		return commentAdd;
	}


	public void setCommentAdd(boolean commentAdd) {
		this.commentAdd = commentAdd;
	}


	public boolean isFileAdd() {
		return fileAdd;
	}


	public void setFileAdd(boolean fileAdd) {
		this.fileAdd = fileAdd;
	}


	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + "]";
	}

	
}
