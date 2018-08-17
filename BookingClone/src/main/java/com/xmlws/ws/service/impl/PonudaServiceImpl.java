package com.xmlws.ws.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.ws.model.Ponuda;
import com.xmlws.ws.repository.PonudaRepository;
import com.xmlws.ws.service.PonudaService;


@Service
public class PonudaServiceImpl implements PonudaService {

	@Autowired
	private PonudaRepository repository;
	
	@Override
	public Ponuda findOne(Long id) {
		return repository.getOne(id);
	}

	@Override
	public List<Ponuda> findAll() {
		return repository.findAll();
	}

	@Override
	public Ponuda save(Ponuda p) {
		return repository.save(p);
	}

	

	
	
	

		
	
}
