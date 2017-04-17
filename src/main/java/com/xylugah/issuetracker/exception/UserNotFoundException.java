package com.xylugah.issuetracker.exception;

public class UserNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1537456539387385511L;

	public UserNotFoundException(final int id){
		super("UserNotFoundException with id="+id);
	}
}
