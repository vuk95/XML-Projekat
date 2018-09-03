package com.xmlws.agent.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.agent.model.Korisnik;
import com.xmlws.agent.model.Poruka;
import com.xmlws.agent.repository.PorukaRepository;
import com.xmlws.agent.service.PorukaService;

@Service
public class PorukaServiceImpl implements PorukaService{
	
	@Autowired
	private PorukaRepository repo;
	
	@Override
	public Poruka save(Poruka p) {
		return repo.save(p);
	}

	@Override
	public List<Poruka> findAll() {
		return repo.findAll();
	}

	@Override
	public Poruka findOne(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<Poruka> findByAgent(Korisnik agent) {
		return repo.findByAgent(agent);
	}

}
