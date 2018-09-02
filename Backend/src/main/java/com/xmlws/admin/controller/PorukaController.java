package com.xmlws.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.backend.Poruka;
import com.xmlws.admin.backend.RegistrovaniKorisnik;
import com.xmlws.admin.service.AgentService;
import com.xmlws.admin.service.PorukaService;
import com.xmlws.admin.service.RegistrovaniKorisnikService;

@RestController
public class PorukaController {

	@Autowired
	private PorukaService porukaService;
	
	@Autowired
	private AgentService agentService;
	
	@Autowired
	private RegistrovaniKorisnikService registrovaniService;
	
	@CrossOrigin
	@RequestMapping(value = "/poruka/{id}" , method = RequestMethod.POST , consumes="application/json")
	public ResponseEntity<Poruka> send(@PathVariable Long id,@RequestBody Poruka poruka) {
		
		Agent agent = agentService.findOne(id);
			
		poruka.setAgent(agent);
		poruka.setProcitana(false);
		
		Long userId = (long) 1;
		
		RegistrovaniKorisnik korisnik  = registrovaniService.findById(userId);
		
		poruka.setRegistrovaniKorisnik(korisnik);
		
		Poruka newMessage = porukaService.save(poruka); 
		
		return new ResponseEntity<>(newMessage,HttpStatus.OK);
	}
	
}
