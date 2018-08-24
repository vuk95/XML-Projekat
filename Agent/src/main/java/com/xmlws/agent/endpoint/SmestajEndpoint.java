package com.xmlws.agent.endpoint;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.xmlws.agent.agent.*;


@Endpoint
public class SmestajEndpoint {

  @PayloadRoot(namespace = "agent.xmlws.com/agent", localPart = "GetSmestajDetailsRequest")
  @ResponsePayload
  public GetSmestajDetailsResponse processSmestajDetailsRequest(@RequestPayload GetSmestajDetailsRequest request) {
    GetSmestajDetailsResponse response = new GetSmestajDetailsResponse();
    
    Smestaj s = new Smestaj();
    s.setId(request.getId());
    s.setAgent(null);
    s.setKapacitet(5);
    s.setKategorija("b");
    s.setLokacija("Negotin");
    s.setOcena(4);
    s.setOpis("nako");
    s.setPonuda(null);
    s.setTip("2");
    
    response.setSmestaj(s);
    
    return response;
  }

}