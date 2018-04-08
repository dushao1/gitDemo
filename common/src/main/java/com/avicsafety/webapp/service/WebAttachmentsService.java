package com.avicsafety.webapp.service;

import com.avicsafety.webapp.entity.WebAttachments;

public interface WebAttachmentsService {

	WebAttachments saveWebAttachments(WebAttachments webAttachments);

	WebAttachments findWebAttachmentsByPath(String path);

	void save(WebAttachments webAttachments);

	WebAttachments findWebAttachmentsById(long id);
}
