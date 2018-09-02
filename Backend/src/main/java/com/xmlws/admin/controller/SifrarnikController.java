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

import com.xmlws.admin.backend.Sifrarnik;
import com.xmlws.admin.dto.SifrarnikDTO;
import com.xmlws.admin.service.SifrarnikService;

@RestController
@RequestMapping(value = "/codes")
public class SifrarnikController {
	
	@Autowired
	private SifrarnikService sifrarnikService;
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<>(sifrarnikService.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> novaSifra(@RequestBody SifrarnikDTO dto) {
		Sifrarnik sifra = sifrarnikService.novaSifra(dto);
		
		return new ResponseEntity<>(sifra, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getOne(@PathVariable Long id) {
		return new ResponseEntity<>(sifrarnikService.findOne(id), HttpStatus.OK);
	}
	
	

}
