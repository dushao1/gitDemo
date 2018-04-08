package com.avicsafety.webapp.service;

import org.springframework.data.domain.Page;

import com.avicsafety.webapp.entity.SmartTips;


public interface SmartTipsService {


	Page<SmartTips> findSmartTipsByType(String regionGuid, String type, int page, int size);

	SmartTips saveSmartTips(SmartTips smartTips);

}
