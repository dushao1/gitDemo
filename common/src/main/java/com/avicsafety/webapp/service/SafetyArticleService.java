package com.avicsafety.webapp.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.avicsafety.webapp.entity.SafetyArticle;

public interface SafetyArticleService {

	void AddSafetyArticle(SafetyArticle safetyArticle);

	SafetyArticle saveSafetyArticle(SafetyArticle safetyArticle);

	SafetyArticle findSafetyArticleById(long id);

	Page<SafetyArticle> findlistByTypeId(int type, int pageIndex, int pageSize);

	Page<SafetyArticle> findlistByColId(int typeid, int pageIndex, int pageSize);

	Page<SafetyArticle> findSafetyArticleByTitle(String title, int pageIndex, int pageSize);

}
