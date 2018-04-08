package com.avicsafety.webapp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.CommentRepository;
import com.avicsafety.webapp.entity.Comment;
import com.avicsafety.webapp.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	private static final Log logger = LogFactory.getLog(CommentServiceImpl.class);
	
	@Autowired
	CommentRepository dao;

	@Override
	public void AddComment(Comment comment) {
		// TODO Auto-generated method stub
		
	}
	/** 通过文章的guid查找评论*/
	@Override
	public Page<Comment> findCommentByGuid(String guid, int pageIndex, int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		return dao.findCommentByGuid(guid,pageable);
	}


	@Override
	public Comment saveComment(Comment comment) {
		return dao.save(comment);
	}
	@Override
	public Comment findCommentById(long id) {
		Comment comment= dao.findOne(id);
		return comment;
	}

}
