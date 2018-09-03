package com.xmlws.admin.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.backend.Komentar;
import com.xmlws.admin.backend.RegistrovaniKorisnik;
import com.xmlws.admin.backend.Rezervacija;
import com.xmlws.admin.backend.Smestaj;
import com.xmlws.admin.service.KomentarService;
import com.xmlws.admin.service.RegistrovaniKorisnikService;
import com.xmlws.admin.service.RezervaciijaService;

@RestController
@RequestMapping(value = "/comments")
public class KomentarController {

	@Autowired
	private KomentarService komentarService;
	
	@Autowired
	private RezervaciijaService rezervacijaService;
	
	@Autowired
	private RegistrovaniKorisnikService registrovaniService;
	
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
	
	@CrossOrigin
	@RequestMapping(value = "/komentar/{id}" , method = RequestMethod.POST ,consumes="application/json")
	public ResponseEntity<Komentar> post(@PathVariable Long id,@RequestBody Komentar komentar) {
		
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		
		Smestaj smestaj = rezervacija.getPonuda().getSmestaj();
		
		komentar.setSmestaj(smestaj);
		komentar.setOdobren(false);
		
		Long userId = (long) 1;
		
		RegistrovaniKorisnik korisnik  = registrovaniService.findById(userId);
		komentar.setRegistrovaniKorisnik(korisnik);
		
		Komentar newComment = komentarService.save(komentar);
		
		return new ResponseEntity<>(newComment,HttpStatus.OK);
	}
	
	//ovde nesto kenja
	@CrossOrigin
	@RequestMapping(value = "/com/{id}" ,method = RequestMethod.GET )
	public ResponseEntity<List<Komentar>> getComments(@PathVariable Long id) {
		
		Rezervacija rezervacija = rezervacijaService.findOne(id);
		
		Smestaj smestaj = rezervacija.getPonuda().getSmestaj();
		
		List<Komentar> komentari = smestaj.getKomentar();
		
		return new ResponseEntity<>(komentari,HttpStatus.OK);
	}
}
