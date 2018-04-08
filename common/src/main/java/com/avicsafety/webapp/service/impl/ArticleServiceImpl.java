package com.avicsafety.webapp.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.ArticleRepository;
import com.avicsafety.webapp.entity.Article;
import com.avicsafety.webapp.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {
	
	private static final Log logger = LogFactory.getLog(ArticleServiceImpl.class);
	
	@Autowired
	ArticleRepository dao;

	@Override
	public void AddArticle(Article article) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Article> findArticleByTitle(String title) {
		// TODO Auto-generated method stub
		return dao.findByTitleAndDelFalse(title);
	}

	@Override
	public Article saveArticle(Article article) {
		String art=article.getContent();
		article.setContent(org.springframework.web.util.HtmlUtils.htmlEscapeHex(art));
		// TODO Auto-generated method stub
		return dao.save(article);
	}
	@Override
	public Article findArticleById(long id) {
		return dao.findOne(id);
	}
}
