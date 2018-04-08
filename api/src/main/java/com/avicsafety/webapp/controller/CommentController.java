package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.Comment;
import com.avicsafety.webapp.service.CommentService;


@RestController
public class CommentController {
 
	 @Autowired
	 CommentService CommentManager;
	
	 @RequestMapping(value="/api/comment/{id}")
	 public Comment findOne(@PathVariable long id) {
		 Comment comment= CommentManager.findCommentById(id);
		 return comment;
	 }
	 @RequestMapping(value="/api/comment/save")
	 public Comment saveArticle(@RequestBody Comment comment) {
		 return CommentManager.saveComment(comment);
	 }
	 @RequestMapping(value = "/api/comment/commentlist")
	 public Page<Comment> findlistByType(@RequestParam("guid") String guid,@RequestParam(defaultValue = "0") int pageIndex,@RequestParam(defaultValue = "10") int pageSize) {
		 Page<Comment> comment = CommentManager.findCommentByGuid(guid,pageIndex,pageSize);
		 return comment;
     }
}
