package com.xmlws.ws.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xmlws.ws.model.Rezervacija;
import com.xmlws.ws.repository.RezervacijaRepository;
import com.xmlws.ws.service.RezervaciijaService;

@Transactional
@Service
public class RezervacijaServiceImpl implements RezervaciijaService {

	@Autowired
	private RezervacijaRepository repository;
	
	@Override
	public Rezervacija findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Rezervacija> findAll() {
		return repository.findAll();
	}

	@Override
	public Rezervacija save(Rezervacija r) {
		return repository.save(r);
	}

}
