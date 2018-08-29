package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.backend.RegistrovaniKorisnik;

public interface RegistrovaniKorisnikService {

	public RegistrovaniKorisnik findById(Long id);
	
	public List<RegistrovaniKorisnik> findAll();
	
	public RegistrovaniKorisnik save(RegistrovaniKorisnik korisnik);
	
	public RegistrovaniKorisnik delete(RegistrovaniKorisnik korisnik);
}
