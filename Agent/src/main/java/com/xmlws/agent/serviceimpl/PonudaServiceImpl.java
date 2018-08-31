package com.xmlws.agent.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.agent.model.Ponuda;
import com.xmlws.agent.repository.PonudaRepository;
import com.xmlws.agent.service.PonudaService;

@Service
public class PonudaServiceImpl implements PonudaService{
	
	@Autowired
	private PonudaRepository repo;
	
	@Override
	public Ponuda save(Ponuda p) {
		return repo.save(p);
	}

	@Override
	public Ponuda findOne(Long id) {
		return repo.getOne(id);
	}

	@Override
	public List<Ponuda> findALl() {
		return repo.findAll();
	}

}
