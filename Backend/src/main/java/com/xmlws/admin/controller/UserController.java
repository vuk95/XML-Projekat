package com.xmlws.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.xmlws.admin.dto.LoginDTO;
import com.xmlws.admin.backend.Admin;
import com.xmlws.admin.backend.Korisnik;
import com.xmlws.admin.service.KorisnikService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private KorisnikService korisnikService;
	
	
//	@CrossOrigin
//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public ResponseEntity<?> login(@RequestBody LoginDTO dto) throws AuthenticationException {
//	
//		Authentication authentication = this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getLozinka()));
//		SecurityContextHolder.getContext().setAuthentication(authentication);
//		
//		return new ResponseEntity<>("Proslo je ok", HttpStatus.OK);
//	}
	
	
}
