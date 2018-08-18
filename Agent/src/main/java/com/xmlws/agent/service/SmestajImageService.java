package com.xmlws.agent.service;

import org.springframework.web.multipart.MultipartFile;

import com.xmlws.agent.model.Image;

public interface SmestajImageService {

	void saveImageFile(Long smestajId, MultipartFile file);
	public Image findOne(Integer id);
	
}
