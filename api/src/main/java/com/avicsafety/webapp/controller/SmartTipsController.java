package com.avicsafety.webapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.SmartTips;
import com.avicsafety.webapp.service.SmartTipsService;


@RestController
public class SmartTipsController {
 
	 @Autowired
	 SmartTipsService SmartTipsManager;
//	
//	 @RequestMapping(value="/api/SmartTips/{id}")
//	 public Article findOne(@PathVariable long id) {
//		 String art = org.springframework.web.util.HtmlUtils.htmlUnescape(ArticleManager.findArticleById(id).getContent());
//		Article article= ArticleManager.findArticleById(id);
//		article.setContent(art);
//		 return article;
//	 }
	 @RequestMapping(value="/api/smartTips/save")
	 public SmartTips saveSmartTips(@RequestBody SmartTips smartTips) {
		 return SmartTipsManager.saveSmartTips(smartTips);
	 }
	 @RequestMapping(value = "/api/smartTips/select")
	 public Page<SmartTips> find(@RequestParam("regionGuid") String regionGuid,@RequestParam("type") String type) {
    	 Page<SmartTips> smartTips = SmartTipsManager.findSmartTipsByType(regionGuid,type,0,10);
    	 return smartTips;
     }
}
