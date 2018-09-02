package com.xmlws.admin.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Image;
import com.xmlws.admin.repository.ImageRepository;
import com.xmlws.admin.service.ImageService;

@Service
public class ImageServiceImpl implements ImageService{
	
	@Autowired
	private ImageRepository repo;
	
	@Override
	public Image save(Image img) {
		
		return repo.save(img);
	}

}
