package com.avicsafety.webapp.service;

import java.util.List;

import com.avicsafety.webapp.entity.SafetyArticleColumn;

public interface SafetyArticleColumnService {

	List<SafetyArticleColumn> findSafetyArticleColumnByColid(int colid);

	SafetyArticleColumn saveSafetyArticleColumn(SafetyArticleColumn safetyArticleColumn);

	void AddSafetyArticleColumn(SafetyArticleColumn safetyArticleColumn);

}
