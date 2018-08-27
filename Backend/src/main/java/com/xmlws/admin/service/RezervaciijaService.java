package com.xmlws.admin.service;

import java.util.List;

import com.xmlws.admin.model.Rezervacija;

public interface RezervaciijaService {
	
	public Rezervacija findOne(Long id);
	public List<Rezervacija> findAll();
	public Rezervacija save(Rezervacija r);
	//public void delete(Long id);
	public Rezervacija delete(Long id);
}
