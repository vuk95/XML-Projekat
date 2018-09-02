package com.xmlws.agent.serviceimpl;

import java.io.IOException;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.xmlws.agent.back.AddImageRequest;
import com.xmlws.agent.back.AddImageResponse;
import com.xmlws.agent.back.AddSmestajRequest;
import com.xmlws.agent.back.AddSmestajResponse;
import com.xmlws.agent.back.BackendServicePort;
import com.xmlws.agent.back.BackendServicePortService;
import com.xmlws.agent.model.Image;
import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.repository.ImageRepository;
import com.xmlws.agent.repository.SmestajRepository;
import com.xmlws.agent.service.SmestajImageService;

@Service
public class SmestajImageServiceImpl implements SmestajImageService{
	
	@Autowired
	private SmestajRepository repo;
	
	@Autowired
	private ImageRepository imageRepo;
	
	@Override
	public void saveImageFile(Long smestajId, MultipartFile file) {
		try {
			Smestaj smestaj = repo.getOne(smestajId);
			Byte[] byteObjects = new Byte[file.getBytes().length];
			
			 int i = 0;
	            
	            for(byte b : file.getBytes()){
	                byteObjects[i++] =  b;
	            }
	            
	            Image image = new Image();
	            image.setSlika(byteObjects);
	            imageRepo.save(image);
	            smestaj.getMojeSlike().add(image);
	            //System.out.println(smestaj.getMojeSlike().size());
	            repo.save(smestaj);
	            
	            com.xmlws.agent.back.Image demoImage = new com.xmlws.agent.back.Image();
	    		System.out.println(image.getId());
	            demoImage.setId(image.getId());
	    		demoImage.setSlika(ArrayUtils.toPrimitive(image.getSlika()));
	            
	    		BackendServicePortService backServicePortService = new BackendServicePortService();
	    		BackendServicePort port = backServicePortService.getBackendServicePortSoap11();
	    		AddImageRequest imageRequest = new AddImageRequest();
	    		imageRequest.setImage(demoImage);
	    		AddImageResponse addImageResponse = port.addImage(imageRequest);
	    		
	    		System.out.println("upisana slika u bazu: " + addImageResponse.getImage().getId());
	    		
	    		com.xmlws.agent.back.Smestaj demoSmestaj = new com.xmlws.agent.back.Smestaj();
	    		demoSmestaj.setNaziv(smestaj.getNaziv());
	    		demoSmestaj.setAgent(null);
	    		demoSmestaj.setId(smestaj.getId());
	    		demoSmestaj.setKategorija(smestaj.getKategorija());
	    		demoSmestaj.setLokacija(smestaj.getLokacija());
	    		demoSmestaj.setOcena(smestaj.getOcena());
	    		demoSmestaj.setOpis(smestaj.getOpis());
	    		demoSmestaj.setTip(smestaj.getTip());
	    		demoSmestaj.setWifi(smestaj.isWifi());
	    		demoSmestaj.setTV(smestaj.isTv());
	    		demoSmestaj.setPolupansion(smestaj.isPolupansion());
	    		demoSmestaj.setPansion(smestaj.isPansion());
	    		demoSmestaj.setParking(smestaj.isParking());
	    		demoSmestaj.setKupatilo(smestaj.isKupatilo());
	    		demoSmestaj.setKuhinja(smestaj.isKuhinja());
	    		demoSmestaj.setDorucak(smestaj.isDorucak());
	    		demoSmestaj.setZauzet(smestaj.isZauzet());
	    		demoSmestaj.getImage().add(demoImage);
	    		
	    		AddSmestajRequest addSmestajRequest = new AddSmestajRequest();
	    		addSmestajRequest.setSmestaj(demoSmestaj);
	    		AddSmestajResponse addSmestajResponse = port.addSmestaj(addSmestajRequest);
	    		
	    		System.out.println("U glavnu bazu azuriran smestaj: " + addSmestajResponse.getSmestaj().getLokacija());
	    		
	            

		}catch (IOException e){

            e.printStackTrace();
        }
	}

	@Override
	public Image findOne(Integer id) {
		
		return imageRepo.getOne(id);
	}

}
