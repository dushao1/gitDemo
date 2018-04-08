package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.Thumbsup;
import com.avicsafety.webapp.service.ThumbsupService;


@RestController
public class ThumbsupController {
 
	 @Autowired
	 ThumbsupService ThumbsupManager;
	
	 @RequestMapping(value="/api/thumbsup/save")
	 public Thumbsup saveThumbsup(@RequestBody Thumbsup thumbsup) {
		 return ThumbsupManager.saveThumbsup(thumbsup);
	 }
	 @RequestMapping(value = "/api/thumbsup/getthumbsup")
	 public Thumbsup findlistByType(@RequestParam("guid") String guid,@RequestParam("username") String username) {
		 Thumbsup thumbsup = ThumbsupManager.findThumbsupByGuidAndUsername(guid,username);
		 return thumbsup;
     }
}
