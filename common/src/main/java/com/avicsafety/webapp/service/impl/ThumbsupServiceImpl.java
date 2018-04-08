package com.avicsafety.webapp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.ThumbsupRepository;
import com.avicsafety.webapp.entity.Thumbsup;
import com.avicsafety.webapp.service.ThumbsupService;

@Service
public class ThumbsupServiceImpl implements ThumbsupService {
	
	private static final Log logger = LogFactory.getLog(ThumbsupServiceImpl.class);
	
	@Autowired
	ThumbsupRepository dao;

	@Override
	public void AddThumbsup(Thumbsup thumbsup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Thumbsup findThumbsupByGuidAndUsername(String guid,String username) {
		// TODO Auto-generated method stub
		return dao.findThumbsupByGuidAndUsername(guid,username);
	}

	@Override
	public Thumbsup saveThumbsup(Thumbsup thumbsup) {
		// TODO Auto-generated method stub
		Thumbsup thu = dao.findThumbsupByGuidAndUsername(thumbsup.getGuid(),thumbsup.getUsername());
		if(thu!=null){
			return thu;
		}else{
			return dao.save(thumbsup);
		}
	}
}
