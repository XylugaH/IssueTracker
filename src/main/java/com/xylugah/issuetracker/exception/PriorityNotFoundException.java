package com.xylugah.issuetracker.exception;

public class PriorityNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 2911707617018516148L;

	public PriorityNotFoundException(final int id){
		super("PriorityNotFoundException with id="+id);
	}
}
