package com.xylugah.issuetracker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xylugah.issuetracker.dao.CommentDAO;
import com.xylugah.issuetracker.entity.Comment;

@Service("CommentService")
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentDAO dao;

	@Transactional
	@Override
	public Comment getById(int id) {
		Comment comment = dao.getById(id);
		return comment;
	}

	@Transactional
	@Override
	public List<Comment> getAll() {
		List<Comment> comments = dao.getAll();
		return comments;
	}
	
	@Transactional
	@Override
	public List<Comment> getByProjectId(int id) {
		List<Comment> comments = dao.getByIssueId(id);
		return comments;
	}

	@Transactional
	@Override
	public void add(Comment comment) {
		dao.add(comment);
	}

	@Transactional
	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Transactional
	@Override
	public Comment edit(Comment comment) {
		return dao.edit(comment);
	}

}
