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
import org.springframework.transaction.annotation.Transactional;

import com.xmlws.admin.model.Korisnik;
import com.xmlws.admin.repository.KorisnikRepository;
import com.xmlws.admin.service.KorisnikService;

@Transactional
@Service
public class KorisnikServiceImpl implements KorisnikService {

	@Autowired
	private KorisnikRepository korisnikRepository;
	
	@Override
	public List<Korisnik> findAll() {
		return korisnikRepository.findAll();
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
		//Ovo treba promeniti u Admin, Agent, RegistrovaniKorisnik
		authority.add(new SimpleGrantedAuthority("USER"));
		Authentication authenitcation = new PreAuthenticatedAuthenticationToken(user.getId(), null, authority);
		SecurityContextHolder.getContext().setAuthentication(authenitcation);
	}

	/**
	 * Vraca ulogovanog korisnika
	 */
	@Override
	public Korisnik getCurrentUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		try {
			Long id = Long.parseLong(authentication.getName());
			
			return findById(id);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
