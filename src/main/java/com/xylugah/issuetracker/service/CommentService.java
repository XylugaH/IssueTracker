package com.xylugah.issuetracker.service;

import java.util.List;

import com.xylugah.issuetracker.entity.Comment;

public interface CommentService {

	Comment getById(int id);
	
	List<Comment> getAll();

	List<Comment> getByProjectId(int id);

	void add(Comment comment);

	void delete(int id);

	Comment edit(Comment comment);
}
