package com.xmlws.admin.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Smestaj;
import com.xmlws.admin.repository.SmRepository;
import com.xmlws.admin.service.SmService;

@Service
public class SmServiceImpl implements SmService{
	
	@Autowired
	private SmRepository repository;
	
	@Override
	public Smestaj save(Smestaj s) {
		return repository.save(s);
	}

	@Override
	public Smestaj findOne(String naziv) {
		return repository.findByNaziv(naziv);
	}

	@Override
	public List<Smestaj> getSmestajByAgent(String email) {
		return repository.findByAgentEmail(email);
	}

	@Override
	public List<Smestaj> findAll() {
		return repository.findAll();
	}

}
