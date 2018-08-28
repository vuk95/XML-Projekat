package com.xmlws.admin.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xmlws.admin.dto.LoggedUserDTO;
import com.xmlws.admin.dto.LoginDTO;
import com.xmlws.admin.backend.Admin;
import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.backend.Korisnik;
import com.xmlws.admin.service.KorisnikService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private KorisnikService korisnikService;
	
	
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
	
	@CrossOrigin()
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
	
}
