package com.xmlws.admin.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xmlws.admin.backend.AddImageRequest;
import com.xmlws.admin.backend.AddImageResponse;
import com.xmlws.admin.backend.AddPonudaRequest;
import com.xmlws.admin.backend.AddPonudaResponse;
import com.xmlws.admin.backend.AddSmestajRequest;
import com.xmlws.admin.backend.AddSmestajResponse;
import com.xmlws.admin.backend.GetAllPonudaRequest;
import com.xmlws.admin.backend.GetAllPonudaResponse;
import com.xmlws.admin.backend.GetAllRezervacijaRequest;
import com.xmlws.admin.backend.GetAllRezervacijaResponse;
import com.xmlws.admin.backend.GetAllSmRequest;
import com.xmlws.admin.backend.GetAllSmResponse;
import com.xmlws.admin.backend.GetAllSmestajRequest;
import com.xmlws.admin.backend.GetAllSmestajResponse;
import com.xmlws.admin.backend.GetPonudaRequest;
import com.xmlws.admin.backend.GetPonudaResponse;
import com.xmlws.admin.backend.GetSmestajRequest;
import com.xmlws.admin.backend.GetSmestajResponse;
import com.xmlws.admin.backend.Ponuda;
import com.xmlws.admin.backend.Rezervacija;
import com.xmlws.admin.backend.Smestaj;
import com.xmlws.admin.backend.UpdateRezervacijaRequest;
import com.xmlws.admin.backend.UpdateRezervacijaResponse;
import com.xmlws.admin.service.ImageService;
import com.xmlws.admin.service.OfferSoapService;
import com.xmlws.admin.service.RezervaciijaService;
import com.xmlws.admin.service.SmService;

@Endpoint
public class BackendEndpoint {
	
	@Autowired
	private SmService smestajService;
	
	@Autowired
	private OfferSoapService offerService;
	
	@Autowired
	private RezervaciijaService rezService;
	
	@Autowired
	private ImageService imgService;
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload AddSmestajRequest request) {
		AddSmestajResponse response = new AddSmestajResponse();
		
		response.setSmestaj(smestajService.save(request.getSmestaj()));
        return response;
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "addImageRequest")
    @ResponsePayload
    public AddImageResponse addImage(@RequestPayload AddImageRequest request) {
		AddImageResponse response = new AddImageResponse();
		
		response.setImage(imgService.save(request.getImage()));
        return response;
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "addPonudaRequest")
    @ResponsePayload
    public AddPonudaResponse addPonuda(@RequestPayload AddPonudaRequest request) {
		AddPonudaResponse response = new AddPonudaResponse();
		
		response.setPonuda(offerService.save(request.getPonuda()));
        return response;
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "getSmestajRequest")
    @ResponsePayload
    public GetSmestajResponse getSmestaj(@RequestPayload GetSmestajRequest request) {
		GetSmestajResponse response = new GetSmestajResponse();
		
		
		Smestaj s = smestajService.findOne(request.getNaziv());
        System.out.println(s.getId());
        System.out.println(s.getTip());
        response.setSmestaj(s);
        return response;
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "updateRezervacijaRequest")
    @ResponsePayload
    public UpdateRezervacijaResponse updateRezervacija(@RequestPayload UpdateRezervacijaRequest request) {
		UpdateRezervacijaResponse response = new UpdateRezervacijaResponse();
		
		response.setRezervacija(rezService.save(request.getRezervacija()));
		
        return response;
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "getPonudaRequest")
    @ResponsePayload
    public GetPonudaResponse getPon(@RequestPayload GetPonudaRequest request) {
		GetPonudaResponse response = new GetPonudaResponse();
		
		
		Ponuda p = offerService.findOne(request.getId());
		response.setPonuda(p);
        return response;
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "getAllSmestajRequest")
    @ResponsePayload
    public GetAllSmestajResponse getAllSmestaj(@RequestPayload GetAllSmestajRequest request) {
		GetAllSmestajResponse response = new GetAllSmestajResponse();
		
		List<Smestaj> smestajList=smestajService.getSmestajByAgent(request.getEmail());
	
		response.setSmestaj(smestajList);
        return response;
        
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "getAllSmRequest")
    @ResponsePayload
    public GetAllSmResponse getAllSm(@RequestPayload GetAllSmRequest request) {
		GetAllSmResponse response = new GetAllSmResponse();
		
		List<Smestaj> smestajList=smestajService.findAll();
	
		response.setSmestaj(smestajList);
        return response;
        
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "getAllPonudaRequest")
    @ResponsePayload
    public GetAllPonudaResponse getAllPonuda(@RequestPayload GetAllPonudaRequest request) {
		GetAllPonudaResponse response = new GetAllPonudaResponse();
		
		List<Ponuda> ponudaList=offerService.findAll();
	
		response.setPonuda(ponudaList);
        return response;
        
    }
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "getAllRezervacijaRequest")
    @ResponsePayload
    public GetAllRezervacijaResponse getAllRezervacija(@RequestPayload GetAllRezervacijaRequest request) {
		GetAllRezervacijaResponse response = new GetAllRezervacijaResponse();
		
		List<Rezervacija> rezerList= rezService.findAll();
	
		response.setRezervacija(rezerList);
        return response;
        
    }
}
