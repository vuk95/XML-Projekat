package com.xmlws.agent.service;

import java.util.List;

import com.xmlws.agent.model.Korisnik;
import com.xmlws.agent.model.Poruka;

public interface PorukaService {
	
	public Poruka save(Poruka p);
	public List<Poruka> findAll();
	public Poruka findOne(Long id);
	public List<Poruka> findByAgent(Korisnik agent);
	
}
