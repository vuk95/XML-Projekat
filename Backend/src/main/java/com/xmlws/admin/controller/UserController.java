package com.xmlws.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.dto.AgentFormDTO;
import com.xmlws.admin.dto.LoggedUserDTO;
import com.xmlws.admin.dto.LoginDTO;
import com.xmlws.admin.backend.Admin;
import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.backend.Korisnik;
import com.xmlws.admin.backend.RegistrovaniKorisnik;
import com.xmlws.admin.service.AgentService;
import com.xmlws.admin.service.KorisnikService;
import com.xmlws.admin.service.RegistrovaniKorisnikService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private KorisnikService korisnikService;
	
	@Autowired
	private RegistrovaniKorisnikService registrovaniKorisnikService;
	
	@Autowired
	private AgentService agentService;

	
	@CrossOrigin
	@RequestMapping(value = "/loginAdmin", method = RequestMethod.POST)
	public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO dto) {
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
	@PreAuthorize("isAuthenticated()")
	@RequestMapping(value = "/loggedIn", method = RequestMethod.GET)
	public ResponseEntity<?> getLoggedUser(HttpServletResponse response, HttpServletRequest request) {
		Korisnik korisnik = korisnikService.getCurrentUser();
		response.addCookie(request.getCookies()[0]);
		if(korisnik == null) {
			return new ResponseEntity<>(HttpStatus.MOVED_PERMANENTLY);
		}
		String role = "KORISNIK";
		if(korisnik instanceof Admin) {
			role = "ADMIN";
		} else if(korisnik instanceof Agent) {
			role = "AGENT";
		}
		
		return new ResponseEntity<>(new LoggedUserDTO(korisnik.getEmail(), role, korisnik.getId()), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<?> getRegistrovaniKorisnici() {
		
		return new ResponseEntity<>(registrovaniKorisnikService.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getRegistrovaniKorisnikById(@PathVariable Long id) {
		
		return new ResponseEntity<>(registrovaniKorisnikService.findById(id), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> blokirajRegistrovanogKorisnika(@PathVariable Long id) {
		RegistrovaniKorisnik korisnik = registrovaniKorisnikService.findById(id);
		if(korisnik.isZabranjen()) {
			korisnik.setZabranjen(false);
		} else {
			korisnik.setZabranjen(true);
		}
		registrovaniKorisnikService.save(korisnik);
		
		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> obrisiRegistrovanogKorisnika(@PathVariable Long id) {
		RegistrovaniKorisnik korisnik = registrovaniKorisnikService.findById(id);
		registrovaniKorisnikService.delete(korisnik);
		
		return new ResponseEntity<>(korisnik, HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/agents", method = RequestMethod.GET)
	public ResponseEntity<?> getAgenti() {
		return new ResponseEntity<>(agentService.findAll(), HttpStatus.OK);
	}
	
	@CrossOrigin
	@RequestMapping(value="/agents", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity<?> noviAgent(@RequestBody AgentFormDTO dto) {
		Agent agent = agentService.registerNew(dto);
		
		return new ResponseEntity<>(agent ,HttpStatus.OK);
	}
	
}
