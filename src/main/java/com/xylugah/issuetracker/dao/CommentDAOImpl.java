package com.xylugah.issuetracker.dao;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.xylugah.issuetracker.entity.Comment;

@Repository("CommentDAO")
public class CommentDAOImpl extends AbstractDAO<Integer, Comment> implements CommentDAO {

	@Override
	public Comment getById(int id) {
		Comment comment = (Comment) getSession().get(Comment.class, id);
		return comment;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAll(){
		List<Comment> comments = (List<Comment>)getSession().createQuery("from Comment").list();
		return comments;
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Comment> getByIssueId(int id) {
		List<Comment> comments = getSession().createCriteria(Comment.class)
			    .add(Restrictions.eq("issue_id", id))
			    .list();
		return comments;
	}

	@Override
	public void add(Comment comment) {
		getSession().saveOrUpdate(comment);
	}

	@Override
	public void delete(int id) {
		Comment comment = getById(id);
		if (comment!=null){
			getSession().delete(comment);
		}
	}

	@Override
	public Comment edit(Comment comment) {
		getSession().update(comment);
		return comment;
	}
	
}
