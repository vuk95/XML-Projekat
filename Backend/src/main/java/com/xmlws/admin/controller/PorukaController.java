package com.xmlws.admin.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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
		
		Calendar kalendar = Calendar.getInstance();
		Date datum = kalendar.getTime();
		
		poruka.setDatum(datum.toString());
		
		Poruka newMessage = porukaService.save(poruka); 
		
		return new ResponseEntity<>(newMessage,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/inbox/{id}" , method = RequestMethod.GET)
	public ResponseEntity<List<Poruka>> inbox(@PathVariable Long id) {
		
		ArrayList<Poruka> svePoruke = new ArrayList<Poruka>();
		ArrayList<Poruka> agentovePoruke = new ArrayList<Poruka>();
		
		Agent agent = agentService.findOne(id);
		
		svePoruke = (ArrayList<Poruka>) porukaService.findAll();
		
		for(int i=0;i<svePoruke.size();i++) {
			if(svePoruke.get(i).getAgent().equals(agent)) {
				agentovePoruke.add(svePoruke.get(i));
			}
			
		}
		
		return new ResponseEntity<>(agentovePoruke,HttpStatus.OK);
		
	}
	
		
}
