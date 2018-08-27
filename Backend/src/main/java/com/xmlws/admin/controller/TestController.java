package com.xmlws.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.backend.Korisnik;
import com.xmlws.admin.service.KorisnikService;

@RestController
@RequestMapping(value = "/api/test")
public class TestController {

	@Autowired
	private KorisnikService korisnikService;
	
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<?> allUsers() {
		return new ResponseEntity<>(korisnikService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<Korisnik> getUserById(@PathVariable Long id) {
		return new ResponseEntity<Korisnik>(korisnikService.findById(id), HttpStatus.OK);
	}
}
