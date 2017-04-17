package com.xylugah.issuetracker.exception;

public class ProjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -567733678897816110L;

	public ProjectNotFoundException(final int id){
		super("ProjectNotFoundException with id="+id);
	}
}
