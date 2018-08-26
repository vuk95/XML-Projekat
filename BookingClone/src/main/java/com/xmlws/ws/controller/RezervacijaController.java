package com.xmlws.ws.controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.ws.model.Ponuda;
import com.xmlws.ws.model.Rezervacija;
import com.xmlws.ws.service.PonudaService;
import com.xmlws.ws.service.RezervaciijaService;

@RestController
public class RezervacijaController {

	@Autowired
	private RezervaciijaService rezervacijaService;
	
	@Autowired
	private PonudaService ponudaService;
	
	@RequestMapping(value = "/sve_rezervacije" , method = RequestMethod.GET)
	public ResponseEntity<List<Rezervacija>> getRezervacije() {
		
		List<Rezervacija> rezervacije = rezervacijaService.findAll();
		
		return new ResponseEntity<>(rezervacije,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/rezervacija/{id}" , method = RequestMethod.POST , consumes="application/json")
	public ResponseEntity<?> reserve(@PathVariable Long id) {
		
		Ponuda ponuda = ponudaService.findOne(id);
		
		Rezervacija rezervacija = new Rezervacija();
		
		Calendar kalendar = Calendar.getInstance();
		Date datumRezervacije = kalendar.getTime();
		rezervacija.setDatumRealizacije(datumRezervacije);
		rezervacija.setPotvrdjeno(false);
		rezervacija.setPonuda(ponuda);
		
		Rezervacija newReservation = rezervacijaService.save(rezervacija);
		//Ponuda retPonuda = ponudaService.save(ponuda);
		
		return new ResponseEntity<>(newReservation,HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/otkazi/{id}" , method = RequestMethod.DELETE)
	public ResponseEntity<Rezervacija> cancel(@PathVariable Long id) {
		
		Rezervacija rezervacija = rezervacijaService.delete(id);
		
		return new ResponseEntity<>(rezervacija,HttpStatus.OK);
	}
	
	
}
