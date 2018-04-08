package com.avicsafety.webapp.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.SafetyArticleRepository;
import com.avicsafety.webapp.entity.SafetyArticle;
import com.avicsafety.webapp.service.SafetyArticleService;

@Service
public class SafetyArticleServiceImpl implements SafetyArticleService {
	
	private static final Log logger = LogFactory.getLog(SafetyArticleServiceImpl.class);
	
	@Autowired
	SafetyArticleRepository dao;

	@Override
	public void AddSafetyArticle(SafetyArticle safetyArticle) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Page<SafetyArticle> findSafetyArticleByTitle(String title, int pageIndex, int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		return dao.findSafetyArticleByTitle("%"+title+"%",pageable);
	}

	@Override
	public SafetyArticle saveSafetyArticle(SafetyArticle safetyArticle) {
		String art=safetyArticle.getContent();
		safetyArticle.setContent(org.springframework.web.util.HtmlUtils.htmlEscapeHex(art));
		// TODO Auto-generated method stub
		return dao.save(safetyArticle);
	}
	@Override
	public SafetyArticle findSafetyArticleById(long id) {
		 SafetyArticle safetyArticle= dao.findOne(id);
		 String art = org.springframework.web.util.HtmlUtils.htmlUnescape(dao.findOne(id).getContent());
		 int views = dao.findOne(id).getViews()+1;
		 dao.updataSafetyArticleById(views,id);
		 safetyArticle.setContent(art);
		return safetyArticle;
	}

	@Override
	public Page<SafetyArticle> findlistByTypeId(int type, int pageIndex, int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		return dao.findSafetyArticleByType(type,pageable);
	}
	@Override
	public Page<SafetyArticle> findlistByColId(int colid, int pageIndex, int pageSize) {
		Pageable pageable = new PageRequest(pageIndex, pageSize);
		return dao.findSafetyArticleByColId(colid,pageable);
	}
}
