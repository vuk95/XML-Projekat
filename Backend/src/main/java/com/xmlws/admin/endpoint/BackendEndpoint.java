package com.xmlws.admin.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xmlws.admin.backend.AddPonudaRequest;
import com.xmlws.admin.backend.AddPonudaResponse;
import com.xmlws.admin.backend.AddSmestajRequest;
import com.xmlws.admin.backend.AddSmestajResponse;
import com.xmlws.admin.backend.GetSmestajRequest;
import com.xmlws.admin.backend.GetSmestajResponse;
import com.xmlws.admin.backend.Smestaj;
import com.xmlws.admin.service.OfferSoapService;
import com.xmlws.admin.service.SmService;

@Endpoint
public class BackendEndpoint {
	
	@Autowired
	private SmService smestajService;
	
	@Autowired
	private OfferSoapService offerService;
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload AddSmestajRequest request) {
		AddSmestajResponse response = new AddSmestajResponse();
		
		response.setSmestaj(smestajService.save(request.getSmestaj()));
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

}
