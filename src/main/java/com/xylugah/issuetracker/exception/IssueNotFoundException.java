package com.xylugah.issuetracker.exception;

public class IssueNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2988660204785242020L;

	public IssueNotFoundException(final int id){
		super("IssueNotFoundException with id="+id);
	}
}
