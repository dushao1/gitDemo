package com.avicsafety.webapp.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.SafetyArticleColumnRepository;
import com.avicsafety.webapp.dao.SafetyArticleRepository;
import com.avicsafety.webapp.entity.SafetyArticle;
import com.avicsafety.webapp.entity.SafetyArticleColumn;
import com.avicsafety.webapp.service.SafetyArticleColumnService;
import com.avicsafety.webapp.service.SafetyArticleService;

@Service
public class SafetyArticleColumnServiceImpl implements SafetyArticleColumnService {
	
	private static final Log logger = LogFactory.getLog(SafetyArticleColumnServiceImpl.class);
	
	@Autowired
	SafetyArticleColumnRepository dao;

	@Override
	public void AddSafetyArticleColumn(SafetyArticleColumn safetyArticleColumn) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SafetyArticleColumn> findSafetyArticleColumnByColid(int colid) {
		// TODO Auto-generated method stub
		return dao.findSafetyArticleColumnByColid(colid);
	}

	@Override
	public SafetyArticleColumn saveSafetyArticleColumn(SafetyArticleColumn safetyArticleColumn) {
		return dao.save(safetyArticleColumn);
	}

}
