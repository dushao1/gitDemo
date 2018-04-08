package com.avicsafety.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.Article;
import com.avicsafety.webapp.entity.SafetyArticle;
import com.avicsafety.webapp.entity.SafetyArticleColumn;
import com.avicsafety.webapp.service.ArticleService;
import com.avicsafety.webapp.service.SafetyArticleColumnService;
import com.avicsafety.webapp.service.SafetyArticleService;


@RestController
public class SafetyArticleColumnController {
 
	 @Autowired
	 SafetyArticleColumnService SafetyArticleColumnManager;
	
	 @RequestMapping(value="/api/safetyarticlecolumn/save")
	 public SafetyArticleColumn saveSafetyArticleColumn(@RequestBody SafetyArticleColumn safetyArticleColumn) {
		 return SafetyArticleColumnManager.saveSafetyArticleColumn(safetyArticleColumn);
	 }
	 @RequestMapping(value = "/api/safetyarticlecolumn/select")
	 public List<SafetyArticleColumn> find(@RequestParam("colid") int colid) {
    	 List<SafetyArticleColumn> safetyArticleColumn = SafetyArticleColumnManager.findSafetyArticleColumnByColid(colid);
    	 return safetyArticleColumn;
     }
}
