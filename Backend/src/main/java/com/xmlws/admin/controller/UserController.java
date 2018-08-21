package com.xmlws.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.dto.LoginDTO;
import com.xmlws.admin.model.Admin;
import com.xmlws.admin.model.Korisnik;
import com.xmlws.admin.service.KorisnikService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private KorisnikService korisnikService;
	
	@CrossOrigin
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public ResponseEntity<?> adminLogin(@RequestBody LoginDTO dto) {
		Korisnik user = korisnikService.findByEmail(dto.getEmail());

		if(user != null) {
			if(user instanceof Admin) {
				if(dto.getLozinka().equals(user.getLozinka())) {
					korisnikService.setCurrentUser(user);
					System.out.println("ULOGOVAO SE!");
					return new ResponseEntity<>("Uspesno ste se prijavili!", HttpStatus.OK);
				} else {
					return new ResponseEntity<>("Pogresna lozinka!", HttpStatus.BAD_REQUEST);
				}
			} else {
				return new ResponseEntity<>("Nemate prava pristupa!", HttpStatus.UNAUTHORIZED);
			}
		} else {
			return new ResponseEntity<>("Ne postoji admin sa tim emailom!", HttpStatus.BAD_REQUEST);
		}
	}
	
	@CrossOrigin
	@RequestMapping(value = "/current", method = RequestMethod.GET)
	public ResponseEntity<?> currentUser() {
		korisnikService.getCurrentUser();
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
