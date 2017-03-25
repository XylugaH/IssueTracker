package com.xylugah.issuetracker.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Resolution")
public class Resolucion {
	
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false)
	private String name;

	public Resolucion() {

	}

	public Resolucion(String name) {

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

	@Override
	public String toString() {
		return "Resolucion [name=" + name + "]";
	}
	
	
}
