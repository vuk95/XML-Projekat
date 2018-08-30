package com.xmlws.admin.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.backend.Komentar;
import com.xmlws.admin.service.KomentarService;

@RestController
@RequestMapping(value = "/comments")
public class KomentarController {

	@Autowired
	private KomentarService komentarService;
	
	@CrossOrigin
	@RequestMapping(value = "/unapproved", method = RequestMethod.GET)
	public ResponseEntity<?> getNeodobreneKomentare() {
		
		return new ResponseEntity<>(komentarService.nadjiNeodobrene(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/unapproved/number", method = RequestMethod.GET)
	public Map<?, Integer> brojNeodobrenihKomentara() {
		List<Komentar> komentari = komentarService.nadjiNeodobrene();
		int number = komentari.size();
		
		return Collections.singletonMap("response", number);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getKomentarById(@PathVariable Long id) {
		return new ResponseEntity<>(komentarService.findById(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> odobriKomentar(@PathVariable Long id) {
		Komentar komentar = komentarService.findById(id);
		komentar.setOdobren(true);
		komentarService.save(komentar);
		
		return new ResponseEntity<>(komentar, HttpStatus.OK);
	}
	
}
