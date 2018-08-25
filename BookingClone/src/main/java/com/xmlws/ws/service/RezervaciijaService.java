package com.xmlws.ws.service;

import java.util.List;

import com.xmlws.ws.model.Rezervacija;

public interface RezervaciijaService {
	
	public Rezervacija findOne(Long id);
	public List<Rezervacija> findAll();
	public Rezervacija save(Rezervacija r);
	
}
