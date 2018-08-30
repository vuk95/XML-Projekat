package com.xmlws.agent.service;

import java.util.List;

import com.xmlws.agent.model.Rezervacija;

public interface RezervacijaService {

	public List<Rezervacija> findAll();

	public Rezervacija findOne(Long id);
	
	public Rezervacija save(Rezervacija r);
	
}
