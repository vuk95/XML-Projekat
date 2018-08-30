package com.xmlws.admin.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xmlws.admin.backend.Ponuda;
import com.xmlws.admin.repository.PonudaRepository;
import com.xmlws.admin.service.OfferSoapService;

@Service
public class OfferSoapServiceImpl implements OfferSoapService{
	
	@Autowired
	private PonudaRepository repository;
	
	@Override
	public Ponuda save(Ponuda p) {
		return repository.save(p);
	}

	@Override
	public Ponuda findOne(Long id) {
		return repository.getOne(id);
	}

}
