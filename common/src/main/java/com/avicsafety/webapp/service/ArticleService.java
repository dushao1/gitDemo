package com.avicsafety.webapp.service;

import java.util.List;

import com.avicsafety.webapp.entity.Article;


public interface ArticleService {
	public void AddArticle(Article article);
	public List<Article> findArticleByTitle(String title);
	public Article saveArticle(Article article);
	public Article findArticleById(long id);

}
