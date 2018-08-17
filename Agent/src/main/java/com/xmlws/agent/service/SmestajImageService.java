package com.xmlws.agent.service;

import org.springframework.web.multipart.MultipartFile;

public interface SmestajImageService {

	void saveImageFile(Long smestajId, MultipartFile file);
	
}
