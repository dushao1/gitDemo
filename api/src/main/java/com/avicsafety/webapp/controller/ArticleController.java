package com.avicsafety.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.avicsafety.webapp.entity.Article;
import com.avicsafety.webapp.service.ArticleService;


@RestController
public class ArticleController {
 
	 @Autowired
	 ArticleService ArticleManager;
	
	 @RequestMapping(value="/api/article/{id}")
	 public Article findOne(@PathVariable long id) {
		 String art = org.springframework.web.util.HtmlUtils.htmlUnescape(ArticleManager.findArticleById(id).getContent());
		Article article= ArticleManager.findArticleById(id);
		article.setContent(art);
		 return article;
	 }
	 @RequestMapping(value="/api/article/save")
	 public Article saveArticle(@RequestBody Article article) {
		 return ArticleManager.saveArticle(article);
	 }
	 @RequestMapping(value = "/api/article/select")
	 public void find() {
    	 List<Article> article = ArticleManager.findArticleByTitle("aaa");
    	 System.out.println(article);
     }
}
