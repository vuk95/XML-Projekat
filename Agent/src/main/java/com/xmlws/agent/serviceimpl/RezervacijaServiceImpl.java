package com.xmlws.agent.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.agent.model.Rezervacija;
import com.xmlws.agent.repository.RezervacijaRepository;
import com.xmlws.agent.service.RezervacijaService;

@Service
public class RezervacijaServiceImpl implements RezervacijaService{
	
	@Autowired
	private RezervacijaRepository rezRepository;
	
	@Override
	public List<Rezervacija> findAll() {
		return rezRepository.findAll();
	}

	@Override
	public Rezervacija findOne(Long id) {
		return rezRepository.getOne(id);
	}

	@Override
	public Rezervacija save(Rezervacija r) {
		return rezRepository.save(r);
	}

}
