package com.xmlws.admin.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.backend.Ponuda;
import com.xmlws.admin.backend.Rezervacija;
import com.xmlws.admin.backend.Smestaj;
import com.xmlws.admin.converters.RezervacijaToRezervacijaDTO;
import com.xmlws.admin.service.PonudaService;
import com.xmlws.admin.service.RezervaciijaService;

@RestController
public class RezervacijaController {

	@Autowired
	private RezervaciijaService rezervacijaService;
	
	@Autowired
	private PonudaService ponudaService;
	
	@Autowired
	private RezervacijaToRezervacijaDTO toRezervacijaDTO;
	
	@CrossOrigin
	@RequestMapping(value = "/sve_rezervacije" , method = RequestMethod.GET)
	public ResponseEntity<List<Rezervacija>> getRezervacije() {
		
		List<Rezervacija> rezervacije = rezervacijaService.findAll();
		
		return new ResponseEntity<>(rezervacije,HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/rezervacija/{id}" , method = RequestMethod.POST , consumes="application/json")
	public ResponseEntity<?> reserve(@PathVariable Long id) {
		
		Ponuda ponuda = ponudaService.findOne(id);
		
		Rezervacija rezervacija = new Rezervacija();
		
		Calendar kalendar = Calendar.getInstance();
		Date datumRezervacije = kalendar.getTime();
		//dodato to string za datum realizacije
		rezervacija.setDatumRealizacije(datumRezervacije.toString());
		rezervacija.setPotvrdjeno(false);
		rezervacija.setPonuda(ponuda);
		
		Rezervacija newReservation = rezervacijaService.save(rezervacija);
		//Ponuda retPonuda = ponudaService.save(ponuda);
		
		return new ResponseEntity<>(toRezervacijaDTO.convert(newReservation),HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/otkazi/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Rezervacija> cancel(@PathVariable Long id) {
		
		Rezervacija rezervacija = rezervacijaService.delete(id);
		
		return new ResponseEntity<>(rezervacija,HttpStatus.OK);
	}
		
	//Na osnovu id-a rezervacije pokusavam da nadjem smestaj
	@CrossOrigin
	@RequestMapping(value = "/smestaj/{id}" , method = RequestMethod.GET)
	public ResponseEntity<Smestaj> getSmestaj(@PathVariable Long id) {
		
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		
		if(rezervacija == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Smestaj smestaj = rezervacija.getPonuda().getSmestaj();
		
		return new ResponseEntity<>(smestaj,HttpStatus.OK);
	}
}
