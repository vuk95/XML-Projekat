package com.xmlws.agent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.service.SmestajService;

//@RestController
//@RequestMapping("/smestaji")
public class SmestajController {
	/*
	@Autowired
	private SmestajService sm_service;
	
	@RequestMapping(value="getSviSmestaji", method = RequestMethod.GET)
	public ResponseEntity<List<Smestaj>> getSviSmestaji() {

		List<Smestaj> sviSmestaji = sm_service.findAll();

		return new ResponseEntity<>(sviSmestaji, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST, consumes="application/json")
	public ResponseEntity<Smestaj> addIndividuals(@RequestBody Smestaj smestaj){
				
		Smestaj newSmestaj = sm_service.save(smestaj);
		
		return new ResponseEntity<Smestaj>(newSmestaj, HttpStatus.OK);
	}
	*/
}
