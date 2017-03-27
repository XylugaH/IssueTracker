package com.xylugah.issuetracker.entity;

import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="Build")
public class Build extends AbstractEntity{
	private int id;
	private String build;
}
