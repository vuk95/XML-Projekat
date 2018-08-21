package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.model.Korisnik;

public interface KorisnikService {
	
	public List<Korisnik> findAll();
	
	public Korisnik findById(Long id);
	
	public Korisnik findByEmail(String email);
	
	public void setCurrentUser(Korisnik user);
	
	public Korisnik getCurrentUser();
}
