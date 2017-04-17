package com.xylugah.issuetracker.exception;

public class TypeNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 5417713655600567858L;

	public TypeNotFoundException(final int id){
		super("TypeNotFoundException with id="+id);
	}
}
