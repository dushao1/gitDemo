package com.avicsafety.webapp.service.impl;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.avicsafety.webapp.dao.SmartTipsRepository;
import com.avicsafety.webapp.entity.SmartTips;
import com.avicsafety.webapp.service.SmartTipsService;

@Service
public class SmartTipsServiceImpl implements SmartTipsService {
	
	private static final Log logger = LogFactory.getLog(SmartTipsServiceImpl.class);
	
	@Autowired
	SmartTipsRepository dao;


	public Page<SmartTips> findSmartTipsByType(String regionGuid, String type,int page,int size) {
		// TODO Auto-generated method stub
		Pageable pageable = new PageRequest(page, size);
		return dao.findSmartTipsByType(regionGuid,type,pageable);
	}

	@Override
	public SmartTips saveSmartTips(SmartTips smartTips) {
		// TODO Auto-generated method stub
		System.out.println(smartTips.getType()+"-------------------"+smartTips.getContent());
		SmartTips smart= dao.findOneByTypeAndContent(smartTips.getType(),smartTips.getContent(),smartTips.getRegionGuid());
		if (smart!=null) {
			int i=smart.getFrequency();
			i++;
			dao.updataSmartTipsById(i,new Date(),smart.getId().longValue());
			return smartTips;
		}else{
			return dao.save(smartTips);
		}
	}


}
