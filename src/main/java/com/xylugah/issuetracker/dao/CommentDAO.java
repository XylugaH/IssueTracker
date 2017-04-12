package com.xylugah.issuetracker.dao;

import java.util.List;

import com.xylugah.issuetracker.entity.Comment;

public interface CommentDAO {
	
	Comment getById(int id);
	
	List<Comment> getAll();
	
	List<Comment> getByIssueId(int id);
	
	void add(Comment comment);
	
	void delete(int id);
	
	Comment edit(Comment comment);
}