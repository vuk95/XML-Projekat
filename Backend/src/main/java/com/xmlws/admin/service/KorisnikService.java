package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.model.Korisnik;

public interface KorisnikService {
	
	public List<Korisnik> findAll();
	
	public Korisnik findById(Long id);
	
	public void setCurrentUser(Korisnik user);
	
	public Korisnik getCurrentUser();
}
