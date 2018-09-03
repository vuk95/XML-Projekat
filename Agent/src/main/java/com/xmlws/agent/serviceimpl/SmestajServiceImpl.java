package com.xmlws.agent.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.agent.model.Agent;
import com.xmlws.agent.model.Korisnik;
import com.xmlws.agent.model.Smestaj;
import com.xmlws.agent.repository.SmestajRepository;
import com.xmlws.agent.service.SmestajService;

@Service
public class SmestajServiceImpl implements SmestajService{

	@Autowired
	private SmestajRepository repository;
	
	@Override
	public Smestaj save(Smestaj s) {
		return repository.save(s);
	}

	@Override
	public Smestaj findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Smestaj> findAll() {
		return repository.findAll();
	}

	@Override
	public List<Smestaj> findByAgent(Korisnik a) {
		return repository.findByAgent(a);
	}

}
