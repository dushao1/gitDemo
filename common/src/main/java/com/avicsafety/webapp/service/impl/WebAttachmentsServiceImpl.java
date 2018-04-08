package com.avicsafety.webapp.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.WebAttachmentsRepository;
import com.avicsafety.webapp.entity.WebAttachments;
import com.avicsafety.webapp.service.WebAttachmentsService;

@Service
public class WebAttachmentsServiceImpl implements WebAttachmentsService {
	
	private static final Log logger = LogFactory.getLog(WebAttachmentsServiceImpl.class);
	
	@Autowired
	WebAttachmentsRepository dao;

	@Override
	public WebAttachments saveWebAttachments(WebAttachments webAttachments) {
		return dao.save(webAttachments);
	}
	
	@Override
	public WebAttachments findWebAttachmentsByPath(String path) {
		return dao.findWebAttachmentsByPath(path);
	}
	
	@Override
	public WebAttachments findWebAttachmentsById(long id) {
		return dao.findWebAttachmentsById(id);
	}
	
	@Override
	public void save(WebAttachments webAttachments) {
		// TODO Auto-generated method stub
		
	}
}