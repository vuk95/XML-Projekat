package com.xmlws.agent.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.service.SmestajImageService;
import com.xmlws.agent.service.SmestajService;


@Controller
public class ImageSmestajController {
	
	@Autowired
	private SmestajImageService imageService;

	@Autowired
	private SmestajService smestajService;
	
	 @GetMapping("imgsmestaji/{id}/image")
	    public String showUploadForm(@PathVariable Long id, ModelMap map){

	        map.put("smestaj",smestajService.findOne(id));

	        return "imageuploadform";
	    }
	    
	    @PostMapping("imgsmestaji/{id}/image")
	    public String handleImagePost(@PathVariable Long id, @RequestParam("imagefile") MultipartFile file){

	        imageService.saveImageFile(id,file);

	        
	        return "redirect:/smestaji/getSviSmestaji";
	    }
	   
	    @GetMapping("imgsmestaji/{id}/smestajiimage")
	    public void renderImageFromDB(@PathVariable Long id, HttpServletResponse response) throws IOException {
	    	
	    	Smestaj smestaj = smestajService.findOne(id);
	        
	        if(smestaj == null){
	            throw new RuntimeException("there is no smestaj with this id : " + id);
	        }

	        byte[] byteArray = new byte[smestaj.getSlika().length];
	        int i= 0;
	      
	        for(Byte wrappedByte : smestaj.getSlika() ){

	            byteArray[i++] = wrappedByte;
	        }
	        
	        response.setContentType("image/jpeg");
	        InputStream is = new ByteArrayInputStream(byteArray);
	        IOUtils.copy(is,response.getOutputStream());


	    }
	
}
