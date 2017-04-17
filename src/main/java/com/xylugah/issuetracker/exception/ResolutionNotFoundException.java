package com.xylugah.issuetracker.exception;

public class ResolutionNotFoundException extends RuntimeException{

	private static final long serialVersionUID = -4924914939017465655L;

	public ResolutionNotFoundException(final int id){
		super("ResolutionNotFoundException with id="+id);
	}
}
