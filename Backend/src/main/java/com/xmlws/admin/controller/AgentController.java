package com.xmlws.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.backend.Rezervacija;
import com.xmlws.admin.service.RezervaciijaService;

@RestController
@RequestMapping(value = "/agent")
public class AgentController {
	
	
	@Autowired
	private RezervaciijaService rezervacijaService;

	//Na osnovu id-a rezervacije pokusavam da nadjem agenta koji odgovara rezervaciji tog smestaja
	@CrossOrigin
	@RequestMapping(value = "/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Agent> getVlasnikSmestaja(@PathVariable Long id) {
		
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		
		if(rezervacija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Agent agent = rezervacija.getPonuda().getSmestaj().getAgent();
		
		return new ResponseEntity<>(agent,HttpStatus.OK);
	}
	
}
