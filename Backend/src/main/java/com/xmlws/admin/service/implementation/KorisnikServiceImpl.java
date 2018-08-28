package com.xmlws.admin.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Admin;
import com.xmlws.admin.backend.Agent;
import com.xmlws.admin.backend.Korisnik;
import com.xmlws.admin.repository.KorisnikRepository;
import com.xmlws.admin.service.KorisnikService;

@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Override
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
	}
	
	@Override
	public Korisnik findByEmail(String email) {
		return korisnikRepository.findByEmail(email);
	}
	
	@Override
	public Korisnik findById(Long id) {
		Optional<Korisnik> korisnik = korisnikRepository.findById(id);
		if(korisnik.isPresent()) {
			return korisnik.get();
		} else {
			return null;
		}
	}

	/**
	 * Loguje korisnika
	 */
	@Override
	public void setCurrentUser(Korisnik user) {
		Collection<GrantedAuthority> authority = new ArrayList<>();
		if(user instanceof Admin) {
			authority.add(new SimpleGrantedAuthority("ADMIN"));
		} else if(user instanceof Agent) {
			authority.add(new SimpleGrantedAuthority("AGENT"));
		} else {
			authority.add(new SimpleGrantedAuthority("KORISNIK"));
		}
		Authentication authenitcation = new PreAuthenticatedAuthenticationToken(user.getEmail(), null, authority);
		SecurityContextHolder.getContext().setAuthentication(authenitcation);
	}

	/**
	 * Vraca ulogovanog korisnika
	 */
	@Override
	public Korisnik getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		
		try {
			String email = authentication.getName();
			return findByEmail(email);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
