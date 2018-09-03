package com.xmlws.agent.service;

import java.util.List;

import com.xmlws.agent.model.Agent;
import com.xmlws.agent.model.Korisnik;
import com.xmlws.agent.model.Smestaj;

public interface SmestajService {

	public Smestaj save(Smestaj s);
	public Smestaj findOne(Long id);
	public List<Smestaj> findAll();
	public List<Smestaj> findByAgent(Korisnik a);
	
}
