package com.xmlws.admin.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xmlws.admin.backend.AddSmestajRequest;
import com.xmlws.admin.backend.AddSmestajResponse;
import com.xmlws.admin.service.SmService;

@Endpoint
public class BackendEndpoint {
	
	@Autowired
	private SmService smestajService;
	
	@PayloadRoot(namespace = "admin.xmlws.com/backend",
            localPart = "addSmestajRequest")
    @ResponsePayload
    public AddSmestajResponse addSmestaj(@RequestPayload AddSmestajRequest request) {
		AddSmestajResponse response = new AddSmestajResponse();
		
		response.setSmestaj(smestajService.save(request.getSmestaj()));
        return response;
    }

}
