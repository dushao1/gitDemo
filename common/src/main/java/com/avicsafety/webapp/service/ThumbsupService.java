package com.avicsafety.webapp.service;

import com.avicsafety.webapp.entity.Thumbsup;

public interface ThumbsupService {

	void AddThumbsup(Thumbsup thumbsup);

	Thumbsup saveThumbsup(Thumbsup thumbsup);

	Thumbsup findThumbsupByGuidAndUsername(String guid, String username);

}
