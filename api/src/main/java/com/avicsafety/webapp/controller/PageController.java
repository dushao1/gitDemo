package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.service.WebAttachmentsService;
import com.avicsafety.webapp.utils.StringUtils;


@RestController
public class PageController {
	@Autowired
	WebAttachmentsService WebAttachmentsManager;
	
	
	@RequestMapping(value="/api/page/show_img")
	public String show_img(@RequestParam("id")long id){
		String path = WebAttachmentsManager.findWebAttachmentsById(id).getPath();
		path = StringUtils.add("/",path);
		return path;
	}
	
}
