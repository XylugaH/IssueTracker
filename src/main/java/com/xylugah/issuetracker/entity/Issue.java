package com.xylugah.issuetracker.entity;

public class Issue extends AbstractEntity{
	
	private int id;
	
	private String summary;
	private String description;
	private Status status;
	private Type type;
	private Priority priority;
	private Project project;
	
}
