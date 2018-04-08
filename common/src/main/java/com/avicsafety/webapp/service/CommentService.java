package com.avicsafety.webapp.service;

import org.springframework.data.domain.Page;

import com.avicsafety.webapp.entity.Comment;

public interface CommentService {

	void AddComment(Comment comment);

	Page<Comment> findCommentByGuid(String guid, int pageIndex, int pageSize);

	Comment saveComment(Comment comment);

	Comment findCommentById(long id);

}
