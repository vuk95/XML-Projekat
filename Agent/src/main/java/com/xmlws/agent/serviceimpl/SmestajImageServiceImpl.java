package com.xmlws.agent.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.repository.SmestajRepository;
import com.xmlws.agent.service.SmestajImageService;

@Service
public class SmestajImageServiceImpl implements SmestajImageService{
	
	@Autowired
	private SmestajRepository repo;
	
	@Override
	public void saveImageFile(Long smestajId, MultipartFile file) {
		try {
			Smestaj smestaj = repo.getOne(smestajId);
			Byte[] byteObjects = new Byte[file.getBytes().length];
			
			 int i = 0;
	            
	            for(byte b : file.getBytes()){
	                byteObjects[i++] =  b;
	            }
	            

	            smestaj.setSlika(byteObjects);
	            
	            repo.save(smestaj);

		}catch (IOException e){

            e.printStackTrace();
        }
	}

}
