package com.xylugah.issuetracker.exception;

public class StatusNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -6160502702888300980L;

	public StatusNotFoundException(final int id){
		super("StatusNotFoundException with id="+id);
	}
}
